/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
@Stateless
public class ResultatFacade extends AbstractFacade<Resultat> implements ResultatFacadeLocal {

    @PersistenceContext(unitName = "Applabo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void remove(int id) {
     Query query = em.createNamedQuery("Resultat.findByIdResultat")
             .setParameter("idResultat", id);
     Resultat r = (Resultat) query.getSingleResult();
     getEntityManager().remove(r);
    }
    @Override
    public void removerslt(int id) {
       Query query = em.createNamedQuery("Resultat.findByIdPatient").setParameter("idPatient", id);
    List<Resultat> r = (List<Resultat>) query.getResultList();
    for (Resultat rslt : r){
     getEntityManager().remove(rslt);
    }
    }
    public ResultatFacade() {
        super(Resultat.class);
    }
    
}
