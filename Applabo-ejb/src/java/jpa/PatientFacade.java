/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
@Stateless
public class PatientFacade extends AbstractFacade<Patient> implements PatientFacadeLocal {

    @PersistenceContext(unitName = "Applabo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void remove(int id) {
     Query query = em.createNamedQuery("Patient.findByIdPatient").setParameter("idPatient", id);
     Patient p = (Patient) query.getSingleResult();
     getEntityManager().remove(p);
    }
    public PatientFacade() {
        super(Patient.class);
    }
    
}
