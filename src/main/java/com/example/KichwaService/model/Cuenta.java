/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter()
@Setter()


@Entity
public class Cuenta {
    @JsonBackReference
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta")
    private Long id;
    
    @Column(name="avance_total")
    private double avance;    
        
    //union con la entidad usuario
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Usuario usuario;
    
    //union con la entidad MetaDiaria
//    @OneToMany(mappedBy="cuenta")
//    private Set<MetaDiaria> metaDiarias;

    //union con la entidad CuentaNivel
//    @OneToMany(mappedBy = "cuenta")
//    Set<CuentaNivel> cuentaNivels;
    
}
