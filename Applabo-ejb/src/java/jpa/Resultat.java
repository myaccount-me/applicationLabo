/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "resultat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultat.findAll", query = "SELECT r FROM Resultat r")
    , @NamedQuery(name = "Resultat.findByIdResultat", query = "SELECT r FROM Resultat r WHERE r.idResultat = :idResultat")
    , @NamedQuery(name = "Resultat.findByIdLabo", query = "SELECT r FROM Resultat r WHERE r.idLabo = :idLabo")
    , @NamedQuery(name = "Resultat.findByIdPatient", query = "SELECT r FROM Resultat r WHERE r.idPatient = :idPatient")
    , @NamedQuery(name = "Resultat.findByDate", query = "SELECT r FROM Resultat r WHERE r.date = :date")
    , @NamedQuery(name = "Resultat.findByEtat", query = "SELECT r FROM Resultat r WHERE r.etat = :etat")})
public class Resultat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resultat")
    private Integer idResultat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_labo")
    private int idLabo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_patient")
    private int idPatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "etat")
    private String etat;

    public Resultat() {
    }

    public Resultat(Integer idResultat) {
        this.idResultat = idResultat;
    }

    public Resultat(Integer idResultat, int idLabo, int idPatient, Date date, String etat) {
        this.idResultat = idResultat;
        this.idLabo = idLabo;
        this.idPatient = idPatient;
        this.date = date;
        this.etat = etat;
    }
        public Resultat( int idLabo, int idPatient, Date date, String etat) {
        this.idLabo = idLabo;
        this.idPatient = idPatient;
        this.date = date;
        this.etat = etat;
    }

    public Integer getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(Integer idResultat) {
        this.idResultat = idResultat;
    }

    public int getIdLabo() {
        return idLabo;
    }

    public void setIdLabo(int idLabo) {
        this.idLabo = idLabo;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultat != null ? idResultat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultat)) {
            return false;
        }
        Resultat other = (Resultat) object;
        if ((this.idResultat == null && other.idResultat != null) || (this.idResultat != null && !this.idResultat.equals(other.idResultat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Resultat[ idResultat=" + idResultat + " ]";
    }
    
}
