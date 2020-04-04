/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;


import lombok.*;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()

@Entity
public class CuentaNivel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta_nivel")
    private Long id;
    
    //Creacion de una foreing key
    //union con la entidad de Cuenta
    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
    
    //Creacion de una foreing key
    //union con la entidad de Nivel
    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "porcentaje")
    private double porcentaje;
    
}
