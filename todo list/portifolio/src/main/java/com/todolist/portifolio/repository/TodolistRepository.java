package com.todolist.portifolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.portifolio.model.Afazeres;

public interface TodolistRepository extends JpaRepository<Afazeres, Long> {

}
