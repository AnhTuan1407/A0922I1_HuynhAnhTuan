package com.codegym.controller;

import com.codegym.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("register", new Register());
        return "index";
    }

    @PostMapping("/validateRegister")
    public String checkValidate(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult, Model model) {
        new Register().validate(register, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            model.addAttribute("register", register);
            return "result";
        }
    }
}
