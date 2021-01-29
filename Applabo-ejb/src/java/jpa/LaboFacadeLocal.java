/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface LaboFacadeLocal {

    void create(Labo labo);

    void edit(Labo labo);

    void remove(Labo labo);
    List<Labo> Connexion(String login,String mdp);

    Labo find(Object id);

    List<Labo> findAll();

    List<Labo> findRange(int[] range);

    int count();
    
}
