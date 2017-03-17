/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Utente;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless //il ciclio di vita non lo decidiamo noi, lo decide payara. Crea un pool
public class UtenteManager {

    @PersistenceContext
    public EntityManager em;

    public Utente save(Utente tosave) {
        return em.merge(tosave);
    }

    public List<Utente> findAllUsr() {
        return em.createNamedQuery(Utente.FIND_ALL).getResultList();
    }

    public Utente findById(Long id) {
        return em.find(Utente.class, id);
    }

    public Utente findByUser(String usr, String psw) {
        Utente result = null;
        //Optional<Utente> result= new Optional<>();
        try {
            result = em.createNamedQuery(Utente.FIND_BY_USER_PWD, Utente.class)
                    .setParameter("usr", usr).setParameter("psw", psw).getSingleResult();
        } catch (NoResultException ex) { // errore ingnorato dato che non fa niente
        }
        return result;
    }

    public void remove(Utente u) {
        Utente find = em.find(Utente.class, u.getId());
        em.remove(find);
    }

    public void delete(Long id) {
        Utente u = em.find(Utente.class, id);
        em.remove(u);
    }

}
