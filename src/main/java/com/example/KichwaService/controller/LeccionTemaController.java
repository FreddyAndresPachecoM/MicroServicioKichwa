/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.exception.ResourceNotFoundException;
import com.example.KichwaService.model.LeccionTema;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.LeccionTemaRepository;
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
@RequestMapping("/leccion_tema")
public class LeccionTemaController {
    @Autowired
    LeccionTemaRepository leccionTemaRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<LeccionTema> listarTema(){
        return this.leccionTemaRepository.findAll();
    }
    
    @GetMapping("/buscar/{id_lec_tem}")
    @CrossOrigin
    public ResponseEntity<LeccionTema> getLeccionTema(@PathVariable (value = "id_lec_tem") Long id_lec_tem)
            throws ResourceNotFoundException{
        LeccionTema leccionTema = leccionTemaRepository.findById(id_lec_tem)
                .orElseThrow(()-> new ResourceNotFoundException("LeccionTema no encontrado con el id :: "+id_lec_tem));
        
        return ResponseEntity.ok().body(leccionTema);
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public LeccionTema crearLeccionTema(@RequestBody LeccionTema leccionTema){
        return this.leccionTemaRepository.save(leccionTema);
    }
    
    @DeleteMapping("/eliminar/{id_lec_tem}")
    @CrossOrigin
    public void eliminarLeccionTema(@PathVariable Long id_lec_tem){
        this.leccionTemaRepository.deleteById(id_lec_tem);
    }
    
    @PutMapping("/modificar/{id_lec_tem}")
    @CrossOrigin
//    public LeccionTema modificarLeccionTema(@RequestBody LeccionTema leccionTema, @PathVariable Long id_lec_tem){
//        this.leccionTemaRepository.deleteById(id_lec_tem);
//        return this.leccionTemaRepository.save(leccionTema);
//    }
    public ResponseEntity<LeccionTema> updateLeccionTema(@PathVariable (value = "id_lec_tem") Long id_lec_tem,
            @Valid @RequestBody LeccionTema leccionTemaDetails) throws ResourceNotFoundException{
        LeccionTema leccionTema = leccionTemaRepository.findById(id_lec_tem)
                .orElseThrow(()-> new ResourceNotFoundException("LeccionTema no encontrado por el id :: "+id_lec_tem));
        leccionTema.setEstado(leccionTemaDetails.isEstado());
        leccionTema.setFecha(leccionTemaDetails.getFecha());
        leccionTema.setLeccion(leccionTemaDetails.getLeccion());
        leccionTema.setTemaActividad(leccionTemaDetails.getTemaActividad());
        
        return ResponseEntity.ok(this.leccionTemaRepository.save(leccionTema));
    }
}
