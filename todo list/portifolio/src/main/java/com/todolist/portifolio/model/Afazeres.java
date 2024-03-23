package com.todolist.portifolio.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_Afazeres")
public class Afazeres {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Nullable
    private String Titulo;

    @Nullable
    private String descricao;

    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate data;


    private boolean concluido =false ;

    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public boolean isConcluido() {
        return concluido;
    }


    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }


    public String getTitulo() {
        return Titulo;
    }


    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    
}
