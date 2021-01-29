/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Patient;
import jpa.PatientFacadeLocal;
import jpa.Resultat;
import jpa.ResultatFacadeLocal;

/**
 *
 * @author asus
 */
@WebServlet(name = "consultelistpat", urlPatterns = {"/consultelistpat"})
public class consultelistpat extends HttpServlet {

    @EJB
    private ResultatFacadeLocal resultatFacade;

    @EJB
    private PatientFacadeLocal patientFacade;
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Patient> patients = patientFacade.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("listepatients", patients);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String action = request.getParameter("action");
      if(action.equals("supprimer")){
          int id = Integer.parseInt(request.getParameter("id"));
          resultatFacade.removerslt(id);
          patientFacade.remove(id);
          response.sendRedirect("/Applabo-war/consultelistepatient.jsp");
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
