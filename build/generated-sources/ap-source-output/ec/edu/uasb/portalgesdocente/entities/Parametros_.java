package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.Autoridad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Parametros.class)
public class Parametros_ { 

    public static volatile SingularAttribute<Parametros, Date> prmFechaModif;
    public static volatile SingularAttribute<Parametros, Short> prmCodigo;
    public static volatile SingularAttribute<Parametros, Long> prmUsuModif;
    public static volatile SingularAttribute<Parametros, Autoridad> autoridad;
    public static volatile SingularAttribute<Parametros, String> prmEtiquetaRector;

}