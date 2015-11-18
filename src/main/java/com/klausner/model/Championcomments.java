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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DesenSoftware
 */
@Entity
@Table(name = "championcomments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championcomments.findAll", query = "SELECT c FROM Championcomments c"),
    @NamedQuery(name = "Championcomments.findByIdComment", query = "SELECT c FROM Championcomments c WHERE c.idComment = :idComment"),
    @NamedQuery(name = "Championcomments.findByComentario", query = "SELECT c FROM Championcomments c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "Championcomments.findByChampion", query = "SELECT c FROM Championcomments c WHERE c.idChampion = :idChampion")})
public class Championcomments implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_champion")
    private int idChampion;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comment")
    private Integer idComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "championcomments")
    private Collection<Championcommentlike> championcommentlikeCollection;

    public Championcomments() {
    }

    public Championcomments(Integer idComment) {
        this.idComment = idComment;
    }

    public Championcomments(Integer idComment, String comentario) {
        this.idComment = idComment;
        this.comentario = comentario;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Championcommentlike> getChampioncommentlikeCollection() {
        return championcommentlikeCollection;
    }

    public void setChampioncommentlikeCollection(Collection<Championcommentlike> championcommentlikeCollection) {
        this.championcommentlikeCollection = championcommentlikeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComment != null ? idComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Championcomments)) {
            return false;
        }
        Championcomments other = (Championcomments) object;
        if ((this.idComment == null && other.idComment != null) || (this.idComment != null && !this.idComment.equals(other.idComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Championcomments[ idComment=" + idComment + " ]";
    }

    public int getIdChampion() {
        return idChampion;
    }

    public void setIdChampion(int idChampion) {
        this.idChampion = idChampion;
    }
    
}
