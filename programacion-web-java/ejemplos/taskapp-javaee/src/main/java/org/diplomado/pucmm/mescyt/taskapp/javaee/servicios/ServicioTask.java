/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.taskapp.javaee.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.diplomado.pucmm.mescyt.taskapp.javaee.entidades.Task;

/**
 *
 * @author ecabrerar
 * @date Aug 26, 2016
 */
@Stateless
public class ServicioTask {

    @PersistenceContext(name = "taskapp-javaeePU")
    private EntityManager em;

    public List<Task> consultarTodas() {

        TypedQuery<Task> query = em.createNamedQuery("Task.findAll", Task.class);

        return query.getResultList();
    }

    public List<Task> consultarPorFinalizado(boolean isFinalizado) {

        TypedQuery<Task> query = em.createNamedQuery("Task.findByFinalizado", Task.class)
                .setParameter("finalizado", isFinalizado);

        return query.getResultList();
    }

    public Task consultarTaskPorId(int id) {
        Task task = em.find(Task.class, id);

        if (task == null) {
            throw new EntityNotFoundException(String.format("No fue encontrado registro para el ID %d", id));
        }

        return task;
    }

    public Task guardarTask(Task task) {
        em.persist(task);

        return task;
    }

    public Task modificarTask(Task task) {
        return em.merge(task);
    }

    public void borrarTask(int id) {
        Task task = consultarTaskPorId(id);

        em.remove(task);
    }
}
