/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.ConsumoDiario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.User;
import Model.HorrarioRefeicao;
import Model.ConsumoDiarioAlimento;
import Model.ConsumoDiarioPK;
import Model.Dao.exceptions.IllegalOrphanException;
import Model.Dao.exceptions.NonexistentEntityException;
import Model.Dao.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Daves
 */
public class ConsumoDiarioJpaController implements Serializable {

    public ConsumoDiarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ConsumoDiario consumoDiario) throws PreexistingEntityException, Exception {
        if (consumoDiario.getConsumoDiarioPK() == null) {
            consumoDiario.setConsumoDiarioPK(new ConsumoDiarioPK());
        }
        if (consumoDiario.getConsumoDiarioAlimentoList() == null) {
            consumoDiario.setConsumoDiarioAlimentoList(new ArrayList<ConsumoDiarioAlimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User user = consumoDiario.getUser();
            if (user != null) {
                user = em.getReference(user.getClass(), user.getIduser());
                consumoDiario.setUser(user);
            }
            HorrarioRefeicao horrarioRefeicao = consumoDiario.getHorrarioRefeicao();
            if (horrarioRefeicao != null) {
                horrarioRefeicao = em.getReference(horrarioRefeicao.getClass(), horrarioRefeicao.getIdhorrarioRefeicao());
                consumoDiario.setHorrarioRefeicao(horrarioRefeicao);
            }
            List<ConsumoDiarioAlimento> attachedConsumoDiarioAlimentoList = new ArrayList<ConsumoDiarioAlimento>();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach : consumoDiario.getConsumoDiarioAlimentoList()) {
                consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach = em.getReference(consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach.getClass(), consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach.getConsumoDiarioAlimentoPK());
                attachedConsumoDiarioAlimentoList.add(consumoDiarioAlimentoListConsumoDiarioAlimentoToAttach);
            }
            consumoDiario.setConsumoDiarioAlimentoList(attachedConsumoDiarioAlimentoList);
            em.persist(consumoDiario);
            if (user != null) {
                user.getConsumoDiarioList().add(consumoDiario);
                user = em.merge(user);
            }
            if (horrarioRefeicao != null) {
                horrarioRefeicao.getConsumoDiarioList().add(consumoDiario);
                horrarioRefeicao = em.merge(horrarioRefeicao);
            }
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListConsumoDiarioAlimento : consumoDiario.getConsumoDiarioAlimentoList()) {
                ConsumoDiario oldConsumoDiarioOfConsumoDiarioAlimentoListConsumoDiarioAlimento = consumoDiarioAlimentoListConsumoDiarioAlimento.getConsumoDiario();
                consumoDiarioAlimentoListConsumoDiarioAlimento.setConsumoDiario(consumoDiario);
                consumoDiarioAlimentoListConsumoDiarioAlimento = em.merge(consumoDiarioAlimentoListConsumoDiarioAlimento);
                if (oldConsumoDiarioOfConsumoDiarioAlimentoListConsumoDiarioAlimento != null) {
                    oldConsumoDiarioOfConsumoDiarioAlimentoListConsumoDiarioAlimento.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimentoListConsumoDiarioAlimento);
                    oldConsumoDiarioOfConsumoDiarioAlimentoListConsumoDiarioAlimento = em.merge(oldConsumoDiarioOfConsumoDiarioAlimentoListConsumoDiarioAlimento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsumoDiario(consumoDiario.getConsumoDiarioPK()) != null) {
                throw new PreexistingEntityException("ConsumoDiario " + consumoDiario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ConsumoDiario consumoDiario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsumoDiario persistentConsumoDiario = em.find(ConsumoDiario.class, consumoDiario.getConsumoDiarioPK());
            User userOld = persistentConsumoDiario.getUser();
            User userNew = consumoDiario.getUser();
            HorrarioRefeicao horrarioRefeicaoOld = persistentConsumoDiario.getHorrarioRefeicao();
            HorrarioRefeicao horrarioRefeicaoNew = consumoDiario.getHorrarioRefeicao();
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListOld = persistentConsumoDiario.getConsumoDiarioAlimentoList();
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListNew = consumoDiario.getConsumoDiarioAlimentoList();
            List<String> illegalOrphanMessages = null;
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListOldConsumoDiarioAlimento : consumoDiarioAlimentoListOld) {
                if (!consumoDiarioAlimentoListNew.contains(consumoDiarioAlimentoListOldConsumoDiarioAlimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ConsumoDiarioAlimento " + consumoDiarioAlimentoListOldConsumoDiarioAlimento + " since its consumoDiario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (userNew != null) {
                userNew = em.getReference(userNew.getClass(), userNew.getIduser());
                consumoDiario.setUser(userNew);
            }
            if (horrarioRefeicaoNew != null) {
                horrarioRefeicaoNew = em.getReference(horrarioRefeicaoNew.getClass(), horrarioRefeicaoNew.getIdhorrarioRefeicao());
                consumoDiario.setHorrarioRefeicao(horrarioRefeicaoNew);
            }
            List<ConsumoDiarioAlimento> attachedConsumoDiarioAlimentoListNew = new ArrayList<ConsumoDiarioAlimento>();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach : consumoDiarioAlimentoListNew) {
                consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach = em.getReference(consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach.getClass(), consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach.getConsumoDiarioAlimentoPK());
                attachedConsumoDiarioAlimentoListNew.add(consumoDiarioAlimentoListNewConsumoDiarioAlimentoToAttach);
            }
            consumoDiarioAlimentoListNew = attachedConsumoDiarioAlimentoListNew;
            consumoDiario.setConsumoDiarioAlimentoList(consumoDiarioAlimentoListNew);
            consumoDiario = em.merge(consumoDiario);
            if (userOld != null && !userOld.equals(userNew)) {
                userOld.getConsumoDiarioList().remove(consumoDiario);
                userOld = em.merge(userOld);
            }
            if (userNew != null && !userNew.equals(userOld)) {
                userNew.getConsumoDiarioList().add(consumoDiario);
                userNew = em.merge(userNew);
            }
            if (horrarioRefeicaoOld != null && !horrarioRefeicaoOld.equals(horrarioRefeicaoNew)) {
                horrarioRefeicaoOld.getConsumoDiarioList().remove(consumoDiario);
                horrarioRefeicaoOld = em.merge(horrarioRefeicaoOld);
            }
            if (horrarioRefeicaoNew != null && !horrarioRefeicaoNew.equals(horrarioRefeicaoOld)) {
                horrarioRefeicaoNew.getConsumoDiarioList().add(consumoDiario);
                horrarioRefeicaoNew = em.merge(horrarioRefeicaoNew);
            }
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListNewConsumoDiarioAlimento : consumoDiarioAlimentoListNew) {
                if (!consumoDiarioAlimentoListOld.contains(consumoDiarioAlimentoListNewConsumoDiarioAlimento)) {
                    ConsumoDiario oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento = consumoDiarioAlimentoListNewConsumoDiarioAlimento.getConsumoDiario();
                    consumoDiarioAlimentoListNewConsumoDiarioAlimento.setConsumoDiario(consumoDiario);
                    consumoDiarioAlimentoListNewConsumoDiarioAlimento = em.merge(consumoDiarioAlimentoListNewConsumoDiarioAlimento);
                    if (oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento != null && !oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento.equals(consumoDiario)) {
                        oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento.getConsumoDiarioAlimentoList().remove(consumoDiarioAlimentoListNewConsumoDiarioAlimento);
                        oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento = em.merge(oldConsumoDiarioOfConsumoDiarioAlimentoListNewConsumoDiarioAlimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ConsumoDiarioPK id = consumoDiario.getConsumoDiarioPK();
                if (findConsumoDiario(id) == null) {
                    throw new NonexistentEntityException("The consumoDiario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ConsumoDiarioPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsumoDiario consumoDiario;
            try {
                consumoDiario = em.getReference(ConsumoDiario.class, id);
                consumoDiario.getConsumoDiarioPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consumoDiario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ConsumoDiarioAlimento> consumoDiarioAlimentoListOrphanCheck = consumoDiario.getConsumoDiarioAlimentoList();
            for (ConsumoDiarioAlimento consumoDiarioAlimentoListOrphanCheckConsumoDiarioAlimento : consumoDiarioAlimentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ConsumoDiario (" + consumoDiario + ") cannot be destroyed since the ConsumoDiarioAlimento " + consumoDiarioAlimentoListOrphanCheckConsumoDiarioAlimento + " in its consumoDiarioAlimentoList field has a non-nullable consumoDiario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            User user = consumoDiario.getUser();
            if (user != null) {
                user.getConsumoDiarioList().remove(consumoDiario);
                user = em.merge(user);
            }
            HorrarioRefeicao horrarioRefeicao = consumoDiario.getHorrarioRefeicao();
            if (horrarioRefeicao != null) {
                horrarioRefeicao.getConsumoDiarioList().remove(consumoDiario);
                horrarioRefeicao = em.merge(horrarioRefeicao);
            }
            em.remove(consumoDiario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ConsumoDiario> findConsumoDiarioEntities() {
        return findConsumoDiarioEntities(true, -1, -1);
    }

    public List<ConsumoDiario> findConsumoDiarioEntities(int maxResults, int firstResult) {
        return findConsumoDiarioEntities(false, maxResults, firstResult);
    }

    private List<ConsumoDiario> findConsumoDiarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ConsumoDiario.class));
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

    public ConsumoDiario findConsumoDiario(ConsumoDiarioPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ConsumoDiario.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsumoDiarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ConsumoDiario> rt = cq.from(ConsumoDiario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ConsumoDiario> findConsumoDiarioAlimentoByUser(Integer iduser) {

        Query q = getEntityManager().createNamedQuery("ConsumoDiario.findByIduserMaxDate");
        q.setParameter("iduser", iduser);
        return q.getResultList();

    }

    public List<Date> findDatasByUser(Integer iduser) {

        Query q = getEntityManager().createNamedQuery("ConsumoDiario.findDatasByUser");
        q.setParameter("iduser", iduser);
        return q.getResultList();
    }

    public List<ConsumoDiario> findConsumoDiarioAlimentoByUserbyData(Integer iduser, Date data) {
      
        Query q = getEntityManager().createNamedQuery("ConsumoDiario.findByIduserByDate");
        q.setParameter("iduser", iduser);
        q.setParameter("iddate", data);
        return q.getResultList();
    }

}
