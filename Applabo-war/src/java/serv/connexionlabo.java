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
import jpa.Labo;
import jpa.LaboFacadeLocal;

/**
 *
 * @author hp
 */
public class connexionlabo extends HttpServlet {

    @EJB
    private LaboFacadeLocal laboFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     request.getSession().invalidate();
     response.sendRedirect("/Applabo-war/login.jsp");
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
        List <Labo> res=laboFacade.Connexion(login, mdp);
        if(res.isEmpty()){
            response.sendRedirect("/Applabo-war/login.jsp");
        }else{
            response.sendRedirect("/Applabo-war/index.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("id",res.get(0).getIdLabo());
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
