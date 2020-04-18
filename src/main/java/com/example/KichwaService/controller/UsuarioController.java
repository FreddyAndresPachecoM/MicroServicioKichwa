/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.controller;

import com.example.KichwaService.exception.ResourceNotFoundException;
import com.example.KichwaService.model.Usuario;
import com.example.KichwaService.repository.UsuarioRepository;
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
//@RequestMapping(value = "/usuario", produces = "application/json")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    
//    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @GetMapping("/listar")
    @CrossOrigin
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }    
    
    @GetMapping("/buscar/{id_usuario}")
    @CrossOrigin
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable (value = "id_usuario") Long id_usuario)
            throws ResourceNotFoundException{
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario no encontrado con el id :: "+id_usuario));
        return ResponseEntity.ok().body(usuario);
    }
    
//    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @PostMapping("/crear")
    @CrossOrigin
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }
    
//    @RequestMapping(value = "/eliminar/{id_usuario}", method = RequestMethod.DELETE)
    @DeleteMapping("/eliminar/{id_usuario}")
    @CrossOrigin
    public void eliminarUsuario(@PathVariable Long id_usuario){
        this.usuarioRepository.deleteById(id_usuario);
    }
    
//    @RequestMapping(value = "/modificar/{id_usuario}", method = RequestMethod.PUT)
    @PutMapping("/modificar/{id_usuario}")
    @CrossOrigin
    public ResponseEntity<Usuario> updateUsuario(@PathVariable (value = "id_usuario") Long id_usuario,
            @Valid @RequestBody Usuario usuarioDetails)throws ResourceNotFoundException{
        Usuario usuario= usuarioRepository.findById(id_usuario)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario no encontrado por el id :: "+id_usuario));
        usuario.setCorreo(usuarioDetails.getCorreo());
        usuario.setMotivo(usuarioDetails.getMotivo());
        usuario.setName(usuarioDetails.getName());
        usuario.setPassword(usuarioDetails.getPassword());
        usuario.setSexo(usuarioDetails.getSexo());
        usuario.setUrl_foto(usuarioDetails.getUrl_foto());
        
        return ResponseEntity.ok(this.usuarioRepository.save(usuario));
        
    }
//    public Usuario modificarUsuario(@RequestBody Usuario usuario, @PathVariable Long id_usuario){
//        this.usuarioRepository.deleteById(id_usuario);
//        return this.usuarioRepository.save(usuario);
//    }
            
}
