/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.exception.ResourceNotFoundException;
import com.example.KichwaService.model.TemaActividad;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.TemaActividadRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping("/buscar/{id_tem_act}")
    @CrossOrigin
    public ResponseEntity<TemaActividad> getTemaActividad(@PathVariable (value = "id_tem_act") Long id_tem_act)
            throws ResourceNotFoundException{
        TemaActividad temaActividad= temaActividadRepository.findById(id_tem_act)
                .orElseThrow(()-> new ResourceNotFoundException("TemaActividad no encontrado con el id :: "+id_tem_act));
        return ResponseEntity.ok().body(temaActividad);
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
//    public TemaActividad modificarTemaActividad(@RequestBody TemaActividad temaActividad, @PathVariable Long id_tem_act){
//        this.temaActividadRepository.deleteById(id_tem_act);
//        return this.temaActividadRepository.save(temaActividad);
//    }
    public ResponseEntity<TemaActividad> updateTemaActividad(@PathVariable (value = "id_tem_act") Long id_tem_act,
            @Valid @RequestBody TemaActividad temaActividadDetails)throws ResourceNotFoundException{
        TemaActividad temaActividad = temaActividadRepository.findById(id_tem_act)
                .orElseThrow(() -> new ResourceNotFoundException("TemaActividad no encontrado por el id :: "+id_tem_act));
        temaActividad.setActividadUsuario(temaActividadDetails.getActividadUsuario());
        temaActividad.setEstado(temaActividadDetails.isEstado());
        temaActividad.setFecha(temaActividadDetails.getFecha());
        temaActividad.setTema(temaActividadDetails.getTema());
        
        return ResponseEntity.ok(this.temaActividadRepository.save(temaActividad));
    }
}
