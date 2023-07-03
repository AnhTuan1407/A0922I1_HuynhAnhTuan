package codegym.vn.service.impl;

import codegym.vn.entity.BorrowBook;
import codegym.vn.repository.IBorrowBookRepository;
import codegym.vn.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowBookServiceImpl implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;

    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepository.findAll();
    }

    @Override
    public boolean create(BorrowBook borrowBook) {
        if (iBorrowBookRepository.existsById(borrowBook.getUserId()) || ((borrowBook.getBook().getQuantity()) <= 0)){
            return false;
        }
        iBorrowBookRepository.save(borrowBook);
        return true;
    }

    @Override
    public boolean update(BorrowBook borrowBook) {
        if (iBorrowBookRepository.existsById(borrowBook.getUserId())){
            iBorrowBookRepository.save(borrowBook);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iBorrowBookRepository.deleteById(id);
        return true;
    }

    @Override
    public BorrowBook findById(Integer id) {
        return iBorrowBookRepository.findById(id).orElse(null);
    }
}
