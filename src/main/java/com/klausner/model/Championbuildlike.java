/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DesenSoftware
 */
@Entity
@Table(name = "championbuildlike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championbuildlike.findAll", query = "SELECT c FROM Championbuildlike c"),
    @NamedQuery(name = "Championbuildlike.findByIdBuild", query = "SELECT c FROM Championbuildlike c WHERE c.championbuildlikePK.idBuild = :idBuild"),
    @NamedQuery(name = "Championbuildlike.findByIdUsuario", query = "SELECT c FROM Championbuildlike c WHERE c.championbuildlikePK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Championbuildlike.findByGostou", query = "SELECT c FROM Championbuildlike c WHERE c.gostou = :gostou")})
public class Championbuildlike implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChampionbuildlikePK championbuildlikePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gostou")
    private int gostou;
    @JoinColumn(name = "id_build", referencedColumnName = "id_build", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Championbuild championbuild;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Championbuildlike() {
    }

    public Championbuildlike(ChampionbuildlikePK championbuildlikePK) {
        this.championbuildlikePK = championbuildlikePK;
    }

    public Championbuildlike(ChampionbuildlikePK championbuildlikePK, int gostou) {
        this.championbuildlikePK = championbuildlikePK;
        this.gostou = gostou;
    }

    public Championbuildlike(int idBuild, int idUsuario) {
        this.championbuildlikePK = new ChampionbuildlikePK(idBuild, idUsuario);
    }

    public ChampionbuildlikePK getChampionbuildlikePK() {
        return championbuildlikePK;
    }

    public void setChampionbuildlikePK(ChampionbuildlikePK championbuildlikePK) {
        this.championbuildlikePK = championbuildlikePK;
    }

    public int getGostou() {
        return gostou;
    }

    public void setGostou(int gostou) {
        this.gostou = gostou;
    }

    public Championbuild getChampionbuild() {
        return championbuild;
    }

    public void setChampionbuild(Championbuild championbuild) {
        this.championbuild = championbuild;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (championbuildlikePK != null ? championbuildlikePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championbuildlike)) {
            return false;
        }
        Championbuildlike other = (Championbuildlike) object;
        if ((this.championbuildlikePK == null && other.championbuildlikePK != null) || (this.championbuildlikePK != null && !this.championbuildlikePK.equals(other.championbuildlikePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championbuildlike[ championbuildlikePK=" + championbuildlikePK + " ]";
    }
    
}
