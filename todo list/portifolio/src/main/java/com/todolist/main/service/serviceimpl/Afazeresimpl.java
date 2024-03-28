package com.todolist.main.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.main.model.Afazeres;
import com.todolist.main.repository.AfazeresRepository;
import com.todolist.main.service.AfazeresService;

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

    @Override
    public void  delete(Afazeres afazeres) {
     todolistRepository.delete(afazeres);
    }

    
}
