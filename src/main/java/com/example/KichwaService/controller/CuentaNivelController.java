/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.CuentaNivel;
import com.example.KichwaService.repository.CuentaNivelRepository;
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
@RequestMapping("/cuenta_nivel")
public class CuentaNivelController {
    @Autowired
    CuentaNivelRepository cuentaNivelRepository;
    
    @GetMapping("/obtenerListaCuentaNivel")
    @CrossOrigin
    public List<CuentaNivel> listarCuentaNiveles(){
        return this.cuentaNivelRepository.findAll();
    }
    
    @PostMapping("/crearCuentaNivel")
    @CrossOrigin
    public CuentaNivel crearCuentaNivel(@RequestBody CuentaNivel cuentaNivel){
        return this.cuentaNivelRepository.save(cuentaNivel);
    }
    
    @DeleteMapping("/eliminar/{id_cuenta_nivel}")
    @CrossOrigin
    public void eliminarCuentaNivel(@PathVariable Long id_cuenta_nivel){
        this.cuentaNivelRepository.deleteById(id_cuenta_nivel);
    }
    
    @PutMapping("/modificar/{id_cuenta_nivel")
    @CrossOrigin
    public CuentaNivel modificarCuentaNivel(@RequestBody CuentaNivel cuentaNivel, @PathVariable Long id_cuenta_nivel){
        this.cuentaNivelRepository.deleteById(id_cuenta_nivel);
        return this.cuentaNivelRepository.save(cuentaNivel);
    }
}
