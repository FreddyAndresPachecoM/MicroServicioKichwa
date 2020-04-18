/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.exception.ResourceNotFoundException;
import com.example.KichwaService.model.UsuarioMetaDiaria;
import com.example.KichwaService.repository.UsuarioMetaDiariaRepository;
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
@RequestMapping("/usuario_meta_diaria")
public class UsuarioMetaDiariaController {
    @Autowired
    UsuarioMetaDiariaRepository usuarioMetaDiariaRepository;
    
    @GetMapping("/listar")
    @CrossOrigin
    public List<UsuarioMetaDiaria> listarUsuarioMetaDiarias (){
        return this.usuarioMetaDiariaRepository.findAll();
    }
    
    @GetMapping("/buscar/{id_met_dia}")
    @CrossOrigin
    public ResponseEntity<UsuarioMetaDiaria> getUsuarioMetaDiariaById(@PathVariable(value = "id_met_dia") Long id_met_dia) 
            throws ResourceNotFoundException{
            UsuarioMetaDiaria usuarioMetaDiaria= usuarioMetaDiariaRepository.findById(id_met_dia)
                    .orElseThrow(() -> new ResourceNotFoundException("UsuarioMetaDiaria not found for this id :: " + id_met_dia));
        return ResponseEntity.ok().body(usuarioMetaDiaria);
        
    }    
    
    @PostMapping("/crear")
    @CrossOrigin
    public UsuarioMetaDiaria crearUsuarioMetaDiaria(@RequestBody UsuarioMetaDiaria usuarioMetaDiaria){
        return this.usuarioMetaDiariaRepository.save(usuarioMetaDiaria);
    }
    
    @DeleteMapping("/eliminar/{id_usu_met_dia}")
    @CrossOrigin
    public void eliminarUsuarioMetaDiaria(@PathVariable Long id_usu_met_dia){
        this.usuarioMetaDiariaRepository.deleteById(id_usu_met_dia);
    }
    
    @PutMapping("/modificar/{id_usu_met_dia}")
    @CrossOrigin
//    public UsuarioMetaDiaria modificarUsuarioMetaDiaria(@RequestBody UsuarioMetaDiaria usuarioMetaDiaria, @PathVariable Long id_usu_met_dia){
//        this.usuarioMetaDiariaRepository.deleteById(id_usu_met_dia);
//        return this.usuarioMetaDiariaRepository.save(usuarioMetaDiaria);
//    }
    public ResponseEntity<UsuarioMetaDiaria> updateUsuarioMetaDiaria(@PathVariable (value = "id_met_dia") Long id_met_dia,
            @Valid @RequestBody UsuarioMetaDiaria usuarioMetaDiariaDetails)throws ResourceNotFoundException{
        UsuarioMetaDiaria usuarioMetaDiaria= usuarioMetaDiariaRepository.findById(id_met_dia)
                .orElseThrow(() -> new ResourceNotFoundException("UsuarioMetaDiaria not found for this id :: " + id_met_dia));
        usuarioMetaDiaria.setEstado(usuarioMetaDiariaDetails.isEstado());
        usuarioMetaDiaria.setFecha(usuarioMetaDiariaDetails.getFecha());
        usuarioMetaDiaria.setUsuario(usuarioMetaDiariaDetails.getUsuario());
        
        return ResponseEntity.ok(this.usuarioMetaDiariaRepository.save(usuarioMetaDiaria));
    }
}
