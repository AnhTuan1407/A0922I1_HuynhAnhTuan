package codegym.vn.service;

import codegym.vn.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    boolean create(Category category);

    boolean update(Category category);

    boolean deleteById(Integer id);

    Category findById(Integer id);
}
