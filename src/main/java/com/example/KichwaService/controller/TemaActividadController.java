/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.TemaActividad;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.TemaActividadRepository;
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
@RequestMapping("/tema_actividad")
public class TemaActividadController {
    @Autowired
    TemaActividadRepository temaActividadRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<TemaActividad> listaTemaActividads(){
        return this.temaActividadRepository.findAll();
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public TemaActividad crearTemaActividad(@RequestBody TemaActividad temaActividad){
        return this.temaActividadRepository.save(temaActividad);
    }
    
    @DeleteMapping("/eliminar/{id_tem_act}")
    @CrossOrigin
    public void eliminarTemaActividad(@PathVariable Long id_tem_act){
        this.temaActividadRepository.deleteById(id_tem_act);
    }
    
    @PutMapping("/modificar/{id_tem_act}")
    @CrossOrigin
    public TemaActividad modificarTemaActividad(@RequestBody TemaActividad temaActividad, @PathVariable Long id_tem_act){
        this.temaActividadRepository.deleteById(id_tem_act);
        return this.temaActividadRepository.save(temaActividad);
    }
}
