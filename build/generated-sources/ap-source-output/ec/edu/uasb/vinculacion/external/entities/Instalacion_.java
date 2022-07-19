package ec.edu.uasb.vinculacion.external.entities;

import ec.edu.uasb.vinculacion.external.entities.InsAula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Instalacion.class)
public class Instalacion_ { 

    public static volatile SingularAttribute<Instalacion, Long> edifCodigo;
    public static volatile SingularAttribute<Instalacion, String> edifDesc;
    public static volatile CollectionAttribute<Instalacion, InsAula> inasAulaCollection;

}