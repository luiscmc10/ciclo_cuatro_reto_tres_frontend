/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.services;

import com.example.tres.ciclo.cuatro.entities.Persona;
import com.example.tres.ciclo.cuatro.repositories.personaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis_Mendez
 */
@Service
public class personaService {
    @Autowired
    private personaRepository repository;
    
    public List<Persona> getAll(){
        return repository.getAllPersona();
    }
    
    public Persona createNew(Persona nuevo){
        if(nuevo.getId()== null){
            return nuevo;
        }
        
        Optional<Persona> existente = repository.findID(nuevo.getId());
        if(existente.isPresent()){
            return nuevo;
        }
        else{
            return repository.create(nuevo);
        } 
    }
    
    public Optional<Persona> findID(Integer id){
        return repository.findID(id);
    }
    
    public Persona Update(Persona personaup){
        
        
        Optional<Persona> existente = findID(personaup.getId());
        
        if(existente.isPresent()){
            existente.get().setEdad(personaup.getEdad());
            existente.get().setCorreo(personaup.getCorreo());
            existente.get().setNombre(personaup.getNombre());
            
            return personaup;
        }
        else{
            return personaup;
        } 
    }
    
    
    public boolean delete(int id){
        Boolean aBoolean = findID(id).map(reservation -> {
           repository.delete(reservation);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
    
    
}
