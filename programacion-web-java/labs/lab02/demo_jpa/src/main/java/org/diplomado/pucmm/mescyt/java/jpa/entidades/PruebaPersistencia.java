/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.jpa.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ecabrerar
 */
public class PruebaPersistencia {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntroduccionJPA");
        
        EntityManager entityManager = emf.createEntityManager();
        
        EntityTransaction tx = entityManager.getTransaction();
        
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Avatar");
        pelicula.setDescripcion("Una prueba con JPA");
        pelicula.setDuracion(180);
        
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("Republica Dominicana");
        
        
        tx.begin();
        try{
   
            entityManager.persist(pais);
            
            Pais p = entityManager.find(Pais.class, 1);
            
            pelicula.setPaisOrigen(p);
            
          entityManager.persist(pelicula);
          tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }
    }
    
}
