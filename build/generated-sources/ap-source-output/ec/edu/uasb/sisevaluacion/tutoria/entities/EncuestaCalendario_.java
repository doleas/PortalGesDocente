package ec.edu.uasb.sisevaluacion.tutoria.entities;

import ec.edu.uasb.sisevaluacion.tutoria.entities.EncuestaCalendarioPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(EncuestaCalendario.class)
public class EncuestaCalendario_ { 

    public static volatile SingularAttribute<EncuestaCalendario, Character> tipoEncuesta;
    public static volatile SingularAttribute<EncuestaCalendario, Date> fechaFin;
    public static volatile SingularAttribute<EncuestaCalendario, Date> fFinCalificacion;
    public static volatile SingularAttribute<EncuestaCalendario, Date> fInicioCalificacion;
    public static volatile SingularAttribute<EncuestaCalendario, Date> fechaInicio;
    public static volatile SingularAttribute<EncuestaCalendario, Character> estadoEncuesta;
    public static volatile SingularAttribute<EncuestaCalendario, EncuestaCalendarioPK> encuestaCalendarioPK;

}