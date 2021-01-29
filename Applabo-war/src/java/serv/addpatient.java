/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Patient;
import jpa.PatientFacadeLocal;
import jpa.Region;
import jpa.RegionFacadeLocal;


/**
 *
 * @author asus
 */
@WebServlet(name = "addpatient", urlPatterns = {"/addpatient"})
public class addpatient extends HttpServlet {

    @EJB
    private RegionFacadeLocal regionFacade;

    @EJB
    private PatientFacadeLocal patientFacade;

    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     // List<Region> regions = regionFacade.findAll();
       //request.setAttribute("regions", regionFacade.findAll());
      request.getRequestDispatcher("/ajoutpat.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         Patient p;
        int cin = Integer.parseInt(request.getParameter("cin"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int tel = Integer.parseInt(request.getParameter("tel"));
       DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date date=null;
        try {
            date = format.parse(request.getParameter("dnaiss"));
        } catch (ParseException ex) {
            Logger.getLogger(addpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        String email = request.getParameter("email");
       String sexe = request.getParameter("sexe");
        int reg = Integer.parseInt(request.getParameter("reg"));
        if (sexe.equals("femme")) { 
         p = new Patient(nom,prenom,date,tel,email,reg,cin,"Femme");}
        else{
          p = new Patient(nom,prenom, date,tel,email,reg,cin,"Femme");
        }
        try{
        patientFacade.create(p);
        response.sendRedirect("/Applabo-war/consultelistepatient.jsp");
        }catch(Exception ex){
            System.out.println("erreur : " + ex.toString());
            response.sendRedirect("/Applabo-war/ajoutpat.jsp");
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
