/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;
import com.example.KichwaService.model.MetaDiaria;
import com.example.KichwaService.repository.MetaDiariaRepository;
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
@RequestMapping("/meta_diaria")
public class MetaDiariaController {
    @Autowired
    MetaDiariaRepository metaDiariaRepository;
    
    @GetMapping("/obtenerListaMetaDiaria")
    @CrossOrigin
    public List<MetaDiaria> listarMetaDiarias(){
        return this.metaDiariaRepository.findAll();
    }
    
    @PostMapping("/crearMetaDiaria")
    @CrossOrigin
    public MetaDiaria crearMetaDiaria(@RequestBody MetaDiaria metaDiaria){
        return this.metaDiariaRepository.save(metaDiaria);
    }
    
    @DeleteMapping("/eliminar/{id_meta_diaria}")
    @CrossOrigin
    public void eliminarMetaDiaria(@PathVariable Long id_meta_diaria){
        this.metaDiariaRepository.deleteById(id_meta_diaria);
    }
    
    @PutMapping("/modificar/{id_meta_diaria}")
    @CrossOrigin
    public MetaDiaria modificarMetaDiaria(@RequestBody MetaDiaria metaDiaria, Long id_meta_diaria){
        this.metaDiariaRepository.deleteById(id_meta_diaria);
        return this.metaDiariaRepository.save(metaDiaria);
    }
}
