package codegym.vn.controller;

import codegym.vn.entity.Blog;
import codegym.vn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blog", iBlogService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog){
        iBlogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog){
        iBlogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") int id){
        iBlogService.deleteById(id);
        return "redirect:/blog/list";
    }
}
