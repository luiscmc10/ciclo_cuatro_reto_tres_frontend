/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.repositories;

import com.example.tres.ciclo.cuatro.entities.Persona;
import com.example.tres.ciclo.cuatro.repositoriesCrud.personaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis_Mendez
 */
@Repository
public class personaRepository {
    
    @Autowired
    private personaCrudRepository repository;
    
    public List<Persona> getAllPersona(){
        return repository.findAll();
    }
    public Optional<Persona> findID(Integer id){
        return repository.findById(id);
    }
    
    public Persona create(Persona nuevo){
        return repository.save(nuevo);
    }
    
    public void delete(Persona borrado){
        repository.delete(borrado);
    }
    
            
    
}
