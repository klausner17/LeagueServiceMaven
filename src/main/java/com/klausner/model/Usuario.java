/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DesenSoftware
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByValidador", query = "SELECT u FROM Usuario u WHERE u.validador = :validador"),
    @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuario.findByDataNasc", query = "SELECT u FROM Usuario u WHERE u.dataNasc = :dataNasc"),
    @NamedQuery(name = "Usuario.findByValidado", query = "SELECT u FROM Usuario u WHERE u.validado = :validado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    //@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "validador")
    private String validador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "validado")
    private Boolean validado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Championbuild> championbuildCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Championcomments> championcommentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Championcounterlike> championcounterdlikeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Championbuildlike> championbuildlikeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Championcommentlike> championcommentlikeCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String login, String validador){
        this.login = login;
        this.senha = "none";
        this.nome = "none";
        this.email = "none";
        this.sexo = "n";
        this.dataNasc = java.sql.Date.valueOf("2000-01-01");
        this.validador = validador;
        this.validado = Boolean.FALSE;
    }
    
    public Usuario(Integer idUsuario, String login, String senha, String nome, String email, Date dataNasc, String validador, String sexo, boolean validado) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.validador = validador;
        this.validado = validado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha =  BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @XmlTransient
    public Collection<Championbuild> getChampionbuildCollection() {
        return championbuildCollection;
    }

    public void setChampionbuildCollection(Collection<Championbuild> championbuildCollection) {
        this.championbuildCollection = championbuildCollection;
    }

    @XmlTransient
    public Collection<Championcomments> getChampioncommentsCollection() {
        return championcommentsCollection;
    }

    public void setChampioncommentsCollection(Collection<Championcomments> championcommentsCollection) {
        this.championcommentsCollection = championcommentsCollection;
    }

    @XmlTransient
    public Collection<Championcounterlike> getChampioncounterdlikeCollection() {
        return championcounterdlikeCollection;
    }

    public void setChampioncounterdlikeCollection(Collection<Championcounterlike> championcounterdlikeCollection) {
        this.championcounterdlikeCollection = championcounterdlikeCollection;
    }

    @XmlTransient
    public Collection<Championbuildlike> getChampionbuildlikeCollection() {
        return championbuildlikeCollection;
    }

    public void setChampionbuildlikeCollection(Collection<Championbuildlike> championbuildlikeCollection) {
        this.championbuildlikeCollection = championbuildlikeCollection;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klausner.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
