package com.codegym.repository;

import com.codegym.model.Declaration;

import java.util.List;

public interface DeclarationRepository {
    List<Declaration> findAll();

    List<String> genderList();

    List<String> vehicleList();

    void create(Declaration declaration);

    boolean update(Declaration declaration);

    Declaration findByIdentifyCard(String ICard);
}
