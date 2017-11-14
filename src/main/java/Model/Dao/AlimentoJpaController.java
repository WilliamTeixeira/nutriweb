/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Alimento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ConsumoDiarioAlimento;
import Model.Dao.exceptions.IllegalOrphanException;
import Model.Dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daves
 */
public class AlimentoJpaController implements Serializable {

    public AlimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alimento alimento) {
        if (alimento.getConsumoDiarioAlimentoList() == null) {
            alimento.setConsumoDiarioAlimentoList(new ArrayList<ConsumoDiarioAlimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ConsumoDiarioAlimento> attachedConsumoDiarioAlimentoList = new ArrayList<ConsumoDiarioAlimento>();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach : alimento.getConsumoDiarioAlimentoList()) {
                consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach = em.getReference(consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach.getClass(), consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach.getConsumoDiarioAlimentoPK());
                attachedConsumoDiarioAlimentoList.add(consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach);
            }
            alimento.setConsumoDiarioAlimentoList(attachedConsumoDiarioAlimentoList);
            em.persist(alimento);
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListConsumoDiarioAlimento : alimento.getConsumoDiarioAlimentoList()) {
                Alimento oldAlimentoOfConsumoDiarioAlimentoListConsumoDiarioAlimento = consumoDiarioAlimentoListConsumoDiarioAlimento.getAlimento();
                consumoDiarioAlimentoListConsumoDiarioAlimento.setAlimento(alimento);
                consumoDiarioAlimentoListConsumoDiarioAlimento = em.merge(consumoDiarioAlimentoListConsumoDiarioAlimento);
                if (oldAlimentoOfConsumoDiarioAlimentoListConsumoDiarioAlimento != null) {
                    oldAlimentoOfConsumoDiarioAlimentoListConsumoDiarioAlimento.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimentoListConsumoDiarioAlimento);
                    oldAlimentoOfConsumoDiarioAlimentoListConsumoDiarioAlimento = em.merge(oldAlimentoOfConsumoDiarioAlimentoListConsumoDiarioAlimento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alimento alimento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alimento persistentAlimento = em.find(Alimento.class, alimento.getIdalimento());
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListOld = persistentAlimento.getConsumoDiarioAlimentoList();
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListNew = alimento.getConsumoDiarioAlimentoList();
            List<String> illegalOrphanMessages = null;
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListOldConsumoDiarioAlimento : consumoDiarioAlimentoListOld) {
                if (!consumoDiarioAlimentoListNew.contains(consumoDiarioAlimentoListOldConsumoDiarioAlimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ConsumoDiarioAlimento " + consumoDiarioAlimentoListOldConsumoDiarioAlimento + " since its alimento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ConsumoDiarioAlimento> attachedConsumoDiarioAlimentoListNew = new ArrayList<ConsumoDiarioAlimento>();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach : consumoDiarioAlimentoListNew) {
                consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach = em.getReference(consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach.getClass(), consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach.getConsumoDiarioAlimentoPK());
                attachedConsumoDiarioAlimentoListNew.add(consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach);
            }
            consumoDiarioAlimentoListNew = attachedConsumoDiarioAlimentoListNew;
            alimento.setConsumoDiarioAlimentoList(consumoDiarioAlimentoListNew);
            alimento = em.merge(alimento);
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListNewConsumoDiarioAlimento : consumoDiarioAlimentoListNew) {
                if (!consumoDiarioAlimentoListOld.contains(consumoDiarioAlimentoListNewConsumoDiarioAlimento)) {
                    Alimento oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento = consumoDiarioAlimentoListNewConsumoDiarioAlimento.getAlimento();
                    consumoDiarioAlimentoListNewConsumoDiarioAlimento.setAlimento(alimento);
                    consumoDiarioAlimentoListNewConsumoDiarioAlimento = em.merge(consumoDiarioAlimentoListNewConsumoDiarioAlimento);
                    if (oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento != null && !oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento.equals(alimento)) {
                        oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimentoListNewConsumoDiarioAlimento);
                        oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento = em.merge(oldAlimentoOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alimento.getIdalimento();
                if (findAlimento(id) == null) {
                    throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alimento alimento;
            try {
                alimento = em.getReference(Alimento.class, id);
                alimento.getIdalimento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListOrphanCheck = alimento.getConsumoDiarioAlimentoList();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListOrphanCheckConsumoDiarioAlimento : consumoDiarioAlimentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alimento (" + alimento + ") cannot be destroyed since the ConsumoDiarioAlimento " + consumoDiarioAlimentoListOrphanCheckConsumoDiarioAlimento + " in its consumoDiarioAlimentoList field has a non-nullable alimento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alimento> findAlimentoEntities() {
        return findAlimentoEntities(true, -1, -1);
    }

    public List<Alimento> findAlimentoEntities(int maxResults, int firstResult) {
        return findAlimentoEntities(false, maxResults, firstResult);
    }

    private List<Alimento> findAlimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alimento.class));
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

    public Alimento findAlimento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alimento> rt = cq.from(Alimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
