package com.todolist.portifolio.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.portifolio.model.Afazeres;
import com.todolist.portifolio.repository.AfazeresRepository;

import jakarta.annotation.PostConstruct;

@SuppressWarnings("unused")
@Component
public class DummyData {
    
    @Autowired
    AfazeresRepository todolistRepository;


    //@PostConstruct
    public void saveAfazeres(){
        List<Afazeres> afazeresList= new ArrayList<>();
        
        Afazeres afazeres1 = new Afazeres();

        afazeres1.setTitulo("Lavar a louça");
        afazeres1.setData(LocalDate.now());
        afazeres1.setDescricao("a louça deve ser lavada diariamente para evitar moscas");
        afazeres1.setConcluido(false);

        Afazeres afazeres2 = new Afazeres();

        afazeres2.setTitulo("Lavar a varanda");
        afazeres2.setData(LocalDate.now());
        afazeres2.setDescricao("a varanda deve ser lavada diariamente para evitar moscas");
        afazeres2.setConcluido(false);

        afazeresList.add(afazeres1);
        afazeresList.add(afazeres2);
        
        for(Afazeres afazeres: afazeresList){
            Afazeres afazeresSaved= todolistRepository.save(afazeres);
            System.out.println(afazeresSaved.getId());


        }

    }
}
