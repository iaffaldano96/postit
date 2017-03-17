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
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * curl -i -X -H "Content-Type:application/json" -d '{"usr":"mario","psw":"secret"}' http://localhost:8080/postit/resources/utenti/login
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
    @TokenNeeded
    public List<Utente> all(){
        return utenteManager.findAllUsr();
    }
    
    @GET
    @Path("{id}") //quello che c'è dopo utenti nel path. Posso specificare anche più paramentri
    @TokenNeeded
    public Utente find(@PathParam("id") Long id){
        return utenteManager.findById(id);
    }
    
    @DELETE
    @Path("{id}")
    @TokenNeeded
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
    @Path("registrazione")
    public Response create(@FormParam("usr") String usr,
            @FormParam("psw") String psw,
            @FormParam("email") String email){
        
        if(usr.isEmpty() || psw.isEmpty() ||email.isEmpty()){
            return  Response.serverError().header("caused-by ", "nessun dato per effettuare la registrazione").build();
        }        
        
        Utente u= new Utente(usr, psw, email);
        utenteManager.save(u);
        System.out.println("Registrazione actived...");
        
        JsonObject json=Json.createObjectBuilder().add("id_token",usr).build();
        return Response.ok(json).build();
    }
    
    @POST
    @Path("login")
    public Response login(Utente u){
        if(u==null)
            return  Response.serverError().header("caused-by ", "nessun dato per effettuare il login").build();
        Utente finded=utenteManager.findByUser(u.getUsr(), u.getPsw());

        /*return finded==null ? Response.status(Response.Status.UNAUTHORIZED)
                .header("caused-by ", "login failed").build(): Response.ok().build();
        */        
        //così crei oggetto json
        
        if(finded==null)
            return Response.status(Response.Status.UNAUTHORIZED)
                .header("caused-by ", "login failed").build();
        // se login ha funzionato    
        JsonObject json=Json.createObjectBuilder().add("id_token",finded.getId()).build();
        return Response.ok(json).build(); //gli mando un json come ritorno
         
    }
    
}
