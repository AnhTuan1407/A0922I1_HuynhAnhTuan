package codegym.vn.service.category;

import codegym.vn.entity.Category;
import codegym.vn.repository.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private IRepositoryCategory iRepositoryCategory;

    @Override
    public List<Category> findAll() {
        return iRepositoryCategory.findAll();
    }

    @Override
    public boolean create(Category category) {
        iRepositoryCategory.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (iRepositoryCategory.existsById(category.getId_category())) {
            iRepositoryCategory.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iRepositoryCategory.deleteById(id);
        return true;
    }

    @Override
    public Category findById(Integer id) {
        return (Category) iRepositoryCategory.findById(id).orElse(null);
    }
}
