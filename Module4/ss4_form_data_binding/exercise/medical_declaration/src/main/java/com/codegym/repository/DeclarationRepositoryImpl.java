package com.codegym.repository;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepositoryImpl implements DeclarationRepository{

    public static List<String> genderList = new ArrayList<>();
    public static List<String> vehicleList = new ArrayList<>();
    public static Map<String, Declaration> declarationMap = new HashMap<>();

    static {
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Không rõ");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác (Ghi rõ)");

        declarationMap.put("08369", new Declaration("SEELE", "2002", "Nữ", "Việt Nam", "08369", "Tàu bay", "92-F4", "01/05/2023", "06/05/2023", "Quảng Nam", "Đại Lộc", "Đại Hiệp", "096972534", "bronyaOneechan@gmail.com"));
        declarationMap.put("03696", new Declaration("JING YUAN", "1999", "Nam", "Việt Nam", "03696", "Ô tpp", "42-F1", "26/05/2023", "01/06/2023", "Đà Nẵng", "Hải Châu", "Bình Thuận", "082251467", "jingLiuSensei@gmail.com"));
        declarationMap.put("07375", new Declaration("KAFKA", "2000", "Nữ", "Việt Nam", "07375", "Tàu thuyền", "74-B5", "01/05/2023", "06/05/2023", "Đà Nẵng", "Cẩm Lệ", "Hòa Xuân", "076927108", "stelle@gmail.com"));
    }

    @Override
    public List<Declaration> findAll() {
        return new ArrayList<>(declarationMap.values());
    }

    @Override
    public List<String> genderList() {
        return genderList;
    }

    @Override
    public List<String> vehicleList() {
        return vehicleList;
    }

    @Override
    public void create(Declaration declaration) {
        declarationMap.put(declaration.getIdentifyCard(), declaration);
    }

    @Override
    public boolean update(Declaration declaration) {
        if (declarationMap.containsKey(declaration.getIdentifyCard())) {
            declarationMap.put(declaration.getIdentifyCard(), declaration);
            return true;
        }
        return false;
    }

    @Override
    public Declaration findByIdentifyCard(String ICard) {
        return declarationMap.get(ICard);
    }
}
