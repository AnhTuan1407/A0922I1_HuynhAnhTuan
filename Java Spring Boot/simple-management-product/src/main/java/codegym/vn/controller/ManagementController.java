package codegym.vn.controller;

import codegym.vn.entity.Product;
import codegym.vn.service.category.CategoryServiceImpl;
import codegym.vn.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ManagementController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("product", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        product.setCategory(categoryService.findById(product.getCategory().getId_category()));
        productService.create(product);
        return "redirect:/product/list";
    }
}
