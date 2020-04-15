/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Cuestionario;
import com.example.KichwaService.repository.CuestionarioRepository;
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
@RequestMapping("/cuestionario")
public class CuestionarioController {
    @Autowired
    CuestionarioRepository cuestionarioRepository;
    
    @GetMapping("/obtenerListaCuestionario")
    @CrossOrigin
    public List<Cuestionario> listarCuestionarios(){
        return this.cuestionarioRepository.findAll();
    }
    
    @PostMapping("/crearCuestionario")
    @CrossOrigin
    public Cuestionario crearCuestionario(@RequestBody Cuestionario cuestionario){
        return this.cuestionarioRepository.save(cuestionario);
    }
    
    @DeleteMapping("/eliminar/{id_cuestionario}")
    @CrossOrigin
    public void eliminarCuestionario(@PathVariable Long id_cuestionario){
        this.cuestionarioRepository.deleteById(id_cuestionario);
    }
    
    @PutMapping("/modificar/{id_cuestionario}")
    @CrossOrigin
    public Cuestionario modificarCuestionario(@RequestBody Cuestionario cuestionario, @PathVariable Long id_cuestionario){
        this.cuestionarioRepository.deleteById(id_cuestionario);
        return this.cuestionarioRepository.save(cuestionario);
    }
}
