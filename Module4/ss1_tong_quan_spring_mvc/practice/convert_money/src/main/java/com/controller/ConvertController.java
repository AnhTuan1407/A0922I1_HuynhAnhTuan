package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String convert(@RequestParam (defaultValue = "0") String usd, Model model) {
        Float vnd = Float.parseFloat(usd) * 23000;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
