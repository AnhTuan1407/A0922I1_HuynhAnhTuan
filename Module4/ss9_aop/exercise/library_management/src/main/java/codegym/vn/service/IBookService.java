package codegym.vn.service;

import codegym.vn.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    boolean create(Book book);

    boolean update(Book book);

    Book findById(Integer id);

    boolean deleteById(Integer id);
}
