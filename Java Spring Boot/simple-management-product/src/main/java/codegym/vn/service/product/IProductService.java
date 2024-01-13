package codegym.vn.service.product;

import codegym.vn.entity.Category;
import codegym.vn.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean create(Product product);

    boolean update(Product product);

    boolean deleteById(Integer id);

    Product findById(Integer id);

    List<Product> findAllByNameContaining(String name);
}
