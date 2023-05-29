package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.repository.DeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DeclarationController {
    @Autowired
    private DeclarationRepository declarationRepository;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("declaration", declarationRepository.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("genderList", declarationRepository.genderList());
        model.addAttribute("vehicleList", declarationRepository.vehicleList());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("declaration") Declaration declaration) {
        declarationRepository.create(declaration);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam String iCard, Model model) {
        model.addAttribute("declaration", declarationRepository.findByIdentifyCard(iCard));
        model.addAttribute("genderList", declarationRepository.genderList());
        model.addAttribute("vehicleList", declarationRepository.vehicleList());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("declaration") Declaration declaration){
        declarationRepository.update(declaration);
        return "redirect:/list";
    }
}
