package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService{
    IProductRepository iProductRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) throws SQLException {
        iProductRepository.save(product);
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return iProductRepository.update(product);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return iProductRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }
}
