package codegym.vn.service;

import codegym.vn.entity.Category;
import codegym.vn.entity.Product;
import codegym.vn.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) iProductRepository.findAll();
    }

    @Override
    public boolean create(Product product) {
        iProductRepository.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (iProductRepository.existsById(product.getId())) {
            iProductRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iProductRepository.deleteById(id);
        return true;
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return iProductRepository.findAllByNameProductContaining(name);
    }
}
