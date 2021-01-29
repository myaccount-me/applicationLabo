/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Admin;
import jpa.AdminFacadeLocal;

/**
 *
 * @author hp
 */
public class connexionAdmin extends HttpServlet {

    @EJB
    private AdminFacadeLocal adminFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     request.getSession().invalidate();
     response.sendRedirect("/Applabo-war/loginadmin.jsp");
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
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        List <Admin> res=adminFacade.Connexion(login, mdp);
        if(res.isEmpty()){
            response.sendRedirect("/Applabo-war/loginadmin.jsp");
        }else{
            response.sendRedirect("/Applabo-war/ajouterlab.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("idA",res.get(0).getIdAdmin());
        }
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
