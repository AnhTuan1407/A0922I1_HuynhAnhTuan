package codegym.vn.controller;

import codegym.vn.entity.Music;
import codegym.vn.repository.MusicRepository;
import codegym.vn.repository.MusicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList", musicRepository.findAll());
        return "music/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "music/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("music") Music music){
        musicRepository.create(music);
        return "redirect:/music/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("music", musicRepository.findById(id));
        return "music/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("music") Music music){
        musicRepository.update(music);
        return "redirect:/music/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model){
        model.addAttribute("music", musicRepository.findById(id));
        return "music/detail";
    }

}
