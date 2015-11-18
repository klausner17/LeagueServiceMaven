package com.klausner.model;

import com.klausner.model.ChampioncommentlikePK;
import com.klausner.model.Championcomments;
import com.klausner.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T11:52:40")
@StaticMetamodel(Championcommentlike.class)
public class Championcommentlike_ { 

    public static volatile SingularAttribute<Championcommentlike, Championcomments> championcomments;
    public static volatile SingularAttribute<Championcommentlike, Integer> gostou;
    public static volatile SingularAttribute<Championcommentlike, Usuario> usuario;
    public static volatile SingularAttribute<Championcommentlike, ChampioncommentlikePK> championcommentlikePK;

}