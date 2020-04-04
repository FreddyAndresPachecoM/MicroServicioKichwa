/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Cuenta;
import com.example.KichwaService.repository.CuentaRepository;
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
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    CuentaRepository cuentaRepository;
    
    @GetMapping("")
    @CrossOrigin
    public List<Cuenta> listarCuentas(){
        return this.cuentaRepository.findAll();
    }
    
    @PostMapping("")
    @CrossOrigin
    public Cuenta crearCuenta(@RequestBody Cuenta c){
        return this.cuentaRepository.save(c);
    }
    
    @DeleteMapping("/{id_cuenta}")
    @CrossOrigin
    public void eliminarCuenta(@PathVariable Long id_cuenta){
        this.cuentaRepository.deleteById(id_cuenta);
    }
    
    @PutMapping("/{id_cuenta}")
    @CrossOrigin
    public Cuenta modificarCuenta(@RequestBody Cuenta c, @PathVariable Long id_cuenta){
        this.cuentaRepository.deleteById(id_cuenta);
        return this.cuentaRepository.save(c);
    }
                
}
