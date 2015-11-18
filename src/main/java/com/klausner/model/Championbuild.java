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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "championbuild")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championbuild.findAll", query = "SELECT c FROM Championbuild c"),
    @NamedQuery(name = "Championbuild.findByIdBuild", query = "SELECT c FROM Championbuild c WHERE c.idBuild = :idBuild"),
    @NamedQuery(name = "Championbuild.findByIdChampion", query = "SELECT c FROM Championbuild c WHERE c.idChampion = :idChampion")})
public class Championbuild implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_build")
    private Integer idBuild;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_champion")
    private int idChampion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "championbuild")
    private Collection<Championbuildlike> championbuildlikeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBuild")
    private Collection<Buildstage> buildstageCollection;

    public Championbuild() {
    }

    public Championbuild(Integer idBuild) {
        this.idBuild = idBuild;
    }

    public Championbuild(Integer idBuild, int idChampion) {
        this.idBuild = idBuild;
        this.idChampion = idChampion;
    }

    public Integer getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(Integer idBuild) {
        this.idBuild = idBuild;
    }

    public int getIdChampion() {
        return idChampion;
    }

    public void setIdChampion(int idChampion) {
        this.idChampion = idChampion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Championbuildlike> getChampionbuildlikeCollection() {
        return championbuildlikeCollection;
    }

    public void setChampionbuildlikeCollection(Collection<Championbuildlike> championbuildlikeCollection) {
        this.championbuildlikeCollection = championbuildlikeCollection;
    }

    @XmlTransient
    public Collection<Buildstage> getBuildstageCollection() {
        return buildstageCollection;
    }

    public void setBuildstageCollection(Collection<Buildstage> buildstageCollection) {
        this.buildstageCollection = buildstageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuild != null ? idBuild.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championbuild)) {
            return false;
        }
        Championbuild other = (Championbuild) object;
        if ((this.idBuild == null && other.idBuild != null) || (this.idBuild != null && !this.idBuild.equals(other.idBuild))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championbuild[ idBuild=" + idBuild + " ]";
    }
    
}
