/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "labo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Labo.findAll", query = "SELECT l FROM Labo l")
    , @NamedQuery(name = "Labo.findByIdLabo", query = "SELECT l FROM Labo l WHERE l.idLabo = :idLabo")
    , @NamedQuery(name = "Labo.findByNom", query = "SELECT l FROM Labo l WHERE l.nom = :nom")
    , @NamedQuery(name = "Labo.findByLogin", query = "SELECT l FROM Labo l WHERE l.login = :login")
    , @NamedQuery(name = "Labo.findByMdp", query = "SELECT l FROM Labo l WHERE l.mdp = :mdp")
    , @NamedQuery(name = "Labo.findByEmail", query = "SELECT l FROM Labo l WHERE l.email = :email")
    , @NamedQuery(name = "Labo.findByIdRegion", query = "SELECT l FROM Labo l WHERE l.idRegion = :idRegion")})
public class Labo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_labo")
    private Integer idLabo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mdp")
    private String mdp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_region")
    private int idRegion;

    public Labo() {
    }

    public Labo(Integer idLabo) {
        this.idLabo = idLabo;
    }

    public Labo(Integer idLabo, String nom, String login, String mdp, String email, int idRegion) {
        this.idLabo = idLabo;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.idRegion = idRegion;
    }

    public Integer getIdLabo() {
        return idLabo;
    }

    public void setIdLabo(Integer idLabo) {
        this.idLabo = idLabo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLabo != null ? idLabo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labo)) {
            return false;
        }
        Labo other = (Labo) object;
        if ((this.idLabo == null && other.idLabo != null) || (this.idLabo != null && !this.idLabo.equals(other.idLabo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Labo[ idLabo=" + idLabo + " ]";
    }
    
}
