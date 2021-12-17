/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.services;

import com.example.tres.ciclo.cuatro.entities.Order;
import com.example.tres.ciclo.cuatro.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author Luis_Mendez
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    public List<Order> getAll(){
        return repository.getAll();
    }
    public List<Order> getZone(String zona){
        return repository.getZone(zona);
    }
    public Optional<Order> getId(Integer id){
        return repository.getById(id);
    }
    public Order createOrder(Order order){
        return repository.createOrder(order);
    }
    
    public Order update(Order orderEdit){
        if(orderEdit.getId()!=null){
            Optional<Order> resultado = repository.getById(orderEdit.getId());
            if(resultado.isPresent()){
                if(orderEdit.getProducts()!=null){
                    resultado.get().setProducts(orderEdit.getProducts());
                }
                if(orderEdit.getStatus()!=null){
                    resultado.get().setStatus(orderEdit.getStatus());
                }
                if(orderEdit.getSalesMan()!=null){
                    resultado.get().setSalesMan(orderEdit.getSalesMan());
                }
                if(orderEdit.getRegisterDay()!=null){
                    resultado.get().setRegisterDay(orderEdit.getRegisterDay());
                }
                if(orderEdit.getQuantities()!=null){
                    resultado.get().setQuantities(orderEdit.getQuantities());
                }
                repository.createOrder(resultado.get());
                return resultado.get();
            }else{
                return orderEdit;
            }
        }else{
            return orderEdit;
        }
    }
    
}
