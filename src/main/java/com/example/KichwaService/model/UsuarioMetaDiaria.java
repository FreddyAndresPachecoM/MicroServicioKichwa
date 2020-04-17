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
public class UsuarioMetaDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usu_met_dia")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
    
    @Column(name="estado")
    private boolean estado;
    @Column(name = "fecha")
    private Date fecha;


    public UsuarioMetaDiaria(Long id) {
        this.id = id;
    }  

    public UsuarioMetaDiaria(boolean estado, Date fecha) {
        this.estado = estado;
        this.fecha = fecha;
    }
    
    
}
