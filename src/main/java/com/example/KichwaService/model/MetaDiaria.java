/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

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
public class MetaDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_meta_diaria")
    private Long id;
    
    @Column (name = "min_exp")
    private double min_exp;
    
    @Column (name = "fecha_inicia")
    private Date fecha_inicia;
    
    //union con la entidad Cuenta
    @ManyToOne
    @JoinColumn(name="id_cuenta", nullable=false)
    private Cuenta cuenta;
    
}
