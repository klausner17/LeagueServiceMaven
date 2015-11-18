/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DesenSoftware
 */
@Entity
@Table(name = "buildstage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buildstage.findAll", query = "SELECT b FROM Buildstage b"),
    @NamedQuery(name = "Buildstage.findByIdStage", query = "SELECT b FROM Buildstage b WHERE b.idStage = :idStage"),
    @NamedQuery(name = "Buildstage.findByDescricao", query = "SELECT b FROM Buildstage b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "Buildstage.findByItem0", query = "SELECT b FROM Buildstage b WHERE b.item0 = :item0"),
    @NamedQuery(name = "Buildstage.findByItem1", query = "SELECT b FROM Buildstage b WHERE b.item1 = :item1"),
    @NamedQuery(name = "Buildstage.findByItem2", query = "SELECT b FROM Buildstage b WHERE b.item2 = :item2"),
    @NamedQuery(name = "Buildstage.findByItem3", query = "SELECT b FROM Buildstage b WHERE b.item3 = :item3"),
    @NamedQuery(name = "Buildstage.findByItem4", query = "SELECT b FROM Buildstage b WHERE b.item4 = :item4"),
    @NamedQuery(name = "Buildstage.findByItem5", query = "SELECT b FROM Buildstage b WHERE b.item5 = :item5"),
    @NamedQuery(name = "Buildstage.findByItem6", query = "SELECT b FROM Buildstage b WHERE b.item6 = :item6")})
public class Buildstage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stage")
    private Integer idStage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "item0")
    private Integer item0;
    @Column(name = "item1")
    private Integer item1;
    @Column(name = "item2")
    private Integer item2;
    @Column(name = "item3")
    private Integer item3;
    @Column(name = "item4")
    private Integer item4;
    @Column(name = "item5")
    private Integer item5;
    @Column(name = "item6")
    private Integer item6;
    @JoinColumn(name = "id_build", referencedColumnName = "id_build")
    @ManyToOne(optional = false)
    private Championbuild idBuild;

    public Buildstage() {
    }

    public Buildstage(Integer idStage) {
        this.idStage = idStage;
    }

    public Buildstage(Integer idStage, String descricao) {
        this.idStage = idStage;
        this.descricao = descricao;
    }

    public Integer getIdStage() {
        return idStage;
    }

    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getItem0() {
        return item0;
    }

    public void setItem0(Integer item0) {
        this.item0 = item0;
    }

    public Integer getItem1() {
        return item1;
    }

    public void setItem1(Integer item1) {
        this.item1 = item1;
    }

    public Integer getItem2() {
        return item2;
    }

    public void setItem2(Integer item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return item3;
    }

    public void setItem3(Integer item3) {
        this.item3 = item3;
    }

    public Integer getItem4() {
        return item4;
    }

    public void setItem4(Integer item4) {
        this.item4 = item4;
    }

    public Integer getItem5() {
        return item5;
    }

    public void setItem5(Integer item5) {
        this.item5 = item5;
    }

    public Integer getItem6() {
        return item6;
    }

    public void setItem6(Integer item6) {
        this.item6 = item6;
    }

    public Championbuild getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(Championbuild idBuild) {
        this.idBuild = idBuild;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStage != null ? idStage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buildstage)) {
            return false;
        }
        Buildstage other = (Buildstage) object;
        if ((this.idStage == null && other.idStage != null) || (this.idStage != null && !this.idStage.equals(other.idStage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Buildstage[ idStage=" + idStage + " ]";
    }
    
}
