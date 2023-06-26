package com.codegym.blog_upgrade.service;

import com.codegym.blog_upgrade.entity.Blog;
import com.codegym.blog_upgrade.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public boolean create(Blog blog) {
        iBlogRepository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if (iBlogRepository.existsById(blog.getId())) {
            iBlogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        iBlogRepository.deleteById(id);
        return true;
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllWithSlice(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByContentContaining(String content, Pageable pageable) {
        return iBlogRepository.findAllByContentContaining(content, pageable);
    }
}
