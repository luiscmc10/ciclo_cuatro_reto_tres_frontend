/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.controller;

import com.example.tres.ciclo.cuatro.entities.Persona;
import com.example.tres.ciclo.cuatro.services.personaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Luis_Mendez
 */
@RestController
@RequestMapping("api/Persona")
public class personaController {
    
    @Autowired
    private personaService service;
    
    @GetMapping("/all")
    public List<Persona> list() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable Integer id) {
        return service.findID(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona post(@RequestBody Persona persona) {
        return service.createNew(persona);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona editLibrery(@RequestBody Persona library){
        return service.Update(library);
    }
    
    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    
}
