package com.klausner.model;

import com.klausner.model.Buildstage;
import com.klausner.model.Championbuildlike;
import com.klausner.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T11:52:40")
@StaticMetamodel(Championbuild.class)
public class Championbuild_ { 

    public static volatile CollectionAttribute<Championbuild, Buildstage> buildstageCollection;
    public static volatile SingularAttribute<Championbuild, Usuario> idUsuario;
    public static volatile SingularAttribute<Championbuild, Integer> idBuild;
    public static volatile SingularAttribute<Championbuild, Integer> idChampion;
    public static volatile CollectionAttribute<Championbuild, Championbuildlike> championbuildlikeCollection;

}