/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Messaggio;
import entity.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
public class MessaggioManager {
    
    @PersistenceContext
    public  EntityManager em;
    
    public Messaggio save(Messaggio tosave){
        return em.merge(tosave);
    }
    
    public List<Messaggio> findAll(){
        return em.createNamedQuery(Messaggio.FIND_ALL).getResultList();
    }
    
    public Messaggio findById(Long id){
        return  em.createNamedQuery(Messaggio.FIND_BY_ID,Messaggio.class).setParameter("id", id).getSingleResult();        
    }
    
    public List<Messaggio> findByUser(Utente u){
        return em.createNamedQuery(Messaggio.FIND_BY_USR).setParameter("usr", u).getResultList();
    }
    
    public List<Messaggio> findByUser(Long id){
        return findByUser(em.find(Utente.class, id));
    }
    
    public void delete(Long id){
        Messaggio u=em.find(Messaggio.class, id);
        em.remove(u);
    }
    
}
