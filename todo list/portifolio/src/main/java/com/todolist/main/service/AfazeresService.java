package com.todolist.main.service;

import java.util.List;

import com.todolist.main.model.Afazeres;

public interface AfazeresService {
    
    List<Afazeres> findAll();
    Afazeres findById(Long id);
    Afazeres save(Afazeres afazeres);
    void delete(Afazeres afazeres);
   
    
}
