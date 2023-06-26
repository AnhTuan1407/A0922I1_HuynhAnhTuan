package codegym.vn.controller;

import codegym.vn.entity.Nasa;
import codegym.vn.repository.NasaRepository;
import codegym.vn.service.INasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nasa")
public class NasaController {
    @Autowired
    private NasaRepository nasaRepository;

    @Autowired
    private INasaService iNasaService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("nasaCreate", new Nasa());
        model.addAttribute("nasa", nasaRepository.findAll());
        model.addAttribute("nasa1", nasaRepository.findAll());
        return "nasa/list";
    }

    @PostMapping("/list")
    public String doCreate(@ModelAttribute("nasa") Nasa nasa) throws Exception {
        String[] list = {"dm", "fuck", "shit", "duma", "chó", "ngu", "súc vật", "cc"};
        for (int i = 0; i < list.length; i++) {
            if (nasa.getFeedback().contains(list[i])) {
                throw new Exception();
            }
        }
        nasaRepository.create(nasa);
        return "redirect:/nasa/list";
    }

    @GetMapping("/listpaging")
    public String showListPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("nasaCreate", new Nasa());
        model.addAttribute("nasa", nasaRepository.findAll());
        model.addAttribute("nasa1", nasaRepository.findAll());
        Page<Nasa> nasa = iNasaService.findAllWithPaging(PageRequest.of(page, 2));
        model.addAttribute("nasa", nasa);
        return "nasa/listPaging";
    }
}
