package com.klausner.model;

import com.klausner.model.Championbuild;
import com.klausner.model.Championbuildlike;
import com.klausner.model.Championcommentlike;
import com.klausner.model.Championcomments;
import com.klausner.model.Championcounterdlike;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T11:52:40")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Championcounterdlike> championcounterdlikeCollection;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> login;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Date> dataNasc;
    public static volatile CollectionAttribute<Usuario, Championcomments> championcommentsCollection;
    public static volatile SingularAttribute<Usuario, Boolean> validado;
    public static volatile SingularAttribute<Usuario, String> validador;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile CollectionAttribute<Usuario, Championcommentlike> championcommentlikeCollection;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Championbuild> championbuildCollection;
    public static volatile CollectionAttribute<Usuario, Championbuildlike> championbuildlikeCollection;

}