/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.repository;

import com.example.KichwaService.model.Palabra;
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
public class PalabraRepositoryImpl implements PalabraRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Palabra> getPalabraLike(String sig_esp) {
        Query query = entityManager.createNativeQuery("SELECT p.* from palabra p "
                + "WHERE p.sig_esp LIKE ?", Palabra.class);
        query.setParameter(1, sig_esp+"%");
        return query.getResultList();
    }
    
    
}
