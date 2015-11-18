package com.klausner.model;

import com.klausner.model.Championcounter;
import com.klausner.model.ChampioncounterdlikePK;
import com.klausner.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T11:52:40")
@StaticMetamodel(Championcounterdlike.class)
public class Championcounterdlike_ { 

    public static volatile SingularAttribute<Championcounterdlike, ChampioncounterdlikePK> championcounterdlikePK;
    public static volatile SingularAttribute<Championcounterdlike, Integer> gostou;
    public static volatile SingularAttribute<Championcounterdlike, Usuario> usuario;
    public static volatile SingularAttribute<Championcounterdlike, Championcounter> championcounter;

}