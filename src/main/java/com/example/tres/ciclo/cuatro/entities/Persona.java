/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tres.ciclo.cuatro.entities;

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
@Document(collection = "personas")
public class Persona {
    
    @Id
    private Integer id;
    private String nombre;
    private Integer edad;
    private String correo;
}
