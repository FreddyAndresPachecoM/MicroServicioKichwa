/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import java.util.Date;
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
public class TemaActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tem_act")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_act_usu", referencedColumnName = "id_act_usu")
    private ActividadUsuario actividadUsuario;
    
    @ManyToOne
    @JoinColumn(name ="id_tema", referencedColumnName = "id_tema")
    private Tema tema;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "fecha")
    private Date fecha;

    public TemaActividad(Long id) {
        super();
        this.id = id;
    }

    public TemaActividad(boolean estado, Date fecha) {
        this.estado = estado;
        this.fecha = fecha;
    }
    
    
    
    
}
