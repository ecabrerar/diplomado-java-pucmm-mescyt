/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ecabrerar
 */
public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntroduccionJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Pais p = new Pais();
        p.setNombre("Republica Dominicana");

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Pelicula uno");
        pelicula.setDescripcion("Esta es una pelicula de Prueba");
        pelicula.setDuracion(120);
        pelicula.setGenero("Drama");

        

        tx.begin();
        
        try {
            em.persist(p);

            p = em.getReference(Pais.class, 1L);
            
            pelicula.setPaisOrigen(p);
            em.persist(pelicula);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        em.close();
        emf.close();
    }
}
