/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladore;

import Controladores.exceptions.NonexistentEntityException;
import entidades.SfmCliente;
import common.AbstractController;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import common.AbstractFacade;
import java.util.Collection;
import javax.persistence.TypedQuery;

/**
 *
 * @author cgomez
 */
public class SfmClienteController extends AbstractController {

    public SfmClienteController() {

    }

    public Collection<SfmCliente> listarclientes() {
        EntityManager em = null;
        try {
        em = getEntityManager();
//        TypedQuery<SfmCliente> query = em.createNamedQuery("SfmCliente.findAll", SfmCliente.class);
//        List<SfmCliente> results = query.getResultList();
//        return results;
        return (Collection<SfmCliente>) em.createNamedQuery("SfmCliente.findAll").getResultList();
        
        } finally {
            if (em != null) {
                em.close();
            }
    }
}
//    return (Collection<Professor>) em.createNamedQuery("findProfessorsAboveSal")
//                                      .setParameter("dept", dept)
//                                      .setParameter("sal", minSal)
//                                      .getResultList();
    public void create(SfmCliente sfmCliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sfmCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SfmCliente sfmCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sfmCliente = em.merge(sfmCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sfmCliente.getIdCliente();
                if (findSfmCliente(id) == null) {
                    throw new NonexistentEntityException("The sfmCliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SfmCliente sfmCliente;
            try {
                sfmCliente = em.getReference(SfmCliente.class, id);
                sfmCliente.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sfmCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(sfmCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SfmCliente> findSfmClienteEntities() {
        return findSfmClienteEntities(true, -1, -1);
    }

    public List<SfmCliente> findSfmClienteEntities(int maxResults, int firstResult) {
        return findSfmClienteEntities(false, maxResults, firstResult);
    }

    private List<SfmCliente> findSfmClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SfmCliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SfmCliente findSfmCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SfmCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getSfmClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SfmCliente> rt = cq.from(SfmCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
