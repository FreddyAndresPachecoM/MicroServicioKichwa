/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;

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
    @Column(name = "url_foto")
    private String url_foto;
    @Column(name ="sexo")
    private String sexo;
    @Column(name = "password")
    private String password;    
    @Column(name = "motivo")
    private String motivo;    
    
    
        
    //union con la entidad cuenta
//    @OneToOne(mappedBy = "usuario")
//    private Cuenta cuenta;

    
    public Usuario(String correo, String name, String url_foto, String sexo, String password, String motivo) {
        this.correo = correo;
        this.name = name;
        this.url_foto = url_foto;
        this.sexo = sexo;
        this.password = password;
        this.motivo = motivo;
    } 

    public Usuario(Long id) {
        super();
        this.id = id;
    } 
    

}
