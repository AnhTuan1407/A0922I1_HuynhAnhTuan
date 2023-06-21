package com.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    boolean create(T t);

    boolean update(T t);

    T findById(int id);

    boolean deleteById(int id);
}
