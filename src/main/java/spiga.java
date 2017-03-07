/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */
public class spiga {    
    /*    
        Web Services ==> Soap/rest       
        REST (2000)==> Representational Staste Transfer
            su Java implementata con Jax.rs
            in xml /Jason/html
            Una chiamata al metodo è una risorsa. Qualsiasi cosa trasferibile al server
            
            Usare solo quello che ci offre HTTP, niente di più
    
            Si mappano le 4 oper. principali
            Operazioni Crude:
                    -GET => recupera una rapp dell'articolo desiderato ==> per scaricare una risorsa
                    -POST => crea un nuonvo articolo ==>crea una risorsa
                    -PUT =>modifica  ==>cambio di stato
                    -DELETE => cancellazione risorsa            
    
         -Architettura basata su client/server
         - Stateless. Ogni ciclio di client/server deve rapp
            un'interazione completa del client con il server. Così non si necessita di mantenere info sulla sessione utente
         - Uniformemente accessibile. Ogni risorsa deve avere un indi. univoco.
    
         È emerso come design model predominante nelle web application
    
        Ha 4 principi.
    
         @Path("hello") ==> devi annotare le classi con il loro path, altrimento non è richiamabile tramite http
                @GET=> per renderlo accessibile
    
                curl -i -X GET http://localhost:8080/postit/resources/hello ==> da console
                 curl -i -X POST -d 'usr=mario&psw=mario&email=mario@hotmail.it' http://localhost:8080/postit/resources/utenti
                        ==>inserisce utente
                   curl -i -X GET http://localhost:8080/postit/resources/utenti/3 ==> elimina utente
                curl -i -X POST -H 'utente_id:1' -d 'titolo=ciao&contenuto=comeva' ==>crea messagio
                              --) -H 'utente_id:1' => perché gli passi un HeaderParam("utente_id") => cioè già esistenti
    
    - Devono essere accessibili tramite URI
          

    
    */
    
    
}
