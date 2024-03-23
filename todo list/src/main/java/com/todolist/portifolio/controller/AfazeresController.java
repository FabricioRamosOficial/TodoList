package com.todolist.portifolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.todolist.portifolio.model.Afazeres;
import com.todolist.portifolio.service.AfazeresService;

@Controller
public class AfazeresController {
    
    @Autowired
    AfazeresService afazeresService;

    @GetMapping("/afazeres")
    public ModelAndView getAfazeres(){
        ModelAndView mv = new ModelAndView("afazeres");
        List<Afazeres> afazeres= afazeresService.findAll();
        mv.addObject("afazeres",afazeres);
        return mv;

    }
}
