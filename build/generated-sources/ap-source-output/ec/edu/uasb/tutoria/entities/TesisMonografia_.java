package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.TesisMonografiaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(TesisMonografia.class)
public class TesisMonografia_ { 

    public static volatile SingularAttribute<TesisMonografia, String> nombreEstudiante;
    public static volatile SingularAttribute<TesisMonografia, String> tiptrabajo;
    public static volatile SingularAttribute<TesisMonografia, Integer> numHoras;
    public static volatile SingularAttribute<TesisMonografia, Date> fecha;
    public static volatile SingularAttribute<TesisMonografia, String> cedPasEstudiante;
    public static volatile SingularAttribute<TesisMonografia, Date> fechaFin;
    public static volatile SingularAttribute<TesisMonografia, Date> fechaIni;
    public static volatile SingularAttribute<TesisMonografia, String> nombresProfesor;
    public static volatile SingularAttribute<TesisMonografia, String> tema;
    public static volatile SingularAttribute<TesisMonografia, Integer> numConsultas;
    public static volatile SingularAttribute<TesisMonografia, Long> anioEstudiante;
    public static volatile SingularAttribute<TesisMonografia, String> cedPasProfesor;
    public static volatile SingularAttribute<TesisMonografia, String> estadoTesMon;
    public static volatile SingularAttribute<TesisMonografia, String> tipHoras;
    public static volatile SingularAttribute<TesisMonografia, String> programa;
    public static volatile SingularAttribute<TesisMonografia, String> sistema;
    public static volatile SingularAttribute<TesisMonografia, String> tipprograma;
    public static volatile SingularAttribute<TesisMonografia, Integer> anioInicio;
    public static volatile SingularAttribute<TesisMonografia, String> roldocen;
    public static volatile SingularAttribute<TesisMonografia, TesisMonografiaPK> tesisMonografiaPK;
    public static volatile SingularAttribute<TesisMonografia, String> estadoProceso;
    public static volatile SingularAttribute<TesisMonografia, Integer> anioFin;

}