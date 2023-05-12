package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product) throws SQLException;

    boolean update(Product product) throws SQLException;

    boolean delete(int id) throws SQLException;

    Product findById(int id);

    List<Product> searchByName(String name);
}
