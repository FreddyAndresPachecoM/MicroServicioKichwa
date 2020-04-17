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
public class Tema {
    @JsonBackReference
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tema")
    private Long id;
    
    //Creacion de una foreing key
    //union con la entidad Actividad
    @ManyToOne
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    private Actividad actividad;
//    @JoinTable(name = "id_nivel", joinColumns = @JoinColumn(name = "id_tema"),
//            inverseJoinColumns = @JoinColumn(name = "id_nivel"))
    
    
    @Column (name="nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;

    
    //union con la entidad Cuestionario
//    @OneToOne(mappedBy = "tema")
//    private Cuestionario cuestionario;
//    
    //union con la entidad Actividad
//    @OneToOne(mappedBy = "tema")
//    private Actividad actividad;


    public Tema(Long id) {
        super();
        this.id = id;
    }

    public Tema(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
    
    
}
