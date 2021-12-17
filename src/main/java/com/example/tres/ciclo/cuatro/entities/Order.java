/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.entities;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




/**
 *
 * @author Luis_Mendez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {
    
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<String, Clothe> products;
    private Map<String, Integer> quantities;
    
   
}
