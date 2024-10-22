package com.vedruna.apiRest1_1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.apiRest1_1.persistance.models.Alumno;

@Repository
public interface AlumnoRepositoryI extends JpaRepository<Alumno, Integer>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    Alumno findByname(String name);
} 
