package com.codegym.blog_upgrade.service;

import com.codegym.blog_upgrade.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    boolean create(Blog blog);

    boolean update(Blog blog);

    List<Blog> findAll();

    boolean deleteById(Integer id);

    Blog findById(Integer  id);

    Page<Blog> findAllWithPaging(Pageable pageable);
    public Slice<Blog> findAllWithSlice(Pageable pageable);

    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
