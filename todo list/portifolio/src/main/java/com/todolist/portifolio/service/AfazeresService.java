package com.todolist.portifolio.service;

import java.util.List;

import com.todolist.portifolio.model.Afazeres;

public interface AfazeresService {
    
    List<Afazeres> findAll();
    Afazeres findById(Long id);
    Afazeres save(Afazeres afazeres);
   
    
}
