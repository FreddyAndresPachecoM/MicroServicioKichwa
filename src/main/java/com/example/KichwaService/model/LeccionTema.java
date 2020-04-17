/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
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
public class LeccionTema {
    @JsonBackReference
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lec_tem")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_tem_act",referencedColumnName = "id_tem_act")
    private TemaActividad temaActividad;
    
    @ManyToOne
    @JoinColumn(name = "id_leccion",referencedColumnName = "id_leccion")
    private Leccion leccion;
    
    @Column(name="estado")
    private boolean estado;
    
    @Column(name = "fecha")
    private Date fecha;

    public LeccionTema(Long id) {
        super();
        this.id = id;
    }

    public LeccionTema(boolean estado, Date fecha) {
        this.estado = estado;
        this.fecha = fecha;
    }
    
    
}
