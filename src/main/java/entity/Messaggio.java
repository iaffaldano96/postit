/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name=Messaggio.FIND_ALL,
            query = "SELECT m from Messaggio m order by m.id"),
    @NamedQuery(name=Messaggio.FIND_BY_ID,
            query = "SELECT m from Messaggio m WHERE m.id= :id"),
    @NamedQuery(name=Messaggio.FIND_BY_USR,
            query = "SELECT m from Messaggio m WHERE m.utente= :usr")      
})
@Entity
@Table(name="messaggio")
public class Messaggio implements Serializable{
    
    public static final String FIND_ALL="Messaggio.findall";
    public static final String FIND_BY_ID="Messaggio.findByid";
    public static final String FIND_BY_USR="Messaggio.findByUsr";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    
    @Column(nullable = false)
    private String titolo;
        
    private String contenuto;
    
    @Column(name="DATA_CREAZIONE")
    @Temporal(TemporalType.TIMESTAMP) //per dire che è un campo data
    private Date dataCreazione= new Date();
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false) // il JOIN quando fanno parte della relazione
    private Utente utente;

    public Messaggio() {
    }

    public Messaggio(String titolo, String contenuto, Utente utente) {       
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.utente = utente;        
    }    
    
    public Long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Utente getUtente() {
        return utente;
    }    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Messaggio other = (Messaggio) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Messagio{" + "id=" + id + ", titolo=" + titolo + ", contenuto=" + contenuto + ", dataCreazione=" + dataCreazione + ", utente=" + utente + '}';
    }
    
    
    
}
