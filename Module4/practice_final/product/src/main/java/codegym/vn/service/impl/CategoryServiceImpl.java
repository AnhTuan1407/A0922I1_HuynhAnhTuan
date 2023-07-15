package codegym.vn.service.impl;

import codegym.vn.entity.Category;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean create(Category category) {
        if (categoryRepository.existsById(category.getCategoryId())){
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (categoryRepository.existsById(category.getCategoryId())){
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
