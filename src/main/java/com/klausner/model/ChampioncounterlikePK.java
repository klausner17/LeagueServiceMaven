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
public class ChampioncounterlikePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_counter")
    private int idCounter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ChampioncounterlikePK() {
    }

    public ChampioncounterlikePK(int idCounter, int idUsuario) {
        this.idCounter = idCounter;
        this.idUsuario = idUsuario;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
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
        hash += (int) idCounter;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChampioncounterlikePK)) {
            return false;
        }
        ChampioncounterlikePK other = (ChampioncounterlikePK) object;
        if (this.idCounter != other.idCounter) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.ChampioncounterdlikePK[ idCounter=" + idCounter + ", idUsuario=" + idUsuario + " ]";
    }
    
}
