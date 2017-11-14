/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.ConsumoDiario;
import Model.ConsumoDiarioPK;
import Model.Dao.UserJpaController;
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
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.exceptions.EntityManagerSetupException;
import util.Command.Command;
import util.Util;
import util.exception.CriptografiaException;

/**
 *
 * @author Daves
 */
public class CadastroUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<String> error = ((ArrayList<String>) request.getAttribute("erroMessage"));
        User u = null;
        try {
            u = new User(0,
                    request.getParameter("cpNome"),
                    request.getParameter("cpUsername"),
                    Util.toMd5(request.getParameter("cpPassword")), "Emagrecer");
            u.getHistoricoList().add(new Historico(new HistoricoPK(0, 0)));
            u.getHistoricoList().get(0).setDataMedida(new Date());
            u.getHistoricoList().get(0).setPeso(Double.parseDouble(request.getParameter("cpPeso")));
            u.getHistoricoList().get(0).setAltura(Double.parseDouble(request.getParameter("cpAltura")));

            //Validações
            if (u.getNome().equals("")) {
                error.add("Nome deve ser Preenchido");
            }
            if (u.getEmail().equals("")) {
                error.add("Email deve ser Preenchido");
            }
            if (!u.getSenha().equals(Util.toMd5(request.getParameter("cpPassword1")))) {
                error.add("Senha não estão iguais");
            }
            if (error.size() > 0) {
                request.setAttribute("userCad", u);
                return "cadastro";
            } else {
                EntityManager em = null;
                try {
                    em = ((EntityManagerFactory) request.getAttribute("emf")).createEntityManager();
                    em.getTransaction().begin();
                    Query q = em.createNamedQuery("HorrarioRefeicao.findAll");
                    List<HorrarioRefeicao> listaHor = q.getResultList();

                    Historico h = u.getHistoricoList().get(0);
                    u.getHistoricoList().remove(0);

                    em.persist(u);
                    em.flush();

                    //Historico Peso
                    h.setHistoricoPK(new HistoricoPK(0, u.getIduser()));
                    h.setUser(u);
                    u.getHistoricoList().add(h);

                    //Tipos de Refeições
                    for (HorrarioRefeicao hr : listaHor) {
                        RefeicoesObjetivo ro = Util.findDieta(u.getObjetivo(), hr.getDescricao());
                        if (ro != null) {
                            ConsumoDiario cd = new ConsumoDiario(new ConsumoDiarioPK(u.getIduser(), hr.getIdhorrarioRefeicao(), new Date()));
                            cd.setUser(u);
                            cd.setHorrarioRefeicao(hr);
                            cd.setHorario(ro.getHorario());
                            cd.setCalMax(ro.getCalMax());
                            u.getConsumoDiarioList().add(cd);
                        }
                    }
                    em.persist(h);
                    em.persist(u);

                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    throw new Exception("Erro ao Salvar no Banco de Dados: " + e.getMessage());
                } finally {
                    if (em != null) {
                        em.close();
                    }
                }
            }

        } catch (NumberFormatException e) {
            request.setAttribute("userCad", u);
            error.add("Erro ao converter para número: " + e.getMessage());
            return "cadastro";
        } catch (Exception e) {
            request.setAttribute("userCad", u);
            error.add(e.getMessage());
            return "cadastro";
        }
        error.add("Cadastro efetuado com sucesso! Faça o login");
        return null;
    }

}
