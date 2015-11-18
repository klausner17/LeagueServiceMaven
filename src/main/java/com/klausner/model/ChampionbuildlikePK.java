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
public class ChampionbuildlikePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_build")
    private int idBuild;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ChampionbuildlikePK() {
    }

    public ChampionbuildlikePK(int idBuild, int idUsuario) {
        this.idBuild = idBuild;
        this.idUsuario = idUsuario;
    }

    public int getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(int idBuild) {
        this.idBuild = idBuild;
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
        hash += (int) idBuild;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChampionbuildlikePK)) {
            return false;
        }
        ChampionbuildlikePK other = (ChampionbuildlikePK) object;
        if (this.idBuild != other.idBuild) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.ChampionbuildlikePK[ idBuild=" + idBuild + ", idUsuario=" + idUsuario + " ]";
    }
    
}
