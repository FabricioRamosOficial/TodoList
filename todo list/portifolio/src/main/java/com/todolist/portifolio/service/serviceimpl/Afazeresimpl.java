package com.todolist.portifolio.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.portifolio.model.Afazeres;
import com.todolist.portifolio.repository.AfazeresRepository;
import com.todolist.portifolio.service.AfazeresService;

@Service
public class Afazeresimpl implements AfazeresService {

    @Autowired
    AfazeresRepository todolistRepository;

    @Override
    public List<Afazeres> findAll() {
        return todolistRepository.findAll();
    }

    @Override
    public Afazeres findById(Long id) {
        return todolistRepository.findById(id).get();
    }

    @Override
    public Afazeres save(Afazeres afazeres) {
    return todolistRepository.save(afazeres);
    }

    
}
