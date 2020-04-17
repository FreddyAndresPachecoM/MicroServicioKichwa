/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.ActividadUsuario;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.ActividadUsuarioRepository;
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
@RequestMapping("/actividad_usuario")
public class ActividadUsuarioController {
    @Autowired
    ActividadUsuarioRepository actividadUsuarioRepository;
    
    @GetMapping("/obtenerListaActividadUsuario")
    @CrossOrigin
    public List<ActividadUsuario> listaActividadUsuario(){
        return this.actividadUsuarioRepository.findAll();
    }
    
    @PostMapping("/crearActividadUsuario")
    @CrossOrigin
    public ActividadUsuario crearActividadUsuario(@RequestBody ActividadUsuario actividadUsuario){
        return this.actividadUsuarioRepository.save(actividadUsuario);
    }
    
    @DeleteMapping("/eliminar/{id_act_usu}")
    @CrossOrigin
    public void eliminarActividadUsuario(@PathVariable Long id_act_usu){
        this.actividadUsuarioRepository.deleteById(id_act_usu);
        
    }
    
    @PutMapping("/modificar/{id_act_usu}")
    @CrossOrigin
    public ActividadUsuario modificarActividadUsuario(@RequestBody ActividadUsuario actividadUsuario,@PathVariable Long id_act_usu){
        this.actividadUsuarioRepository.deleteById(id_act_usu);
        return this.actividadUsuarioRepository.save(actividadUsuario);
    }
    
}
