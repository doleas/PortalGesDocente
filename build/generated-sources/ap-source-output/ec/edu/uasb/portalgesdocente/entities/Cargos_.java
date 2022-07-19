package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.Autoridad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Cargos.class)
public class Cargos_ { 

    public static volatile SingularAttribute<Cargos, String> carNombre;
    public static volatile CollectionAttribute<Cargos, Autoridad> autoridadCollection;
    public static volatile SingularAttribute<Cargos, Long> carCodigo;

}