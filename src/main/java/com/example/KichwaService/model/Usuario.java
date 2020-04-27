/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @Column(name="id_usuario") 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "correo")
    private String correo;    
    @Column(name = "nombre")
    private String nombre;  
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

    
    public Usuario(String correo, String nombre, String url_foto, String sexo, String password, String motivo) {
        super();
        this.correo = correo;
        this.nombre = nombre;
        this.url_foto = url_foto;
        this.sexo = sexo;
        this.password = password;
        this.motivo = motivo;
    } 

    public Usuario(Long id) {
        super();
        this.id = id;
    } 

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", correo=" + correo + ", nombre=" + nombre + ", url_foto=" + url_foto + ", sexo=" + sexo + ", password=" + password + ", motivo=" + motivo + '}';
    }
    
    
    

}
