/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
@Table(name = "leccion")
public class Leccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_leccion")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_tema", referencedColumnName = "id_tema")
    private Tema tema;
    
    @Column(name = "nombre")
    private String nombre;

    public Leccion(Long id) {
        super();
        this.id = id;
    }

    public Leccion(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Leccion(Tema tema, String nombre) {
        this.tema = tema;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Leccion{" + "id=" + id + ", tema=" + tema + ", nombre=" + nombre + '}';
    }
    
    
       
    
}
