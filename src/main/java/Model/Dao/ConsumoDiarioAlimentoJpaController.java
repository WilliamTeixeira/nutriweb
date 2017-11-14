/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ConsumoDiario;
import Model.Alimento;
import Model.ConsumoDiarioAlimento;
import Model.ConsumoDiarioAlimentoPK;
import Model.Dao.exceptions.NonexistentEntityException;
import Model.Dao.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daves
 */
public class ConsumoDiarioAlimentoJpaController implements Serializable {

    public ConsumoDiarioAlimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ConsumoDiarioAlimento consumoDiarioAlimento) throws PreexistingEntityException, Exception {
        if (consumoDiarioAlimento.getConsumoDiarioAlimentoPK() == null) {
            consumoDiarioAlimento.setConsumoDiarioAlimentoPK(new ConsumoDiarioAlimentoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsumoDiario consumoDiario = consumoDiarioAlimento.getConsumoDiario();
            if (consumoDiario != null) {
                consumoDiario = em.getReference(consumoDiario.getClass(), consumoDiario.getConsumoDiarioPK());
                consumoDiarioAlimento.setConsumoDiario(consumoDiario);
            }
            Alimento alimento = consumoDiarioAlimento.getAlimento();
            if (alimento != null) {
                alimento = em.getReference(alimento.getClass(), alimento.getIdalimento());
                consumoDiarioAlimento.setAlimento(alimento);
            }
            em.persist(consumoDiarioAlimento);
            if (consumoDiario != null) {
                consumoDiario.getConsumoDiarioAlimentoList().add(consumoDiarioAlimento);
                consumoDiario = em.merge(consumoDiario);
            }
            if (alimento != null) {
                alimento.getConsumoDiarioAlimentoList().add(consumoDiarioAlimento);
                alimento = em.merge(alimento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsumoDiarioAlimento(consumoDiarioAlimento.getConsumoDiarioAlimentoPK()) != null) {
                throw new PreexistingEntityException("ConsumoDiarioAlimento " + consumoDiarioAlimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ConsumoDiarioAlimento consumoDiarioAlimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsumoDiarioAlimento persistentConsumoDiarioAlimento = em.find(ConsumoDiarioAlimento.class, consumoDiarioAlimento.getConsumoDiarioAlimentoPK());
            ConsumoDiario consumoDiarioOld = persistentConsumoDiarioAlimento.getConsumoDiario();
            ConsumoDiario consumoDiarioNew = consumoDiarioAlimento.getConsumoDiario();
            Alimento alimentoOld = persistentConsumoDiarioAlimento.getAlimento();
            Alimento alimentoNew = consumoDiarioAlimento.getAlimento();
            if (consumoDiarioNew != null) {
                consumoDiarioNew = em.getReference(consumoDiarioNew.getClass(), consumoDiarioNew.getConsumoDiarioPK());
                consumoDiarioAlimento.setConsumoDiario(consumoDiarioNew);
            }
            if (alimentoNew != null) {
                alimentoNew = em.getReference(alimentoNew.getClass(), alimentoNew.getIdalimento());
                consumoDiarioAlimento.setAlimento(alimentoNew);
            }
            consumoDiarioAlimento = em.merge(consumoDiarioAlimento);
            if (consumoDiarioOld != null && !consumoDiarioOld.equals(consumoDiarioNew)) {
                consumoDiarioOld.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimento);
                consumoDiarioOld = em.merge(consumoDiarioOld);
            }
            if (consumoDiarioNew != null && !consumoDiarioNew.equals(consumoDiarioOld)) {
                consumoDiarioNew.getConsumoDiarioAlimentoList().add(consumoDiarioAlimento);
                consumoDiarioNew = em.merge(consumoDiarioNew);
            }
            if (alimentoOld != null && !alimentoOld.equals(alimentoNew)) {
                alimentoOld.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimento);
                alimentoOld = em.merge(alimentoOld);
            }
            if (alimentoNew != null && !alimentoNew.equals(alimentoOld)) {
                alimentoNew.getConsumoDiarioAlimentoList().add(consumoDiarioAlimento);
                alimentoNew = em.merge(alimentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ConsumoDiarioAlimentoPK id = consumoDiarioAlimento.getConsumoDiarioAlimentoPK();
                if (findConsumoDiarioAlimento(id) == null) {
                    throw new NonexistentEntityException("The consumoDiarioAlimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ConsumoDiarioAlimentoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsumoDiarioAlimento consumoDiarioAlimento;
            try {
                consumoDiarioAlimento = em.getReference(ConsumoDiarioAlimento.class, id);
                consumoDiarioAlimento.getConsumoDiarioAlimentoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consumoDiarioAlimento with id " + id + " no longer exists.", enfe);
            }
            ConsumoDiario consumoDiario = consumoDiarioAlimento.getConsumoDiario();
            if (consumoDiario != null) {
                consumoDiario.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimento);
                consumoDiario = em.merge(consumoDiario);
            }
            Alimento alimento = consumoDiarioAlimento.getAlimento();
            if (alimento != null) {
                alimento.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimento);
                alimento = em.merge(alimento);
            }
            em.remove(consumoDiarioAlimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ConsumoDiarioAlimento> findConsumoDiarioAlimentoEntities() {
        return findConsumoDiarioAlimentoEntities(true, -1, -1);
    }

    public List<ConsumoDiarioAlimento> findConsumoDiarioAlimentoEntities(int maxResults, int firstResult) {
        return findConsumoDiarioAlimentoEntities(false, maxResults, firstResult);
    }

    private List<ConsumoDiarioAlimento> findConsumoDiarioAlimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ConsumoDiarioAlimento.class));
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

    public ConsumoDiarioAlimento findConsumoDiarioAlimento(ConsumoDiarioAlimentoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ConsumoDiarioAlimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsumoDiarioAlimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ConsumoDiarioAlimento> rt = cq.from(ConsumoDiarioAlimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }


}
