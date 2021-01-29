/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.Patient;
import jpa.PatientFacadeLocal;

/**
 *
 * @author asus
 */
@WebServlet(name = "edit", urlPatterns = {"/edit"})
public class edit extends HttpServlet {

        @EJB
    private PatientFacadeLocal patientFacade;

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient pat;
        int idpat = Integer.parseInt(request.getParameter("idpat"));
        int cin = Integer.parseInt(request.getParameter("cin")) ;
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        //String dnaiss = request.getParameter("dnaiss");
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date dnaiss=null;
        try {
            dnaiss = format.parse(request.getParameter("dnaiss"));
        } catch (ParseException ex) {
            Logger.getLogger(addpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tel = Integer.parseInt(request.getParameter("tel"));
        String email = request.getParameter("email");
        String sexe = request.getParameter("sexe");
        int reg =  Integer.parseInt(request.getParameter("reg")) ;
       if (sexe.equals("femme")) {
           
         pat = new Patient(idpat,nom,prenom, dnaiss,tel,email,reg,cin,"Femme");
        
       }
        else{
          pat = new Patient(idpat,nom,prenom, dnaiss,tel,email,reg,cin,"Homme");
        
        }
      // patientFacade.remove(idpat);
        patientFacade.edit(pat);
        response.sendRedirect("/Applabo-war/consultelistepatient.jsp");
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
