package codegym.vn.service;

import codegym.vn.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Page<Product> findAllPaging(Pageable pageable);

    boolean create(Product product);

    boolean update(Product product);

    boolean deleteById(Integer id);

    Product findById(Integer id);

    Page<Product> findByProductNameContaining̣̣̣̣̣̣(String productName, Pageable pageable);

    Page<Product> findByPrice(double price, Pageable pageable);

    Page<Product> findByCategory(String category, Pageable pageable);
}
