/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.controller;

import com.example.tres.ciclo.cuatro.entities.User;
import com.example.tres.ciclo.cuatro.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis_Mendez
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;
    
    //lista de usuarios
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getAll();
    }
    //autenticacion al ingreso
    @GetMapping("/{id}")
    public Optional<User> findAllUser(@PathVariable("id")Integer id){
        return service.findID(id);
    }
    
    //autenticacion correos existentes
    @GetMapping("emailexist/{email}")
    public boolean findAllAdres(@PathVariable("email")String email){
        return service.findAdress(email);
        
    }
    
    //autenticacion al ingreso
    @GetMapping("/emailexist/{email}/{password}")
    public User findUserExistend(@PathVariable("email")String email,@PathVariable("password") String password){
        return service.findExistens(email, password);
    }
    //autenticacion al ingreso
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        
         return service.save(user);  
    }
    //autenticacion al ingreso
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User editclothe(@RequestBody User clothe){
        return service.update(clothe);
    }
    //autenticacion al ingreso
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    
    
    
}
