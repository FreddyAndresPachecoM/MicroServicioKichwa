/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
@Table(name = "actividad_usuario")
public class ActividadUsuario implements Serializable {
    @JsonBackReference
    @Id
    @Column(name="id_act_usu") 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name ="id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    private Actividad actividad;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "fecha")
    private Date fecha;

    public ActividadUsuario(Long id) {
        super();
        this.id = id;
    }

    public ActividadUsuario(boolean estado, Date fecha) {
        super();
        this.estado = estado;
        this.fecha = fecha;
    }

    public ActividadUsuario(Usuario usuario, Actividad actividad, boolean estado, Date fecha) {
        super();
        this.usuario = usuario;
        this.actividad = actividad;
        this.estado = estado;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ActividadUsuario{" + "id=" + id + ", usuario=" + usuario + ", actividad=" + actividad + ", estado=" + estado + ", fecha=" + fecha + '}';
    }   

    
} 
