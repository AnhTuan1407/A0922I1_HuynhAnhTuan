package codegym.vn.controller;

import codegym.vn.entity.Category;
import codegym.vn.entity.Product;
import codegym.vn.service.ICategoryService;
import codegym.vn.service.IProductService;
import codegym.vn.validate.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private ProductValidate validate;

    public ProductController(IProductService iProductService, ICategoryService iCategoryService, ProductValidate validate) {
        this.iProductService = iProductService;
        this.iCategoryService = iCategoryService;
        this.validate = validate;
    }

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("product", iProductService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("category", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        validate.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", iCategoryService.findAll());
            return "create";
        }
        product.setCategory(iCategoryService.findById(product.getCategory().getId()));
        iProductService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") Integer id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        model.addAttribute("category", iCategoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product){
        product.setCategory(iCategoryService.findById(product.getCategory().getId()));
        iProductService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = iProductService.findProductByName(name);
        model.addAttribute("product", productList);
        model.addAttribute("name", name);
        return "list";
    }
}
