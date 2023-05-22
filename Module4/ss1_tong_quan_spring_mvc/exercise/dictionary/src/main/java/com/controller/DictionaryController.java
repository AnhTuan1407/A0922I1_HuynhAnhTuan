package com.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String dictionary(@RequestParam(defaultValue = "") String word, Model model) {
        Map<String, String> dictionaryMap = new LinkedHashMap<>();
        dictionaryMap.put("Flower", "Bong hoa");
        dictionaryMap.put("Red", "Mau do");
        dictionaryMap.put("Television", "Ti vi");
        dictionaryMap.put("Phone", "Dien thoai");
        dictionaryMap.put("Love", "Tinh yeu");
        String translate = null;
        translate = dictionaryMap.get(word);
        if (translate == null) {
            translate = "Khum thay gi ca!!!";
        }
        model.addAttribute("translate", translate);
        return "index";
    }
}
