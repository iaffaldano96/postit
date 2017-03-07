package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */

                        // path dei servizi 
@ApplicationPath("resources") //tutti i servizi REST iniziano con questo path =>resources. Altri mettono api
public class JAXRSConfiguration extends Application {

}
