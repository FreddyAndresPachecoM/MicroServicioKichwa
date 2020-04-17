/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.UsuarioMetaDiaria;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.UsuarioMetaDiariaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario_meta_diaria")
public class UsuarioMetaDiariaController {
    @Autowired
    UsuarioMetaDiariaRepository usuarioMetaDiariaRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<UsuarioMetaDiaria> listarUsuarioMetaDiarias (){
        return this.usuarioMetaDiariaRepository.findAll();
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public UsuarioMetaDiaria crearUsuarioMetaDiaria(@RequestBody UsuarioMetaDiaria usuarioMetaDiaria){
        return this.usuarioMetaDiariaRepository.save(usuarioMetaDiaria);
    }
    
    @DeleteMapping("/eliminar/{id_usu_met_dia}")
    @CrossOrigin
    public void eliminarUsuarioMetaDiaria(@PathVariable Long id_usu_met_dia){
        this.usuarioMetaDiariaRepository.deleteById(id_usu_met_dia);
    }
    
    @PutMapping("/modificar/{id_usu_met_dia}")
    @CrossOrigin
    public UsuarioMetaDiaria modificarUsuarioMetaDiaria(@RequestBody UsuarioMetaDiaria usuarioMetaDiaria, @PathVariable Long id_usu_met_dia){
        this.usuarioMetaDiariaRepository.deleteById(id_usu_met_dia);
        return this.usuarioMetaDiariaRepository.save(usuarioMetaDiaria);
    }
}
