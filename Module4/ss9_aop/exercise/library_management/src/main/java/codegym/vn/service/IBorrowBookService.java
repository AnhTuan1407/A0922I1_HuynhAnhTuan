package codegym.vn.service;

import codegym.vn.entity.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();

    boolean create(BorrowBook borrowBook);

    boolean update(BorrowBook borrowBook);

    boolean deleteById(Integer id);

    BorrowBook findById(Integer id);
}
