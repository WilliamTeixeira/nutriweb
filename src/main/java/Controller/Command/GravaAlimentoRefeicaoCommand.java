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
import Model.Historico;
import Model.HistoricoPK;
import Model.HorrarioRefeicao;
import Model.RefeicoesObjetivo;
import Model.User;
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
public class GravaAlimentoRefeicaoCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<String> error = ((ArrayList<String>) request.getAttribute("erroMessage"));
        User u = null;
        EntityManager em = null;
        try {
            u = (User) request.getSession().getAttribute("user");
            String horrarioRefeicao = request.getParameter("idhorrarioRefeicao");
            int alimento = Integer.parseInt(request.getParameter("cpAlimento"));
            int qtde = Integer.parseInt(request.getParameter("cpQtde"));
            Date dt = (Date) request.getSession().getAttribute("dataFiltro");

            em = ((EntityManagerFactory) request.getAttribute("emf")).createEntityManager();
            em.getTransaction().begin();
            Query q = em.createNamedQuery("ConsumoDiario.findByIduserAndIdTipoRefeicaoByDate");
            q.setParameter("iduser", u.getIduser());
            q.setParameter("idTipoRefeicao", Integer.parseInt(horrarioRefeicao.substring(2, horrarioRefeicao.length())));
            q.setParameter("iddate", dt);
            ConsumoDiario cd = (ConsumoDiario) q.getSingleResult();
            Alimento ali = em.find(Alimento.class, alimento);

            ConsumoDiarioAlimento cda = new ConsumoDiarioAlimento(new ConsumoDiarioAlimentoPK(u.getIduser(), cd.getConsumoDiarioPK().getIdTipoRefeicao(), cd.getConsumoDiarioPK().getData(), alimento), qtde);
            cda.setConsumoDiario(cd);
            cda.setAlimento(ali);
            cd.getConsumoDiarioAlimentoList().add(cda);

            em.persist(cda);
//            em.flush();

            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
        } catch (NonUniqueResultException e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao Converter o número: " + e.getMessage());
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }

        error.add("Alimento registrado com Sucesso!");
        return null;
    }

}
