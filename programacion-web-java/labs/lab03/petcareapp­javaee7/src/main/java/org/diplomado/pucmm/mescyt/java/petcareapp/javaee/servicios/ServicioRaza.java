/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Raza;

/**
 *
 * @author ecabrerar
 */
@Stateless
public class ServicioRaza {
     @PersistenceContext 
     private EntityManager entityManager;
     
     public List<Raza> consultarTodas(){
         return entityManager.createNamedQuery("Raza.findAll").getResultList();
     }
     
      public Raza consultarPorId(@NotNull int id){
         return (Raza) entityManager.createNamedQuery("Raza.findById")
                 .setParameter("id", id)
                 .getSingleResult();
     }
}
