/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.demo.petcare.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ecabrerar
 */
public class PruebaJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
        
        EntityManager entityManager = emf.createEntityManager();
        
        List<Cliente> resultList = entityManager.createNamedQuery("Cliente.findAll").getResultList();
        // entityManager.createNamedQuery("Cliente.findById").setParameter("id", 1).getSingleResult();
        
        
        
        for (Cliente cliente : resultList) {
            System.out.println("Cliente "+cliente.getNombre());
        }
      
    }
}
