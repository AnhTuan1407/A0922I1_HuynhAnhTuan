package codegym.vn.controller;

import codegym.vn.entity.Category;
import codegym.vn.entity.Product;
import codegym.vn.service.CategoryService;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        new Product().validate(product, bindingResult);
        Category category = categoryService.findById(product.getCategory().getCategoryId());
        product.setCategory(category);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/product/create";
        }
        productService.create(product);
        return "redirect:/product/listPaging";
    }

    @GetMapping("/update")
    public String showUpdateFrom(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/product/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        Category category = categoryService.findById(product.getCategory().getCategoryId());
        product.setCategory(category);
        productService.update(product);
        return "redirect:/product/listPaging";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") Integer id) {
        productService.deleteById(id);
        return "redirect:/product/listPaging";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/detail";
    }

    @GetMapping("/listPaging")
    public String showListPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> productList = productService.findAllPaging(PageRequest.of(page, 5));
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", productList);
        return "/product/listPaging";
    }

    @GetMapping("/searchByName")
    public String doSearchByName(Model model, Optional<String> searchName, Pageable pageable) {
        Page<Product> products;
        if (searchName.isPresent()) {
            products = productService.findByProductNameContaining̣̣̣̣̣̣(searchName.get(), pageable);
        } else {
            products = productService.findAllPaging(pageable);
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.findAll());
        return "product/listPaging";
    }

    @GetMapping("/searchByPrice")
    public String doSearchByPrice(Model model, Optional<Double> searchPrice, Pageable pageable) {
        Page<Product> products;
        if (searchPrice.isPresent()){
            products = productService.findByPrice(searchPrice.get(), pageable);
        }else {
            products = productService.findAllPaging(pageable);
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.findAll());
        return "/product/listPaging";
    }

    @GetMapping("/searchByCategory")
    public String doSearchByCategory(Model model, Optional<String> searchCategory, Optional<String> searchPrice, Pageable pageable) {
        Page<Product> products;
        if (searchCategory.isPresent() || searchPrice.isPresent()) {
            products = productService.findByProductNameContaining̣̣̣̣̣̣(String.valueOf(searchCategory.get()), pageable);
        } else {
            products = productService.findAllPaging(pageable);
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.findAll());
        return "product/listPaging";
    }
}
