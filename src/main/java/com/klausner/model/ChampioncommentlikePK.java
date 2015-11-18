/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DesenSoftware
 */
@Embeddable
public class ChampioncommentlikePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comment")
    private int idComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ChampioncommentlikePK() {
    }

    public ChampioncommentlikePK(int idComment, int idUsuario) {
        this.idComment = idComment;
        this.idUsuario = idUsuario;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idComment;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChampioncommentlikePK)) {
            return false;
        }
        ChampioncommentlikePK other = (ChampioncommentlikePK) object;
        if (this.idComment != other.idComment) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.ChampioncommentlikePK[ idComment=" + idComment + ", idUsuario=" + idUsuario + " ]";
    }
    
}
