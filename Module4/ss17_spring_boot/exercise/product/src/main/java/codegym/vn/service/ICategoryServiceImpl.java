package codegym.vn.service;

import codegym.vn.entity.Category;
import codegym.vn.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ICategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    @Override
    public boolean create(Category category) {
        iCategoryRepository.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (iCategoryRepository.existsById(category.getId())){
            iCategoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        iCategoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }
}
