package codegym.vn.controller;

import codegym.vn.entity.Music;
import codegym.vn.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("musicList", musicRepository.findAll());
        return "music/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "music/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult, Model model) {
        new Music().validate(music, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "music/create";
        } else {
            musicRepository.create(music);
            return "redirect:/music/list";
        }
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("music", musicRepository.findById(id));
        return "music/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("music") Music music) {
        musicRepository.update(music);
        return "redirect:/music/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        model.addAttribute("music", musicRepository.findById(id));
        return "music/detail";
    }

}
