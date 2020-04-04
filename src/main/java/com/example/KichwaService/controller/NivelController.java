/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Nivel;
import com.example.KichwaService.repository.NivelRepository;
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
@RequestMapping("/nivel")
public class NivelController {
    @Autowired
    NivelRepository nivelRepository;
    
    @GetMapping("")
    @CrossOrigin
    public List<Nivel> listarNiveles(){
        return this.nivelRepository.findAll();
    }
    
    @PostMapping("")
    @CrossOrigin
    public Nivel crearNivel(@RequestBody Nivel nivel){
        return this.nivelRepository.save(nivel);
    }
    
    @DeleteMapping("/{id_nivel}")
    @CrossOrigin
    public void eliminarNivel(@PathVariable Long id_nivel){
        this.nivelRepository.deleteById(id_nivel);
    }
    
    @PutMapping("/{id_nivel}")
    @CrossOrigin
    public Nivel modificarNivel(@RequestBody Nivel nivel, @PathVariable Long id_nivel){
        this.nivelRepository.deleteById(id_nivel);
        return this.nivelRepository.save(nivel);
    }
}
