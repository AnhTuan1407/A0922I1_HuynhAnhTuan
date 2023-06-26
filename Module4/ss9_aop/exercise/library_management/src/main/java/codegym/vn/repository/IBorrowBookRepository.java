package codegym.vn.repository;

import codegym.vn.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
}
