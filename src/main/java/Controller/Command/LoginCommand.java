/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import Model.Dao.UserJpaController;
import Model.User;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
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
public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            String login = request.getParameter("cpUsername");
            String senha = Util.toMd5(request.getParameter("cpPassword"));

            User u = new UserJpaController((EntityManagerFactory) request.getAttribute("emf")).getUserByLoginAndSenha(login, senha);
            if (u != null) {
                request.getSession().setAttribute("logado", "1");
                u.getHistoricoList();
                u.getConsumoDiarioList();
                request.getSession().setAttribute("user", u);
            } else {
                ((ArrayList<String>) request.getAttribute("erroMessage")).add("Login ou Senha Incorreta!!!");
            }
        } catch (Exception e) {
                ((ArrayList<String>) request.getAttribute("erroMessage")).add(e.getMessage());
        }
        return null;
    }

}
