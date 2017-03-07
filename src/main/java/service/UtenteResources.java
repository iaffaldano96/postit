/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */

@Stateless
@Path("utenti")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class UtenteResources {
   
    @Inject //prende da db e mette in UtenteManager
    UtenteManager utenteManager;

    public UtenteManager getUtenteManager() {
        return utenteManager;
    }
        
    @GET
    public List<Utente> all(){
        return utenteManager.findAllUsr();
    }
    
    @GET
    @Path("{id}") //quello che c'è dopo utenti nel path. Posso specificare anche più paramentri
    public Utente find(@PathParam("id") Long id){
        return utenteManager.findById(id);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        //utenteManager.delete(id); due metodi
        utenteManager.remove(utenteManager.findById(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Utente u){
        utenteManager.save(u);
    }
    
    @POST           // i parametri ci arrivano come form con method=POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public void create(@FormParam("usr") String usr,
            @FormParam("psw") String psw,
            @FormParam("email") String email){
        
        Utente u= new Utente(usr, psw, email);
        utenteManager.save(u);
    }
    
}
