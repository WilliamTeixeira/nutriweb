/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Historico;
import Model.HistoricoPK;
import Model.User;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Command.Command;

/**
 *
 * @author Daves
 */
public class PainelIMCCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<String> error = ((ArrayList<String>) request.getAttribute("erroMessage"));
        User u = null;
        try {
            u = (User) request.getSession().getAttribute("user");
            Historico h = new Historico(new HistoricoPK(0, u.getIduser()));
            h.setDataMedida(new Date());
            h.setPeso(Double.parseDouble(request.getParameter("cpPeso")));
            h.setAltura(Double.parseDouble(request.getParameter("cpAltura")));
            h.setUser(u);
            u.getHistoricoList().add(h);

            EntityManager em = null;
            try {
                em = ((EntityManagerFactory) request.getAttribute("emf")).createEntityManager();
                em.getTransaction().begin();

                em.persist(h);
                em.flush();
                //em.persist(u);

                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
            } finally {
                if (em != null) {
                    em.close();
                }
            }

        } catch (NumberFormatException e) {
            request.setAttribute("userCad", u);
            error.add("Erro ao converter para número: " + e.getMessage());
            return null;
        } catch (Exception e) {
            request.setAttribute("userCad", u);
            error.add(e.getMessage());
            return null;
        }
        error.add("Dados salvos com sucesso!");
        return null;
    }

}
