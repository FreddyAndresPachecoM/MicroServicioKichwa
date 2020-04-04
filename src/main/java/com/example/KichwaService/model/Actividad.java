/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
public class Actividad {
    @JsonBackReference
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad")
    private Long id;
    
    //Creacion de una foreing key
    //union con la entidad Tema
    @ManyToOne
    @JoinColumn(name = "id_tema")
    private Tema tema;
    
    @Column(name="estado")
    private boolean estado;
    
    @Column(name = "nombre")
    private String nombre;
    
    //union con la entidad Palabra
    @OneToOne(mappedBy = "actividad")
    private Palabra palabra;
    
}
