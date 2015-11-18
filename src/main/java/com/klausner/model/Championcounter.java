/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DesenSoftware
 */
@Entity
@Table(name = "championcounter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championcounter.findAll", query = "SELECT c FROM Championcounter c"),
    @NamedQuery(name = "Championcounter.findByIdCounter", query = "SELECT c FROM Championcounter c WHERE c.idCounter = :idCounter"),
    @NamedQuery(name = "Championcounter.findByIdChampion", query = "SELECT c FROM Championcounter c WHERE c.idChampion = :idChampion")})
public class Championcounter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_counter")
    private Integer idCounter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_champion")
    private int idChampion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "championcounter")
    private Collection<Championcounterlike> championcounterdlikeCollection;

    public Championcounter() {
    }

    public Championcounter(Integer idCounter) {
        this.idCounter = idCounter;
    }

    public Championcounter(Integer idCounter, int idChampion) {
        this.idCounter = idCounter;
        this.idChampion = idChampion;
    }

    public Integer getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(Integer idCounter) {
        this.idCounter = idCounter;
    }

    public int getIdChampion() {
        return idChampion;
    }

    public void setIdChampion(int idChampion) {
        this.idChampion = idChampion;
    }

    @XmlTransient
    public Collection<Championcounterlike> getChampioncounterdlikeCollection() {
        return championcounterdlikeCollection;
    }

    public void setChampioncounterdlikeCollection(Collection<Championcounterlike> championcounterdlikeCollection) {
        this.championcounterdlikeCollection = championcounterdlikeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCounter != null ? idCounter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championcounter)) {
            return false;
        }
        Championcounter other = (Championcounter) object;
        if ((this.idCounter == null && other.idCounter != null) || (this.idCounter != null && !this.idCounter.equals(other.idCounter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championcounter[ idCounter=" + idCounter + " ]";
    }
    
}
