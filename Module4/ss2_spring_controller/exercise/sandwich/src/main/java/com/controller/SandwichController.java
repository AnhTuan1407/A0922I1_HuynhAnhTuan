package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String sandwich(@RequestParam(defaultValue = "") String condiment, Model model) {
        List<String> condiments = new ArrayList<>();
        condiments.add(condiment);
        model.addAttribute("condiments", condiments);
        return "index";
    }
}
