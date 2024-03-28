package com.todolist.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todolist.main.model.Afazeres;
import com.todolist.main.service.AfazeresService;

import jakarta.validation.Valid;

@Controller
public class AfazeresController {

    @Autowired
    AfazeresService afazeresService;

    @GetMapping("/afazeres")
    public ModelAndView getAfazeres() {
        ModelAndView mv = new ModelAndView("afazeres");
        List<Afazeres> afazeres = afazeresService.findAll();
        mv.addObject("afazeres", afazeres);
        return mv;

    }

    @GetMapping("/afazeres/{id}")
    public ModelAndView getAfazerDetail(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("afazerDetail");
        Afazeres afazer = afazeresService.findById(id);
        mv.addObject("afazer", afazer);
        return mv;

    }

    @GetMapping("/novatarefa")
    public String getAfazerForm() {
        return "afazerForm";

    }

    @PostMapping("/novatarefa")
    public String saveTarefa(@Valid Afazeres afazer, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/novatarefa";
        }
        afazer.setData(LocalDate.now());
        afazeresService.save(afazer);
        return "redirect:/afazeres";

    }
           
     @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id")Long id, Model model) {

        Afazeres afazeres = afazeresService.findById(id);

        afazeresService.delete(afazeres);

        return "redirect:/afazeres";
    }
}
