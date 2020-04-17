/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinColumn(name = "id_leccion", referencedColumnName = "id_leccion")
//    @JoinTable(name = "id_actividad", joinColumns = @JoinColumn(name = "id_palabra"),
//            inverseJoinColumns = @JoinColumn(name = "id_actividad"))
    
    private Leccion leccion;
    
    @Column(name = "sig_esp")
    private String sig_esp;
    
    @Column(name = "sig_kich")
    private String sig_kich;
    
    
    @Column(name = "url_imagen")
    private String url_imagen;
    
    @Column(name = "url_audio")
    private String url_audio;
    
    @Column(name = "descripcion")
    private String descripcion;

    public Palabra(String sig_esp, String sig_kich, String url_imagen, String url_audio, String descripcion) {
        this.sig_esp = sig_esp;
        this.sig_kich = sig_kich;
        this.url_imagen = url_imagen;
        this.url_audio = url_audio;
        this.descripcion = descripcion;
    }
    
    public Palabra(Long id) {
        super();
        this.id = id;
    }

    
    
}
