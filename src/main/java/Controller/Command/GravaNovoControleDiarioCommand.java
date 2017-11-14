/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Alimento;
import Model.ConsumoDiario;
import Model.ConsumoDiarioAlimento;
import Model.ConsumoDiarioAlimentoPK;
import Model.ConsumoDiarioPK;
import Model.HorrarioRefeicao;
import Model.RefeicoesObjetivo;
import Model.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Command.Command;
import util.Util;

/**
 *
 * @author Daves
 */
public class GravaNovoControleDiarioCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<String> error = ((ArrayList<String>) request.getAttribute("erroMessage"));
        User u = null;
        EntityManager em = null;
        try {
            u = (User) request.getSession().getAttribute("user");
            String objetivo = request.getParameter("objetivo");
            String dataConsumo = request.getParameter("datepicker");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            em = ((EntityManagerFactory) request.getAttribute("emf")).createEntityManager();
            em.getTransaction().begin();

            u = em.getReference(User.class, u.getIduser());

            Query q = em.createNamedQuery("HorrarioRefeicao.findAll");
            List<HorrarioRefeicao> listaHor = q.getResultList();

            //Tipos de Refeições
            for (HorrarioRefeicao hr : listaHor) {
                RefeicoesObjetivo ro = Util.findDieta(u.getObjetivo(), hr.getDescricao());
                if (ro != null) {
                    ConsumoDiario cd = new ConsumoDiario(new ConsumoDiarioPK(u.getIduser(), hr.getIdhorrarioRefeicao(), sdf.parse(dataConsumo)));
                    cd.setUser(u);
                    cd.setHorrarioRefeicao(hr);
                    cd.setHorario(ro.getHorario());
                    cd.setCalMax(ro.getCalMax());
                    u.getConsumoDiarioList().add(cd);
                    em.persist(cd);
                    em.flush();
                }
            }
            u.setObjetivo(objetivo);
            em.persist(u);

            em.getTransaction().commit();
            request.getSession().setAttribute("user", u);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        error.add("Novo registro para Consumo de Alimentos criado com Sucesso!");
        return null;

    }

}
