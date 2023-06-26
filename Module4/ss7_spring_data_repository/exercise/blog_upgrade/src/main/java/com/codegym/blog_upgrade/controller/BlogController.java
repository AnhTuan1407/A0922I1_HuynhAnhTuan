package com.codegym.blog_upgrade.controller;

import com.codegym.blog_upgrade.entity.Blog;
import com.codegym.blog_upgrade.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("blog", iBlogService.findAllWithPaging(pageable));
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        iBlogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        iBlogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") int id) {
        iBlogService.deleteById(id);
        return "redirect:/blog/list";
    }

//    @GetMapping(value = "/listpaging")
//    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
//                             @RequestParam("size") Optional<Integer> size,
//                             @RequestParam("sort") Optional<String> sort) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(5);
//        String sortField = sort.orElse("phoneNumber");
//        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
//        Page<Blog> blog = iBlogService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
//        model.addAttribute("blog", blog);
//        int totalPages = blog.getTotalPages();
//        if (totalPages > 1) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        return "blog/listPaging";
//    }
//
//    @GetMapping(value = "/listpagingslice")
//    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
//                                  @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(5);
//        Slice<Blog> blog = iBlogService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
//        model.addAttribute("blog", blog.getContent());
//        model.addAttribute("page", blog);
//        return "blog/listPagingSlice";
//    }

    @GetMapping("/listpaging")
    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Blog> blog = iBlogService.findAllWithPaging(PageRequest.of(page, 2));
        model.addAttribute("blog", blog);
        return "blog/listPaging";
    }

    @GetMapping(value = "/listpagingslice")
    public String listPagingSlice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<Blog> blog = iBlogService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blog", blog.getContent());
        model.addAttribute("page", blog);
        return "blog/listPagingSlice";
    }

    @GetMapping("/search")
    public String doSearch(Model model, @RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Blog> blog;
        if(search.isPresent()){
            blog = iBlogService.findAllByContentContaining(search.get(), pageable);
        } else {
            blog = iBlogService.findAllWithPaging(pageable);
        }
        model.addAttribute("blog", blog);
        return "blog/list";
    }

    @GetMapping("/view")
    public String showView(@RequestParam("id") Integer id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/view";
    }
}
