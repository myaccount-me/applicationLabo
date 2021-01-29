/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Labo;
import jpa.LaboFacadeLocal;
import jpa.Region;
import jpa.RegionFacadeLocal;


@WebServlet(name = "addlabo", urlPatterns = {"/addlabo"})
public class addlabo extends HttpServlet {

    @EJB
    private RegionFacadeLocal regionFacade;

    @EJB
    private LaboFacadeLocal laboFacade;

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        int id_region = Integer.parseInt(request.getParameter("region"));
        String mdp = request.getParameter("mdp");
        Labo l= new Labo();
        l.setNom(nom);
        l.setEmail(email);
        l.setIdRegion(id_region);
        l.setLogin(login);
        l.setMdp(mdp);
        laboFacade.create(l);
        response.sendRedirect("/Applabo-war/ajouterlab.jsp");
       // RequestDispatcher dispatcher =request.getRequestDispatcher("/ajouterlab.jsp");
        //dispatcher.forward(request, response);
       
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <Region> regions =regionFacade.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("regions",regions);
        //RequestDispatcher dispatcher =request.getRequestDispatcher("/ajouterlab.jsp");
        //dispatcher.forward(request, response);
        
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
