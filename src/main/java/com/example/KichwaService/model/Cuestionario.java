/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.*;


@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
public class Cuestionario {
    @JsonBackReference
    @Id
    @Column (name="id_cuestionario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //Creacion de una foreing key
    //union con la entidad Tema
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tema",referencedColumnName = "id_tema")
    private Tema tema;
    
    @Column(name = "pregunta_esp")
    private String pregunta_esp;
    
    @Column(name = "respuesta_esp")
    private String respuesta_esp;
    
    @Column(name = "pregunta_kich")
    private String pregunta_kich;
    
    @Column(name = "respuesta_kich")
    private String respuesta_kich;
        
    @Column(name = "aud_kich_pregunta")
    private String aud_pregunta;
    
    @Column(name = "aud_kich_respuesta")
    private String aud_respuesta;
    
}
