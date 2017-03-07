/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name=Utente.FIND_ALL,
            query = "SELECT e from Utente e order by e.usr"),
    @NamedQuery(name=Utente.FIND_BY_USER_PWD,
            query = "SELECT e from Utente e WHERE e.usr= :usr and e.psw= :psw")    
})
@XmlRootElement //viene convertita automaticamente in xml
@Entity
@Table(name = "utente")
public class Utente implements Serializable {
    
    // QUETSO È JPA 
    
    //@Stateless crea classe speciale javabean
    
    //rendiamo accessibile tutto tramite richiesta http-url
    
    //annotazioni GET & POST
        //sfruttano i metodi dell'http per identificare quello che vogliamo
    
    //perché sono costanti
    public static final String FIND_ALL="Utente.findall";
    public static final String FIND_BY_USER_PWD="Utente.findByUserPsw";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String usr;

    //@XmlTransient 
    @Column(nullable = false)
    private String psw;

    private String email;

    public Utente() {
    }
        
    public Utente(String usr, String psw, String email) {
        this.usr = usr;
        this.psw = psw;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", usr=" + usr + ", psw=" + psw + ", email=" + email + '}';
    }    
        
}
