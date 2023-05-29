package com.codegym.repository;

import com.codegym.entity.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailRepositoryImpl implements EmailRepository{

    private Map<Integer, Email> emailMap = new HashMap<>();

    public static List<String> languageList = new ArrayList<>();
    public static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");

        pageSizeList.add(10);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(75);
        pageSizeList.add(150);
    }

    public EmailRepositoryImpl () {
        emailMap.put(1, new Email(1, "English", 50, true, "Thor, King Asgard"));
        emailMap.put(2, new Email(2, "English", 150, false, "Ironman, I am IronMan!"));
        emailMap.put(3, new Email(3, "Japanese", 25, false, "Susan, Sugoi Sugoi"));
        emailMap.put(4, new Email(4, "Vietnamese", 25, true, "may biet bo may la ai khong!!"));
        emailMap.put(5, new Email(5, "English", 75, true, "Siuuuuuuuuuuuuuuuuuuu"));
    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailMap.values());
    }

    @Override
    public List<String> findAllLanguages() {
        return languageList;
    }

    @Override
    public List<Integer> findAllPageSize() {
        return pageSizeList;
    }

    @Override
    public boolean update(Email email) {
        if (emailMap.containsKey(email.getId())) {
            emailMap.put(email.getId(), email);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (emailMap.containsKey(id)) {
            emailMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Email findById(int id) {
        return emailMap.get(id);
    }
}
