package com.klausner.model;

import com.klausner.model.Championcommentlike;
import com.klausner.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T11:52:40")
@StaticMetamodel(Championcomments.class)
public class Championcomments_ { 

    public static volatile SingularAttribute<Championcomments, Integer> idComment;
    public static volatile SingularAttribute<Championcomments, Usuario> idUsuario;
    public static volatile SingularAttribute<Championcomments, Integer> idChampion;
    public static volatile SingularAttribute<Championcomments, String> comentario;
    public static volatile CollectionAttribute<Championcomments, Championcommentlike> championcommentlikeCollection;

}