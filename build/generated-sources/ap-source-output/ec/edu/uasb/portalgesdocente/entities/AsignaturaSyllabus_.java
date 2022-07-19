package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.AsignaturaSyllabusPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(AsignaturaSyllabus.class)
public class AsignaturaSyllabus_ { 

    public static volatile SingularAttribute<AsignaturaSyllabus, Long> anio;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> responsableSyllabus;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> nombreParalelo;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> emailArea;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> apellidoProfesor;
    public static volatile SingularAttribute<AsignaturaSyllabus, Long> existe;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> nombreProfesor;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> nombreNivel;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> identifMateria;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> programa;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> observacionCoordinador;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> estadoEnvio;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> estadoSyllabus;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> area;
    public static volatile SingularAttribute<AsignaturaSyllabus, Long> aprobadoPor;
    public static volatile SingularAttribute<AsignaturaSyllabus, BigDecimal> nCreditos;
    public static volatile SingularAttribute<AsignaturaSyllabus, Long> horasMateriaDictar;
    public static volatile SingularAttribute<AsignaturaSyllabus, Long> ciclo;
    public static volatile SingularAttribute<AsignaturaSyllabus, String> nombreMateria;
    public static volatile SingularAttribute<AsignaturaSyllabus, Long> codigoCoordinador;
    public static volatile SingularAttribute<AsignaturaSyllabus, AsignaturaSyllabusPK> asignaturaSyllabusPK;

}