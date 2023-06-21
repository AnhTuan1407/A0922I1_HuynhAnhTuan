package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.repository.CategoryRepository;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.impl.CategoryRepositoryImpl;
import com.codegym.repository.impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Autowired
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("product", productRepository.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product){
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("product", productRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product){
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "detail";
    }
}
