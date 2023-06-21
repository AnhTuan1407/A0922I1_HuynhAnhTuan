package codegym.vn.repository;

import codegym.vn.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface IProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByNameProductContaining (String name);
}
