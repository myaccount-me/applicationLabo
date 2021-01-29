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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByIdPatient", query = "SELECT p FROM Patient p WHERE p.idPatient = :idPatient")
    , @NamedQuery(name = "Patient.findByNom", query = "SELECT p FROM Patient p WHERE p.nom = :nom")
    , @NamedQuery(name = "Patient.findByPrenom", query = "SELECT p FROM Patient p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Patient.findByDnaissance", query = "SELECT p FROM Patient p WHERE p.dnaissance = :dnaissance")
    , @NamedQuery(name = "Patient.findByTel", query = "SELECT p FROM Patient p WHERE p.tel = :tel")
    , @NamedQuery(name = "Patient.findByMail", query = "SELECT p FROM Patient p WHERE p.mail = :mail")
    , @NamedQuery(name = "Patient.findByIdRegion", query = "SELECT p FROM Patient p WHERE p.idRegion = :idRegion")
    , @NamedQuery(name = "Patient.findByCin", query = "SELECT p FROM Patient p WHERE p.cin = :cin")
    , @NamedQuery(name = "Patient.findBySexe", query = "SELECT p FROM Patient p WHERE p.sexe = :sexe")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_patient")
    private Integer idPatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnaissance")
    @Temporal(TemporalType.DATE)
    private Date dnaissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel")
    private int tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_region")
    private int idRegion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cin")
    private int cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "sexe")
    private String sexe;

    public Patient() {
    }

    public Patient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patient(Integer idPatient, String nom, String prenom, Date dnaissance, int tel, String mail, int idRegion, int cin, String sexe) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.dnaissance = dnaissance;
        this.tel = tel;
        this.mail = mail;
        this.idRegion = idRegion;
        this.cin = cin;
        this.sexe = sexe;
    }

    public Patient(String nom, String prenom,Date dnaissance, int tel, String email, int reg, int cin, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dnaissance = dnaissance;
        this.tel = tel;
        this.mail = email;
        this.idRegion = reg;
        this.cin = cin;
        this.sexe = sexe;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDnaissance() {
        return dnaissance;
    }

    public void setDnaissance(Date dnaissance) {
        this.dnaissance = dnaissance;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Patient[ idPatient=" + idPatient + " ]";
    }
    
}
