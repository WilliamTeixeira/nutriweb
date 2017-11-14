/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Dao.exceptions.NonexistentEntityException;
import Model.Dao.exceptions.PreexistingEntityException;
import Model.Historico;
import Model.HistoricoPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daves
 */
public class HistoricoJpaController implements Serializable {

    public HistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historico historico) throws PreexistingEntityException, Exception {
        if (historico.getHistoricoPK() == null) {
            historico.setHistoricoPK(new HistoricoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User user = historico.getUser();
            if (user != null) {
                user = em.getReference(user.getClass(), user.getIduser());
                historico.setUser(user);
            }
            em.persist(historico);
            if (user != null) {
                user.getHistoricoList().add(historico);
                user = em.merge(user);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistorico(historico.getHistoricoPK()) != null) {
                throw new PreexistingEntityException("Historico " + historico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historico historico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historico persistentHistorico = em.find(Historico.class, historico.getHistoricoPK());
            User userOld = persistentHistorico.getUser();
            User userNew = historico.getUser();
            if (userNew != null) {
                userNew = em.getReference(userNew.getClass(), userNew.getIduser());
                historico.setUser(userNew);
            }
            historico = em.merge(historico);
            if (userOld != null && !userOld.equals(userNew)) {
                userOld.getHistoricoList().remove(historico);
                userOld = em.merge(userOld);
            }
            if (userNew != null && !userNew.equals(userOld)) {
                userNew.getHistoricoList().add(historico);
                userNew = em.merge(userNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                HistoricoPK id = historico.getHistoricoPK();
                if (findHistorico(id) == null) {
                    throw new NonexistentEntityException("The historico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(HistoricoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historico historico;
            try {
                historico = em.getReference(Historico.class, id);
                historico.getHistoricoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historico with id " + id + " no longer exists.", enfe);
            }
            User user = historico.getUser();
            if (user != null) {
                user.getHistoricoList().remove(historico);
                user = em.merge(user);
            }
            em.remove(historico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historico> findHistoricoEntities() {
        return findHistoricoEntities(true, -1, -1);
    }

    public List<Historico> findHistoricoEntities(int maxResults, int firstResult) {
        return findHistoricoEntities(false, maxResults, firstResult);
    }

    private List<Historico> findHistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historico.class));
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

    public Historico findHistorico(HistoricoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historico.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historico> rt = cq.from(Historico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
