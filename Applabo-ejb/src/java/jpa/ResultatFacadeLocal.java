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
public interface ResultatFacadeLocal {

    void create(Resultat resultat);

    void edit(Resultat resultat);

    void remove(Resultat resultat);
    
    void remove(int id);
    
    void removerslt(int id);

    Resultat find(Object id);

    List<Resultat> findAll();

    List<Resultat> findRange(int[] range);

    int count();
    
}
