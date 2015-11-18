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
@Table(name = "championcommentlike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championcommentlike.findAll", query = "SELECT c FROM Championcommentlike c"),
    @NamedQuery(name = "Championcommentlike.findByIdComment", query = "SELECT c FROM Championcommentlike c WHERE c.championcommentlikePK.idComment = :idComment"),
    @NamedQuery(name = "Championcommentlike.findByIdUsuario", query = "SELECT c FROM Championcommentlike c WHERE c.championcommentlikePK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Championcommentlike.findByGostou", query = "SELECT c FROM Championcommentlike c WHERE c.gostou = :gostou")})
public class Championcommentlike implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChampioncommentlikePK championcommentlikePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gostou")
    private int gostou;
    @JoinColumn(name = "id_comment", referencedColumnName = "id_comment", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Championcomments championcomments;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Championcommentlike() {
    }

    public Championcommentlike(ChampioncommentlikePK championcommentlikePK) {
        this.championcommentlikePK = championcommentlikePK;
    }

    public Championcommentlike(ChampioncommentlikePK championcommentlikePK, int gostou) {
        this.championcommentlikePK = championcommentlikePK;
        this.gostou = gostou;
    }

    public Championcommentlike(int idComment, int idUsuario) {
        this.championcommentlikePK = new ChampioncommentlikePK(idComment, idUsuario);
    }

    public ChampioncommentlikePK getChampioncommentlikePK() {
        return championcommentlikePK;
    }

    public void setChampioncommentlikePK(ChampioncommentlikePK championcommentlikePK) {
        this.championcommentlikePK = championcommentlikePK;
    }

    public int getGostou() {
        return gostou;
    }

    public void setGostou(int gostou) {
        this.gostou = gostou;
    }

    public Championcomments getChampioncomments() {
        return championcomments;
    }

    public void setChampioncomments(Championcomments championcomments) {
        this.championcomments = championcomments;
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
        hash += (championcommentlikePK != null ? championcommentlikePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championcommentlike)) {
            return false;
        }
        Championcommentlike other = (Championcommentlike) object;
        if ((this.championcommentlikePK == null && other.championcommentlikePK != null) || (this.championcommentlikePK != null && !this.championcommentlikePK.equals(other.championcommentlikePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championcommentlike[ championcommentlikePK=" + championcommentlikePK + " ]";
    }
    
}
