/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Command;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Command.Command;

/**
 *
 * @author Daves
 */
public class FiltraControleDiarioCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filtro = request.getParameter("cpDataFiltro");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        request.getSession().setAttribute("dataFiltro", sdf.parse(filtro));
        return null;
    }

}
