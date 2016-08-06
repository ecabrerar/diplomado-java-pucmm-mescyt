/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
@Stateless
public class ServicioPais {
 
  @PersistenceContext
  private EntityManager entityManager;
    
    public List<Pais> consultarTodos(){
        
      return  entityManager.createNamedQuery("Pais.findAll").getResultList();
      
    }
}
