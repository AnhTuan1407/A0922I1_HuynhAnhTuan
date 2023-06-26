package codegym.vn.service.impl;

import codegym.vn.entity.Book;
import codegym.vn.entity.BorrowBook;
import codegym.vn.repository.IBookRepository;
import codegym.vn.repository.IBorrowBookRepository;
import codegym.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public boolean create(Book book) {
        if (iBookRepository.existsById(book.getId())){
            return false;
        }
        iBookRepository.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        if (iBookRepository.existsById(book.getId())){
            iBookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iBookRepository.deleteById(id);
        return true;
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }
}
