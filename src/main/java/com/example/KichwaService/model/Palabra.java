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
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
public class Palabra {
    @JsonBackReference
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_palabra")
    private Long id;
    
    //Creacion de una foreing key
    //union con la entidad Actividad
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;
    
    @Column(name = "palabra_esp")
    private String palabra_esp;
    
    @Column(name = "palabra_kich")
    private String palabra_kich;
    
    @Column(name = "audio")
    private String audio;
    
    @Column(name = "imagen")
    private String imagen;
    
    @Column(name = "descripcion")
    private String descripcion;
    
}
