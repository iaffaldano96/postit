/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author tss
 */

        // questa classe si mette in mezzo ogni volta che faccio una richiesta, prima di rispoondere inviando il metodo opportuno    

        //  Su tutte che le classi che hanno annotazione la classe Provider

@TokenNeeded
@Provider
public class TokenNeededFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("TokenNeededFilter in action...");               
        
        List<String> id_token =requestContext.getHeaders().get("id_token");
        if(id_token==null || id_token.isEmpty()){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
    
}
