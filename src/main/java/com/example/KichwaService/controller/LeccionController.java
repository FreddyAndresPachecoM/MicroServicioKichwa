/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Leccion;
import com.example.KichwaService.repository.ActividadRepository;
import com.example.KichwaService.repository.LeccionRepository;
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
@RequestMapping("/leccion")
public class LeccionController {
    @Autowired
    LeccionRepository leccionRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<Leccion> listaLeccion(){
        return this.leccionRepository.findAll();
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public Leccion crearLeccion(@RequestBody Leccion leccion){
        return this.leccionRepository.save(leccion);
    }
    
    @DeleteMapping("/eliminar/{id_leccion}")
    @CrossOrigin
    public void eliminarLeccion(@PathVariable Long id_leccion){
        this.leccionRepository.deleteById(id_leccion);
    }
    
    @PutMapping("/modificar/{id_leccion}")
    @CrossOrigin
    public Leccion modificarLeccion(@RequestBody Leccion leccion, @PathVariable Long id_leccion){
        this.leccionRepository.deleteById(id_leccion);
        return this.leccionRepository.save(leccion);
    }
}
