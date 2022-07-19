package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:04")
@StaticMetamodel(SolicitudPago.class)
public class SolicitudPago_ { 

    public static volatile SingularAttribute<SolicitudPago, String> slpEstado;
    public static volatile SingularAttribute<SolicitudPago, Long> slpCodigo;
    public static volatile SingularAttribute<SolicitudPago, String> slpDescripPago;
    public static volatile SingularAttribute<SolicitudPago, String> slpUsuarioAprob;
    public static volatile SingularAttribute<SolicitudPago, Short> slpHorasClase;
    public static volatile SingularAttribute<SolicitudPago, Date> slpFechaAprob;
    public static volatile SingularAttribute<SolicitudPago, BigDecimal> slpMontoPago;
    public static volatile SingularAttribute<SolicitudPago, Date> slpFecha;
    public static volatile SingularAttribute<SolicitudPago, ContratoDocente> contratoDocente;

}