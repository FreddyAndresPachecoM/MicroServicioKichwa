/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tema_actividad")
public class TemaActividad implements Serializable {
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
        super();
        this.estado = estado;
        this.fecha = fecha;
    }

    public TemaActividad(ActividadUsuario actividadUsuario, Tema tema, boolean estado, Date fecha) {
        super();
        this.actividadUsuario = actividadUsuario;
        this.tema = tema;
        this.estado = estado;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TemaActividad{" + "id=" + id + ", actividadUsuario=" + actividadUsuario + ", tema=" + tema + ", estado=" + estado + ", fecha=" + fecha + '}';
    }   
    
    
}
