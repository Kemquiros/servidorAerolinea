/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clases.Vuelo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author t30r3m4
 */

@Stateless
public class VueloDao {
    @PersistenceContext(unitName = "Aerolinea_PU")
    private EntityManager em;
    
    public List<Vuelo> getVuelos1() {
        //Query q=em.createQuery("SELECT DISTINCT v FROM Profesor p,Login l WHERE l.nickname=:nick AND l.id=p.login.id").setParameter("nick", nick);
        //Profesor p=(Profesor)q.getSingleResult();
        Query q=em.createQuery("SELECT l FROM Vuelo l");
        return q.getResultList();
    }

    public List<Vuelo> getVuelos(String ciudad, String destino, String fechaIda, String fechaRegreso, int adultos, int ninos, int bebes) {
        Query q=em.createQuery("SELECT v FROM Vuelo v");
        return q.getResultList();
    }
}
