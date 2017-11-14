/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Alimento;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Command.Command;

/**
 *
 * @author daves
 */
public class AjaxFindCaloriaAlimentoCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityManager em = null;
        try {
            em = ((EntityManagerFactory) request.getAttribute("emf")).createEntityManager();
            em.getTransaction().begin();
            
             Query q = em.createNamedQuery("Alimento.findByIdalimento"); 
             q.setParameter("idalimento", Integer.parseInt(request.getParameter("option1")));
            Alimento ali = (Alimento) q.getSingleResult();
            
            request.setAttribute("alimento", ali);
            request.setAttribute("qtde", Integer.parseInt(request.getParameter("option2")));

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao buscar Dados: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
            return "ajaxResultCaloria";
        }

    }

}
