/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Palabra;
import com.example.KichwaService.repository.PalabraRepository;
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
@RequestMapping("/palabra")
public class PalabraController {
    @Autowired
    PalabraRepository palabraRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<Palabra> listarPalabras(){
        return this.palabraRepository.findAll();
    }
    
    @PostMapping("/crear")
    @CrossOrigin
    public Palabra crearPalabra(@RequestBody Palabra palabra){
        return this.palabraRepository.save(palabra);
    }
    
    @DeleteMapping("/eliminar/{id_palabra}")
    @CrossOrigin
    public void eliminarPalabra(@PathVariable Long id_palabra){
        this.palabraRepository.deleteById(id_palabra);
    }
    
    @PutMapping("/modificar/{id_palabra}")
    @CrossOrigin
    public Palabra modificarPalabra(@RequestBody Palabra palabra, Long id_palabra){
        this.palabraRepository.deleteById(id_palabra);
        return this.palabraRepository.save(palabra);
    }
    
}
