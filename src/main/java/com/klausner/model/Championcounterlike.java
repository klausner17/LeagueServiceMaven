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
@Table(name = "championcounterdlike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championcounterdlike.findAll", query = "SELECT c FROM Championcounterdlike c"),
    @NamedQuery(name = "Championcounterdlike.findByIdCounter", query = "SELECT c FROM Championcounterdlike c WHERE c.championcounterdlikePK.idCounter = :idCounter"),
    @NamedQuery(name = "Championcounterdlike.findByIdUsuario", query = "SELECT c FROM Championcounterdlike c WHERE c.championcounterdlikePK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Championcounterdlike.findByGostou", query = "SELECT c FROM Championcounterdlike c WHERE c.gostou = :gostou")})
public class Championcounterlike implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChampioncounterlikePK championcounterdlikePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gostou")
    private int gostou;
    @JoinColumn(name = "id_counter", referencedColumnName = "id_counter", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Championcounter championcounter;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Championcounterlike() {
    }

    public Championcounterlike(ChampioncounterlikePK championcounterdlikePK) {
        this.championcounterdlikePK = championcounterdlikePK;
    }

    public Championcounterlike(ChampioncounterlikePK championcounterdlikePK, int gostou) {
        this.championcounterdlikePK = championcounterdlikePK;
        this.gostou = gostou;
    }

    public Championcounterlike(int idCounter, int idUsuario) {
        this.championcounterdlikePK = new ChampioncounterlikePK(idCounter, idUsuario);
    }

    public ChampioncounterlikePK getChampioncounterdlikePK() {
        return championcounterdlikePK;
    }

    public void setChampioncounterdlikePK(ChampioncounterlikePK championcounterdlikePK) {
        this.championcounterdlikePK = championcounterdlikePK;
    }

    public int getGostou() {
        return gostou;
    }

    public void setGostou(int gostou) {
        this.gostou = gostou;
    }

    public Championcounter getChampioncounter() {
        return championcounter;
    }

    public void setChampioncounter(Championcounter championcounter) {
        this.championcounter = championcounter;
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
        hash += (championcounterdlikePK != null ? championcounterdlikePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championcounterlike)) {
            return false;
        }
        Championcounterlike other = (Championcounterlike) object;
        if ((this.championcounterdlikePK == null && other.championcounterdlikePK != null) || (this.championcounterdlikePK != null && !this.championcounterdlikePK.equals(other.championcounterdlikePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championcounterdlike[ championcounterdlikePK=" + championcounterdlikePK + " ]";
    }
    
}
