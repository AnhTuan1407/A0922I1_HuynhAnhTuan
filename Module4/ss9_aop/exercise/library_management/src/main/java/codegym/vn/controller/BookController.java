package codegym.vn.controller;

import codegym.vn.service.IBookService;
import codegym.vn.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private IBorrowBookService iBorrowBookService;

    @Autowired
    private IBookService iBookService;

    @GetMapping("/listbook")
    public String showListBook(Model model){
        model.addAttribute("book", iBookService.findAll());
        return "library/listBook";
    }
}
