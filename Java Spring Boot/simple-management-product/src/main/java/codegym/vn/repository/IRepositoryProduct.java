package codegym.vn.repository;

import codegym.vn.entity.Category;
import codegym.vn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String name);
}
