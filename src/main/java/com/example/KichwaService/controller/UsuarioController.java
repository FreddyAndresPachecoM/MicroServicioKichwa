/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.model.Usuario;
import com.example.KichwaService.repository.UsuarioRepository;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/getListaUsuario")
    @CrossOrigin
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }    
    
    @PostMapping("/crearUsuario")
    @CrossOrigin
    public Usuario crearUsuario(@RequestBody Usuario u){
        return this.usuarioRepository.save(u);
    }
    
    @DeleteMapping("/eliminar/{id_usuario}")
    @CrossOrigin
    public void eliminarUsuario(@PathVariable Long id_usuario){
        this.usuarioRepository.deleteById(id_usuario);
    }
    
    @PutMapping("/modificar/{id_usuario}")
    @CrossOrigin
    public Usuario modificarUsuario(@RequestBody Usuario u, @PathVariable Long id_usuario){
        this.usuarioRepository.deleteById(id_usuario);
        return this.usuarioRepository.save(u);
    }
            
}
