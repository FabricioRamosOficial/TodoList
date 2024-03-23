package com.todolist.portifolio.service;

import java.util.List;

import com.todolist.portifolio.model.Afazeres;

public interface TodolistService {
    
    List<Afazeres>findall();
    Afazeres findById(Long id);
    Afazeres save(Afazeres afazeres);
    
}
