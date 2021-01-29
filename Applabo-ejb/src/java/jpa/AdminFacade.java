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
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {

    @PersistenceContext(unitName = "Applabo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public List<Admin> Connexion(String login,String mdp) {
        Query query = em.createQuery("SELECT a FROM Admin a WHERE a.login = '"+login+"' and a.mdp ='"+mdp+"'");
        List<Admin> results = query.getResultList();
        return results;
    }
    public AdminFacade() {
        super(Admin.class);
    }
    
}
