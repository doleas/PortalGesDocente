package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.Cargos;
import ec.edu.uasb.portalgesdocente.entities.Parametros;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Autoridad.class)
public class Autoridad_ { 

    public static volatile SingularAttribute<Autoridad, String> autNombres;
    public static volatile SingularAttribute<Autoridad, Long> autCodPersonal;
    public static volatile SingularAttribute<Autoridad, Cargos> cargos;
    public static volatile SingularAttribute<Autoridad, String> autApelativo;
    public static volatile SingularAttribute<Autoridad, Long> autCodigo;
    public static volatile CollectionAttribute<Autoridad, Parametros> parametrosCollection;

}