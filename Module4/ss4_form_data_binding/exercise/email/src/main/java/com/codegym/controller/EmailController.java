package com.codegym.controller;

import com.codegym.entity.Email;
import com.codegym.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {
    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("email", emailRepository.findAll());
        return "list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model){
        model.addAttribute("email",emailRepository.findById(id));
        model.addAttribute("languageList", emailRepository.findAllLanguages());
        model.addAttribute("pageSizeList", emailRepository.findAllPageSize());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("email") Email email){
        emailRepository.update(email);
        return "redirect:/list";
    }
}
