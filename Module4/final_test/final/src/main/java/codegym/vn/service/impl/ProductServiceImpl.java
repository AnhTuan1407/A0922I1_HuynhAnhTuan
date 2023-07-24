package codegym.vn.service.impl;

import codegym.vn.entity.Product;
import codegym.vn.repository.ProductRepository;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public boolean create(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findByProductNameContaining̣̣̣̣̣̣(String productName, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(productName, pageable);
    }

    @Override
    public Page<Product> findByPrice(double price, Pageable pageable) {
        return productRepository.findAllByPrice(price, pageable);
    }


    @Override
    public Page<Product> findByCategory(String category, Pageable pageable) {
        return productRepository.findAllByCategory(category, pageable);
    }
}
