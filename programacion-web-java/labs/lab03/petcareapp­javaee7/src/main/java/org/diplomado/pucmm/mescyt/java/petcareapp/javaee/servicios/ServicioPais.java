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
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
@Stateless
public class ServicioPais {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    public List<Pais> consultarTodas(){
        
        return entityManager.createNamedQuery("Pais.findAll").getResultList();
    }
    
    public Pais modificar(@NotNull Pais pais){
        
        Pais p = entityManager.find(Pais.class, pais.getId());
        p.setDescripcion(pais.getDescripcion());
        
      return entityManager.merge(p);
        
    }
    
    public Pais consultarPorId(@NotNull int idPais){
       return entityManager.find(Pais.class, idPais);
    }
}
