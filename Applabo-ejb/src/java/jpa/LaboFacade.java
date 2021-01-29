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
public class LaboFacade extends AbstractFacade<Labo> implements LaboFacadeLocal {

    @PersistenceContext(unitName = "Applabo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public List<Labo> Connexion(String login,String mdp) {
        Query query = em.createQuery("SELECT l FROM Labo l WHERE l.login = '"+login+"' and l.mdp ='"+mdp+"'");
        List<Labo> results = query.getResultList();
        return results;
    }
    public LaboFacade() {
        super(Labo.class);
    }
    
}
