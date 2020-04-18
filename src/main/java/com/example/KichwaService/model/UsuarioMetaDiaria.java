/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
@Table(name = "usuario_meta_diaria")
public class UsuarioMetaDiaria implements Serializable {
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
        super();
        this.id = id;
    }  

    public UsuarioMetaDiaria(boolean estado, Date fecha) {
        super();
        this.estado = estado;
        this.fecha = fecha;
    }

    public UsuarioMetaDiaria(Usuario usuario, boolean estado, Date fecha) {
        this.usuario = usuario;
        this.estado = estado;
        this.fecha = fecha;
    }    
    

    @Override
    public String toString() {
        return "UsuarioMetaDiaria{" + "id=" + id + ", usuario=" + usuario + ", estado=" + estado + ", fecha=" + fecha + '}';
    }
    
    
}
