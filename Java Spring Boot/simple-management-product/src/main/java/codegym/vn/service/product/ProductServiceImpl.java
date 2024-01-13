package codegym.vn.service.product;

import codegym.vn.entity.Product;
import codegym.vn.repository.IRepositoryProduct;
import codegym.vn.repository.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IRepositoryProduct iRepositoryProduct;
    @Autowired
    private IRepositoryCategory iRepositoryCategory;

    @Override
    public List<Product> findAll() {
        return iRepositoryProduct.findAll();
    }

    @Override
    public boolean create(Product product) {
        iRepositoryProduct.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (iRepositoryProduct.existsById(product.getId_product())) {
            iRepositoryProduct.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iRepositoryProduct.deleteById(id);
        return true;
    }

    @Override
    public Product findById(Integer id) {
        return iRepositoryProduct.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllByNameContaining(String name) {
        return iRepositoryProduct.findAllByNameContaining(name);
    }
}
