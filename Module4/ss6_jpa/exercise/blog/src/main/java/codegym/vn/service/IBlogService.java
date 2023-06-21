package codegym.vn.service;

import codegym.vn.entity.Blog;

import java.util.List;

public interface IBlogService {
    boolean create(Blog blog);

    boolean update(Blog blog);

    List<Blog> findAll();

    boolean deleteById(Integer id);

    Blog findById(Integer  id);
}
