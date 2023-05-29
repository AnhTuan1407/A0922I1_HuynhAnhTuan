package com.codegym.repository;

import com.codegym.entity.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> findAll();
    List<String> findAllLanguages();
    List<Integer> findAllPageSize();

    boolean update(Email email);

    boolean delete(int id);

    Email findById(int id);
}
