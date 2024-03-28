package com.todolist.main.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.main.model.Afazeres;
import com.todolist.main.repository.AfazeresRepository;

import jakarta.annotation.PostConstruct;


@Component
public class DummyData {
    
    @Autowired
    AfazeresRepository todolistRepository;


    //@PostConstruct
    public void saveAfazeres(){
        List<Afazeres> afazeresList= new ArrayList<>();
        
        Afazeres afazeres1 = new Afazeres();
        afazeres1.setAutor("Fabricio");
        afazeres1.setTitulo("Lavar a louça");
        afazeres1.setData(LocalDate.now());
        afazeres1.setDescricao("a louça deve ser lavada diariamente para evitar moscas");
       

        Afazeres afazeres2 = new Afazeres();
        afazeres2.setAutor("laryssa");
        afazeres2.setTitulo("Lavar a varanda");
        afazeres2.setData(LocalDate.now());
        afazeres2.setDescricao("a varanda deve ser lavada diariamente para evitar moscas");
       

        afazeresList.add(afazeres1);
        afazeresList.add(afazeres2);
     
        
        for(Afazeres afazeres: afazeresList){
            Afazeres afazeresSaved= todolistRepository.save(afazeres);
            System.out.println(afazeresSaved.getId());


        }

    }
}
