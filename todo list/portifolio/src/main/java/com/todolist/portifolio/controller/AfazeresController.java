package com.todolist.portifolio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todolist.portifolio.model.Afazeres;
import com.todolist.portifolio.service.AfazeresService;

import jakarta.validation.Valid;


@Controller
public class AfazeresController {

    @Autowired
    AfazeresService afazeresService;

    @RequestMapping(value = "/afazeres", method = RequestMethod.GET)
    public ModelAndView getAfazeres() {
        ModelAndView mv = new ModelAndView("afazeres");
        List<Afazeres> afazeres = afazeresService.findAll();
        mv.addObject("afazeres", afazeres);
        return mv;

    }

    @RequestMapping(value = "/afazeres/{id}", method = RequestMethod.GET)
    public ModelAndView getAfazerDetail(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("afazerDetail");
        Afazeres afazer = afazeresService.findById(id);
        mv.addObject("afazer", afazer);
        return mv;

    }

    @RequestMapping(value = "/novatarefa", method = RequestMethod.GET)
    public String getAfazerForm() {
        return "afazerForm";

    }

    @RequestMapping(value="/novatarefa", method= RequestMethod.POST)
    public String saveTarefa(@Valid Afazeres afazer,BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","verifique se os campos obrigatórios foram preenchidos");
            return"redirect:/novatarefa";
        }   
            afazer.setData(LocalDate.now());
            afazeresService.save(afazer);
            return "redirect:/afazeres";
        
    }
}