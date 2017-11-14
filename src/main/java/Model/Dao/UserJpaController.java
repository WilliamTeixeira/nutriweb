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
import Model.Historico;
import java.util.ArrayList;
import java.util.List;
import Model.ConsumoDiario;
import Model.Dao.exceptions.IllegalOrphanException;
import Model.Dao.exceptions.NonexistentEntityException;
import Model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 *
 * @author Daves
 */
public class UserJpaController implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(User user) {
        if (user.getHistoricoList() == null) {
            user.setHistoricoList(new ArrayList<Historico>());
        }
        if (user.getConsumoDiarioList() == null) {
            user.setConsumoDiarioList(new ArrayList<ConsumoDiario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Historico> attachedHistoricoList = new ArrayList<Historico>();
            for (Historico historicoListHistoricoToAttach : user.getHistoricoList()) {
                historicoListHistoricoToAttach = em.getReference(historicoListHistoricoToAttach.getClass(), historicoListHistoricoToAttach.getHistoricoPK());
                attachedHistoricoList.add(historicoListHistoricoToAttach);
            }
            user.setHistoricoList(attachedHistoricoList);
            List<ConsumoDiario> attachedConsumoDiarioList = new ArrayList<ConsumoDiario>();
            for (ConsumoDiario consumoDiarioListConsumoDiarioToAttach : user.getConsumoDiarioList()) {
                consumoDiarioListConsumoDiarioToAttach = em.getReference(consumoDiarioListConsumoDiarioToAttach.getClass(), consumoDiarioListConsumoDiarioToAttach.getConsumoDiarioPK());
                attachedConsumoDiarioList.add(consumoDiarioListConsumoDiarioToAttach);
            }
            user.setConsumoDiarioList(attachedConsumoDiarioList);
            em.persist(user);
            for (Historico historicoListHistorico : user.getHistoricoList()) {
                User oldUserOfHistoricoListHistorico = historicoListHistorico.getUser();
                historicoListHistorico.setUser(user);
                historicoListHistorico = em.merge(historicoListHistorico);
                if (oldUserOfHistoricoListHistorico != null) {
                    oldUserOfHistoricoListHistorico.getHistoricoList().remove(historicoListHistorico);
                    oldUserOfHistoricoListHistorico = em.merge(oldUserOfHistoricoListHistorico);
                }
            }
            for (ConsumoDiario consumoDiarioListConsumoDiario : user.getConsumoDiarioList()) {
                User oldUserOfConsumoDiarioListConsumoDiario = consumoDiarioListConsumoDiario.getUser();
                consumoDiarioListConsumoDiario.setUser(user);
                consumoDiarioListConsumoDiario = em.merge(consumoDiarioListConsumoDiario);
                if (oldUserOfConsumoDiarioListConsumoDiario != null) {
                    oldUserOfConsumoDiarioListConsumoDiario.getConsumoDiarioList().remove(consumoDiarioListConsumoDiario);
                    oldUserOfConsumoDiarioListConsumoDiario = em.merge(oldUserOfConsumoDiarioListConsumoDiario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(User user) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User persistentUser = em.find(User.class, user.getIduser());
            List<Historico> historicoListOld = persistentUser.getHistoricoList();
            List<Historico> historicoListNew = user.getHistoricoList();
            List<ConsumoDiario> consumoDiarioListOld = persistentUser.getConsumoDiarioList();
            List<ConsumoDiario> consumoDiarioListNew = user.getConsumoDiarioList();
            List<String> illegalOrphanMessages = null;
            for (Historico historicoListOldHistorico : historicoListOld) {
                if (!historicoListNew.contains(historicoListOldHistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historico " + historicoListOldHistorico + " since its user field is not nullable.");
                }
            }
            for (ConsumoDiario consumoDiarioListOldConsumoDiario : consumoDiarioListOld) {
                if (!consumoDiarioListNew.contains(consumoDiarioListOldConsumoDiario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ConsumoDiario " + consumoDiarioListOldConsumoDiario + " since its user field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Historico> attachedHistoricoListNew = new ArrayList<Historico>();
            for (Historico historicoListNewHistoricoToAttach : historicoListNew) {
                historicoListNewHistoricoToAttach = em.getReference(historicoListNewHistoricoToAttach.getClass(), historicoListNewHistoricoToAttach.getHistoricoPK());
                attachedHistoricoListNew.add(historicoListNewHistoricoToAttach);
            }
            historicoListNew = attachedHistoricoListNew;
            user.setHistoricoList(historicoListNew);
            List<ConsumoDiario> attachedConsumoDiarioListNew = new ArrayList<ConsumoDiario>();
            for (ConsumoDiario consumoDiarioListNewConsumoDiarioToAttach : consumoDiarioListNew) {
                consumoDiarioListNewConsumoDiarioToAttach = em.getReference(consumoDiarioListNewConsumoDiarioToAttach.getClass(), consumoDiarioListNewConsumoDiarioToAttach.getConsumoDiarioPK());
                attachedConsumoDiarioListNew.add(consumoDiarioListNewConsumoDiarioToAttach);
            }
            consumoDiarioListNew = attachedConsumoDiarioListNew;
            user.setConsumoDiarioList(consumoDiarioListNew);
            user = em.merge(user);
            for (Historico historicoListNewHistorico : historicoListNew) {
                if (!historicoListOld.contains(historicoListNewHistorico)) {
                    User oldUserOfHistoricoListNewHistorico = historicoListNewHistorico.getUser();
                    historicoListNewHistorico.setUser(user);
                    historicoListNewHistorico = em.merge(historicoListNewHistorico);
                    if (oldUserOfHistoricoListNewHistorico != null && !oldUserOfHistoricoListNewHistorico.equals(user)) {
                        oldUserOfHistoricoListNewHistorico.getHistoricoList().remove(historicoListNewHistorico);
                        oldUserOfHistoricoListNewHistorico = em.merge(oldUserOfHistoricoListNewHistorico);
                    }
                }
            }
            for (ConsumoDiario consumoDiarioListNewConsumoDiario : consumoDiarioListNew) {
                if (!consumoDiarioListOld.contains(consumoDiarioListNewConsumoDiario)) {
                    User oldUserOfConsumoDiarioListNewConsumoDiario = consumoDiarioListNewConsumoDiario.getUser();
                    consumoDiarioListNewConsumoDiario.setUser(user);
                    consumoDiarioListNewConsumoDiario = em.merge(consumoDiarioListNewConsumoDiario);
                    if (oldUserOfConsumoDiarioListNewConsumoDiario != null && !oldUserOfConsumoDiarioListNewConsumoDiario.equals(user)) {
                        oldUserOfConsumoDiarioListNewConsumoDiario.getConsumoDiarioList().remove(consumoDiarioListNewConsumoDiario);
                        oldUserOfConsumoDiarioListNewConsumoDiario = em.merge(oldUserOfConsumoDiarioListNewConsumoDiario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getIduser();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getIduser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Historico> historicoListOrphanCheck = user.getHistoricoList();
            for (Historico historicoListOrphanCheckHistorico : historicoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Historico " + historicoListOrphanCheckHistorico + " in its historicoList field has a non-nullable user field.");
            }
            List<ConsumoDiario> consumoDiarioListOrphanCheck = user.getConsumoDiarioList();
            for (ConsumoDiario consumoDiarioListOrphanCheckConsumoDiario : consumoDiarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the ConsumoDiario " + consumoDiarioListOrphanCheckConsumoDiario + " in its consumoDiarioList field has a non-nullable user field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public User getUserByLoginAndSenha(String login, String senha) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("User.findByLoginSenha");
        q.setParameter("email", login);
        q.setParameter("senha", senha);
        try {
            return (User) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }

    }

}
