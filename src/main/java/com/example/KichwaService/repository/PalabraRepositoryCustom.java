/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.KichwaService.repository;

import com.example.KichwaService.model.Palabra;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabraRepositoryCustom {
    List<Palabra> getPalabraLike(String sig_esp);
}
