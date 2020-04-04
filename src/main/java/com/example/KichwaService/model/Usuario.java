/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
public class Usuario {
    @JsonBackReference
    @Id
    @Column(name="id_usuario") 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "correo")
    private String correo;    
    @Column(name = "nombre")
    private String name;    
    @Column(name = "password")
    private String password;    
    @Column(name = "razon")
    private String razon;    
    @Column(name = "foto")
    private String foto;
    
    //union con la entidad cuenta
    @OneToOne(mappedBy = "usuario")
    private Cuenta cuenta;
    
}
