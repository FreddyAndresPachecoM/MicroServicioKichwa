/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.repository;


import com.example.KichwaService.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asrock Gamer
 */
@Repository
@Transactional(readOnly = true)
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Usuario> getCorreosUsuariosLike(String correo) {
        Query query = entityManager.createNativeQuery("SELECT u.* from usuario u "
                + "where u.correo LIKE ?", Usuario.class);
        query.setParameter(1, correo +"%");
        return query.getResultList();
    }
    
//    m.* FROM spring_data_jpa_example.employee as em " + "WHERE
}
