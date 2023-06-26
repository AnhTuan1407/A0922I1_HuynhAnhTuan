package com.codegym.blog_upgrade.repository;

import com.codegym.blog_upgrade.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
