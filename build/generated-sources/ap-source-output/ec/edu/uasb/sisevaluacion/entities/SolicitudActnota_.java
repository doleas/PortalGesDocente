package ec.edu.uasb.sisevaluacion.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(SolicitudActnota.class)
public class SolicitudActnota_ { 

    public static volatile SingularAttribute<SolicitudActnota, Long> anio;
    public static volatile SingularAttribute<SolicitudActnota, Date> fechaCrea;
    public static volatile SingularAttribute<SolicitudActnota, String> usuarioCrea;
    public static volatile SingularAttribute<SolicitudActnota, Character> tipoEncuesta;
    public static volatile SingularAttribute<SolicitudActnota, Date> fechaModifica;
    public static volatile SingularAttribute<SolicitudActnota, Long> codigoNivel;
    public static volatile SingularAttribute<SolicitudActnota, Long> codigoEstudiante;
    public static volatile SingularAttribute<SolicitudActnota, String> usuarioModifica;
    public static volatile SingularAttribute<SolicitudActnota, Long> ciclo;
    public static volatile SingularAttribute<SolicitudActnota, Long> solCodigo;
    public static volatile SingularAttribute<SolicitudActnota, Long> codigoEsp;
    public static volatile SingularAttribute<SolicitudActnota, Character> solEstado;
    public static volatile SingularAttribute<SolicitudActnota, Long> codigoMateria;

}