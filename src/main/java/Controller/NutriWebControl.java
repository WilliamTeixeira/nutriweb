/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Command.AjaxFindCaloriaAlimentoCommand;
import Controller.Command.AjaxPreencheAlimentoCommand;
import Controller.Command.AjudaCommand;
import Controller.Command.CadastroCommand;
import Controller.Command.CadastroUserCommand;
import Controller.Command.FiltraControleDiarioCommand;
import Controller.Command.GravaAlimentoRefeicaoCommand;
import Controller.Command.GravaNovoControleDiarioCommand;
import Controller.Command.LoginCommand;
import Controller.Command.LogoutCommand;
import Controller.Command.NoCommand;
import Controller.Command.PainelIMCCommand;
import Model.ConsumoDiario;
import Model.Dao.ConsumoDiarioAlimentoJpaController;
import Model.Dao.ConsumoDiarioJpaController;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Command.Command;

/**
 *
 * @author Daves
 */
@WebServlet(name = "NutriWebControl", urlPatterns = {"/nw"})
public class NutriWebControl extends HttpServlet {

    private static final Map<String, Command> commandsMap = new HashMap<>();

    static {
        commandsMap.put("login", new LoginCommand());//verifica o login no sistema
        commandsMap.put("noCommand", new NoCommand());//chamada de comandos serrado
        commandsMap.put("about", new AjudaCommand());//chama pagina de ajuda
        commandsMap.put("logout", new LogoutCommand());//logout no sistema
        commandsMap.put("cadastro", new CadastroCommand());//chama tela de cadastro
        commandsMap.put("cadUser", new CadastroUserCommand());//grava usuario
        commandsMap.put("panelPesoAltura", new PainelIMCCommand());//grava novo peso e altura
        commandsMap.put("ajaxAlimento", new AjaxPreencheAlimentoCommand());//Ajax para preencher a combo de alimentos
        commandsMap.put("ajaxCaloria", new AjaxFindCaloriaAlimentoCommand());//Ajax para preencher a combo de alimentos
        commandsMap.put("newAlimentoConsumido", new GravaAlimentoRefeicaoCommand());//grava o alimento consumido na refeição pelo usuário 
        commandsMap.put("NovoControleDiario", new GravaNovoControleDiarioCommand());//grava o alimento consumido na refeição pelo usuário 
        commandsMap.put("panelFiltro", new FiltraControleDiarioCommand());//grava o alimento consumido na refeição pelo usuário 
    }

    public static Command get(String commandName) {
        if (commandName == null || !commandsMap.containsKey(commandName)) {
            //LOG.trace("Command not found, name --> " + commandName);
            return commandsMap.get("noCommand");
        }
        return commandsMap.get(commandName);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EntityManagerFactory emf = null;
        String ac = request.getParameter("ac");
        String forward = null;
        try {
            emf = Persistence.createEntityManagerFactory("nutriWebPU");
            request.setAttribute("emf", emf);

            if (ac == null) {
                if (request.getSession().getAttribute("user") != null) {
                    User u = (User) request.getSession().getAttribute("user");
                    List<Date> listaDatas = new ConsumoDiarioJpaController(emf).findDatasByUser(u.getIduser());
                    List<ConsumoDiario> listaconsumoDiario = null;

                    request.setAttribute("ListaDatas", listaDatas);
                    if (request.getSession().getAttribute("dataFiltro") == null) {
                        request.getSession().setAttribute("dataFiltro", listaDatas.get(0));
                        listaconsumoDiario = new ConsumoDiarioJpaController(emf).findConsumoDiarioAlimentoByUser(u.getIduser());
                    } else {
                        Date dt = (Date) request.getSession().getAttribute("dataFiltro");
                        listaconsumoDiario = new ConsumoDiarioJpaController(emf).findConsumoDiarioAlimentoByUserbyData(u.getIduser(), dt);
                    }
                    request.setAttribute("ListaconsumoDiario", listaconsumoDiario);
                }
            } else {
                ArrayList<String> listaError = new ArrayList<String>();
                request.setAttribute("erroMessage", listaError);
                try {

                    forward = get(ac).execute(request, response);

                    if (forward == null) {
                        User u = (User) request.getSession().getAttribute("user");
                        List<Date> listaDatas = new ConsumoDiarioJpaController(emf).findDatasByUser(u.getIduser());
                        List<ConsumoDiario> listaconsumoDiario = null;

                        request.setAttribute("ListaDatas", listaDatas);
                        if (request.getSession().getAttribute("dataFiltro") == null) {
                            request.getSession().setAttribute("dataFiltro", listaDatas.get(0));
                            listaconsumoDiario = new ConsumoDiarioJpaController(emf).findConsumoDiarioAlimentoByUser(u.getIduser());
                        } else {
                            Date dt = (Date) request.getSession().getAttribute("dataFiltro");
                            listaconsumoDiario = new ConsumoDiarioJpaController(emf).findConsumoDiarioAlimentoByUserbyData(u.getIduser(), dt);
                        }
                        request.setAttribute("ListaconsumoDiario", listaconsumoDiario);
                    }

                } catch (Exception ex) {
                    listaError.add(ex.getMessage());
                    request.setAttribute("erroMessage", listaError);
                }
            }
        } finally {
            request.removeAttribute("emf");
            if (emf != null) {
                emf.close();
            }

            if (ac != null && ac.contains("ajax")) {
                request.getRequestDispatcher("assert/ajax/" + forward + ".jsp").forward(request, response);
            } else {
                if (forward != null) {
                    request.setAttribute("page", forward);
                }
                request.getRequestDispatcher("templateNW.jsp").forward(request, response);
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
