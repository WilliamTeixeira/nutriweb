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
import Model.Dao.exceptions.IllegalOrphanException;
import Model.Dao.exceptions.NonexistentEntityException;
import Model.HorrarioRefeicao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daves
 */
public class HorrarioRefeicaoJpaController implements Serializable {

    public HorrarioRefeicaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HorrarioRefeicao horrarioRefeicao) {
        if (horrarioRefeicao.getConsumoDiarioList() == null) {
            horrarioRefeicao.setConsumoDiarioList(new ArrayList<ConsumoDiario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ConsumoDiario> attachedConsumoDiarioList = new ArrayList<ConsumoDiario>();
            for (ConsumoDiario consumoDiarioListConsumoDiarioToAttach : horrarioRefeicao.getConsumoDiarioList()) {
                consumoDiarioListConsumoDiarioToAttach = em.getReference(consumoDiarioListConsumoDiarioToAttach.getClass(), consumoDiarioListConsumoDiarioToAttach.getConsumoDiarioPK());
                attachedConsumoDiarioList.add(consumoDiarioListConsumoDiarioToAttach);
            }
            horrarioRefeicao.setConsumoDiarioList(attachedConsumoDiarioList);
            em.persist(horrarioRefeicao);
            for (ConsumoDiario consumoDiarioListConsumoDiario : horrarioRefeicao.getConsumoDiarioList()) {
                HorrarioRefeicao oldHorrarioRefeicaoOfConsumoDiarioListConsumoDiario = consumoDiarioListConsumoDiario.getHorrarioRefeicao();
                consumoDiarioListConsumoDiario.setHorrarioRefeicao(horrarioRefeicao);
                consumoDiarioListConsumoDiario = em.merge(consumoDiarioListConsumoDiario);
                if (oldHorrarioRefeicaoOfConsumoDiarioListConsumoDiario != null) {
                    oldHorrarioRefeicaoOfConsumoDiarioListConsumoDiario.getConsumoDiarioList().remove(consumoDiarioListConsumoDiario);
                    oldHorrarioRefeicaoOfConsumoDiarioListConsumoDiario = em.merge(oldHorrarioRefeicaoOfConsumoDiarioListConsumoDiario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HorrarioRefeicao horrarioRefeicao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HorrarioRefeicao persistentHorrarioRefeicao = em.find(HorrarioRefeicao.class, horrarioRefeicao.getIdhorrarioRefeicao());
            List<ConsumoDiario> consumoDiarioListOld = persistentHorrarioRefeicao.getConsumoDiarioList();
            List<ConsumoDiario> consumoDiarioListNew = horrarioRefeicao.getConsumoDiarioList();
            List<String> illegalOrphanMessages = null;
            for (ConsumoDiario consumoDiarioListOldConsumoDiario : consumoDiarioListOld) {
                if (!consumoDiarioListNew.contains(consumoDiarioListOldConsumoDiario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ConsumoDiario " + consumoDiarioListOldConsumoDiario + " since its horrarioRefeicao field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ConsumoDiario> attachedConsumoDiarioListNew = new ArrayList<ConsumoDiario>();
            for (ConsumoDiario consumoDiarioListNewConsumoDiarioToAttach : consumoDiarioListNew) {
                consumoDiarioListNewConsumoDiarioToAttach = em.getReference(consumoDiarioListNewConsumoDiarioToAttach.getClass(), consumoDiarioListNewConsumoDiarioToAttach.getConsumoDiarioPK());
                attachedConsumoDiarioListNew.add(consumoDiarioListNewConsumoDiarioToAttach);
            }
            consumoDiarioListNew = attachedConsumoDiarioListNew;
            horrarioRefeicao.setConsumoDiarioList(consumoDiarioListNew);
            horrarioRefeicao = em.merge(horrarioRefeicao);
            for (ConsumoDiario consumoDiarioListNewConsumoDiario : consumoDiarioListNew) {
                if (!consumoDiarioListOld.contains(consumoDiarioListNewConsumoDiario)) {
                    HorrarioRefeicao oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario = consumoDiarioListNewConsumoDiario.getHorrarioRefeicao();
                    consumoDiarioListNewConsumoDiario.setHorrarioRefeicao(horrarioRefeicao);
                    consumoDiarioListNewConsumoDiario = em.merge(consumoDiarioListNewConsumoDiario);
                    if (oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario != null && !oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario.equals(horrarioRefeicao)) {
                        oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario.getConsumoDiarioList().remove(consumoDiarioListNewConsumoDiario);
                        oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario = em.merge(oldHorrarioRefeicaoOfConsumoDiarioListNewConsumoDiario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = horrarioRefeicao.getIdhorrarioRefeicao();
                if (findHorrarioRefeicao(id) == null) {
                    throw new NonexistentEntityException("The horrarioRefeicao with id " + id + " no longer exists.");
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
            HorrarioRefeicao horrarioRefeicao;
            try {
                horrarioRefeicao = em.getReference(HorrarioRefeicao.class, id);
                horrarioRefeicao.getIdhorrarioRefeicao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horrarioRefeicao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ConsumoDiario> consumoDiarioListOrphanCheck = horrarioRefeicao.getConsumoDiarioList();
            for (ConsumoDiario consumoDiarioListOrphanCheckConsumoDiario : consumoDiarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This HorrarioRefeicao (" + horrarioRefeicao + ") cannot be destroyed since the ConsumoDiario " + consumoDiarioListOrphanCheckConsumoDiario + " in its consumoDiarioList field has a non-nullable horrarioRefeicao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(horrarioRefeicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HorrarioRefeicao> findHorrarioRefeicaoEntities() {
        return findHorrarioRefeicaoEntities(true, -1, -1);
    }

    public List<HorrarioRefeicao> findHorrarioRefeicaoEntities(int maxResults, int firstResult) {
        return findHorrarioRefeicaoEntities(false, maxResults, firstResult);
    }

    private List<HorrarioRefeicao> findHorrarioRefeicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HorrarioRefeicao.class));
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

    public HorrarioRefeicao findHorrarioRefeicao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HorrarioRefeicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorrarioRefeicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HorrarioRefeicao> rt = cq.from(HorrarioRefeicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
