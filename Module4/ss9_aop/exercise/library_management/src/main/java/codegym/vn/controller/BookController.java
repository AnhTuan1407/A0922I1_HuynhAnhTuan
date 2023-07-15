package codegym.vn.controller;

import codegym.vn.entity.Book;
import codegym.vn.entity.BorrowBook;
import codegym.vn.service.IBookService;
import codegym.vn.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private IBorrowBookService iBorrowBookService;

    @Autowired
    private IBookService iBookService;

    @GetMapping("/listbook")
    public String showListBook(Model model) {
        model.addAttribute("book", iBookService.findAll());
        return "library/listBook";
    }

    @GetMapping("/listuser")
    public String showListUser(Model model) {
        model.addAttribute("borrowBook", iBorrowBookService.findAll());
        return "library/listUser";
    }

    @GetMapping("/borrow")
    public String showBorrowForm(@RequestParam("id") Integer id, Model model) throws ParseException {
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setUserId((int) (10000 + Math.random() * 9999));
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        borrowBook.setBorrowedDate(date);
        model.addAttribute("books", iBookService.findById(id));
        borrowBook.setBook(iBookService.findById(id));
        model.addAttribute("borrowBook", borrowBook);
        return "library/borrow";
    }

    @PostMapping("/borrow")
    public String doBorrow(@ModelAttribute("borrowBook") BorrowBook borrowBook, BindingResult bindingResult) {
        new BorrowBook().validate(borrowBook, bindingResult);
        if (bindingResult.hasErrors()){
            return "library/borrow";
        }else {
            Book book = iBookService.findById(borrowBook.getBook().getId());
            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
            }
            borrowBook.setBook(book);
            iBorrowBookService.create(borrowBook);
            return "redirect:/library/listuser";
        }
    }

    @GetMapping("/pay")
    public String showPay(@RequestParam("userId") Integer userId, Model model) {
        BorrowBook borrowBook = iBorrowBookService.findById(userId);
        model.addAttribute("user", borrowBook);
        model.addAttribute("books", iBookService.findById(borrowBook.getBook().getId()));
        return "/library/pay";
    }

    @PostMapping("/pay")
    public String doPay(@ModelAttribute("borrowBook") BorrowBook borrowBook) throws ParseException {
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        borrowBook.setPayDay(date);
        borrowBook.setStatus(true);
        borrowBook.getBook().setQuantity(borrowBook.getBook().getQuantity() + 1);
        iBorrowBookService.update(borrowBook);
        return "redirect:/library/listuser";
    }
}
