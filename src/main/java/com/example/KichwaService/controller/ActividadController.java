/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.exception.ResourceNotFoundException;
import com.example.KichwaService.model.Actividad;
import com.example.KichwaService.repository.ActividadRepository;
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
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    ActividadRepository actividadRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<Actividad> listarActividades(){
        return this.actividadRepository.findAll();
    }
    
    @GetMapping("/buscar/{id_actividad}")
    @CrossOrigin
    public ResponseEntity<Actividad> getActividadById(@PathVariable (value = "id_actividad") Long id_actividad)
            throws ResourceNotFoundException{
        Actividad actividad = actividadRepository.findById(id_actividad)
                .orElseThrow(()-> new ResourceNotFoundException("Actividad no encontrada por el id :: "+id_actividad));
        return ResponseEntity.ok().body(actividad);
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public Actividad crearActividad(@RequestBody Actividad a){
        return this.actividadRepository.save(a);
    }
    
    @DeleteMapping("/eliminar/{id_actividad}")
    @CrossOrigin
    public void eliminarActividad(@PathVariable Long id_actividad){
        this.actividadRepository.deleteById(id_actividad);
    }
    
    @PutMapping("/modificar/{id_actividad")
    @CrossOrigin
//    public Actividad modificarActividad(@RequestBody Actividad a, @PathVariable Long id_actividad){
//        this.actividadRepository.deleteById(id_actividad);
//        return this.actividadRepository.save(a);
//    }
    public ResponseEntity<Actividad> updateActividad(@PathVariable (value = "id_actividad")Long id_actividad,
            @Valid @RequestBody Actividad actividadDetails) throws ResourceNotFoundException{
        Actividad actividad = actividadRepository.findById(id_actividad)
                .orElseThrow(()-> new ResourceNotFoundException("Actividad no encontrada por el id :: "+id_actividad));
        actividad.setDescripcion(actividadDetails.getDescripcion());
        actividad.setNombre(actividadDetails.getNombre());
        
        return ResponseEntity.ok(this.actividadRepository.save(actividad));
    }
            
}
