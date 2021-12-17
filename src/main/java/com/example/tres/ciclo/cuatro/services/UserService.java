/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.services;

import com.example.tres.ciclo.cuatro.entities.User;
import com.example.tres.ciclo.cuatro.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis_Mendez
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User>getAll(){
        return repository.getAll();
    }
    public Optional<User> findID(Integer id){
        return repository.getUser(id);
    }
    
    public boolean findAdress(String email){
        List<User>usuarios = repository.getAll();
        boolean r = false;
        for(User x : usuarios){
            if (x.getEmail().equals(email)){
                r = true;
            }
        }
        return r;
    }
    
    public User findExistens(String email, String password){
        List<User>usuarios = repository.getAll();
        User usuarioSinRegistro = new User();
        User usuarioConRegistro = new User();
        int validacion = 0;
        for(User x : usuarios){
            if(x.getEmail().equals(email) && x.getPassword().equals(password)){
                validacion = 1;
                usuarioConRegistro = x;   
            }
            else{
                User usuarioSinRegistro1 = new User(null,null, null, null, null, null,null,null, null, null, null);
                usuarioSinRegistro = usuarioSinRegistro1;
                
            }   
        }
        if (validacion == 0){
            return usuarioSinRegistro;
        }
        else{
            return usuarioConRegistro;
        }
    }
    
    public User save(User user){
        if(user.getId()==null){
            return repository.save(user);
        }
        else{
            Optional<User> resultado = repository.getUser(user.getId());
            if (resultado.isPresent()){
                return user;
            }
            else{
                return repository.save(user);
            }
        }
    }
    
    public User update(User UserEdit){
        if(UserEdit.getId()!=null){
            Optional<User> resultado = repository.getUser(UserEdit.getId());
            if(resultado.isPresent()){
                if(UserEdit.getName()!=null){
                    resultado.get().setName(UserEdit.getName());
                }
                if(UserEdit.getBirthtDay()!=null){
                    resultado.get().setBirthtDay(UserEdit.getBirthtDay());
                }
                if(UserEdit.getMonthBirthtDay()!=null){
                    resultado.get().setMonthBirthtDay(UserEdit.getMonthBirthtDay());
                }
                if(UserEdit.getEmail()!=null){
                    resultado.get().setEmail(UserEdit.getEmail());
                }
                if(UserEdit.getAddress()!=null){
                    resultado.get().setAddress(UserEdit.getAddress());
                }
                if(UserEdit.getCellPhone()!=null){
                    resultado.get().setCellPhone(UserEdit.getCellPhone());
                }
                if(UserEdit.getType()!=null){
                    resultado.get().setType(UserEdit.getType()); 
                }
                if(UserEdit.getZone()!=null){
                    resultado.get().setZone(UserEdit.getZone()); 
                }
                if(UserEdit.getPassword()!=null){
                    resultado.get().setPassword(UserEdit.getPassword()); 
                }
                if(UserEdit.getIdentification()!=null){
                    resultado.get().setIdentification(UserEdit.getIdentification()); 
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return UserEdit;
            }
        }else{
            return UserEdit;
        }
    }
    
     public boolean delete(Integer id){
        Boolean aBoolean = findID(id).map(reservation -> {
           repository.deleteUser(reservation);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
}
