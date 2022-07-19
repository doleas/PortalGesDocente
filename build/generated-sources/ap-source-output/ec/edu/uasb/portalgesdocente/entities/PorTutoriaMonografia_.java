package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(PorTutoriaMonografia.class)
public class PorTutoriaMonografia_ { 

    public static volatile SingularAttribute<PorTutoriaMonografia, Date> ttmFechaIniprog;
    public static volatile SingularAttribute<PorTutoriaMonografia, Long> ttmCodigo;
    public static volatile SingularAttribute<PorTutoriaMonografia, String> ttmTitulo;
    public static volatile SingularAttribute<PorTutoriaMonografia, Date> ttmFechaFinprog;
    public static volatile SingularAttribute<PorTutoriaMonografia, Long> aluCodigo;
    public static volatile SingularAttribute<PorTutoriaMonografia, ContratoDocente> contratoDocente;

}