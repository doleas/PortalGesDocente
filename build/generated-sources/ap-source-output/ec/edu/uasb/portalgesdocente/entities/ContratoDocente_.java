package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.DatosViajero;
import ec.edu.uasb.portalgesdocente.entities.EstadoSolicContrato;
import ec.edu.uasb.portalgesdocente.entities.Honorarios;
import ec.edu.uasb.portalgesdocente.entities.PorTutoriaMonografia;
import ec.edu.uasb.portalgesdocente.entities.RolDocente;
import ec.edu.uasb.portalgesdocente.entities.SolicitudPago;
import ec.edu.uasb.portalgesdocente.entities.TiposFormaPago;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(ContratoDocente.class)
public class ContratoDocente_ { 

    public static volatile SingularAttribute<ContratoDocente, Long> cdoCodigo;
    public static volatile SingularAttribute<ContratoDocente, Short> cdoCantUnidad;
    public static volatile SingularAttribute<ContratoDocente, String> cdoTexto;
    public static volatile SingularAttribute<ContratoDocente, Long> prfCodigo;
    public static volatile CollectionAttribute<ContratoDocente, DatosViajero> datosViajeroCollection;
    public static volatile CollectionAttribute<ContratoDocente, PorTutoriaMonografia> porTutoriaMonografiaCollection;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFecini;
    public static volatile SingularAttribute<ContratoDocente, Long> asgCodigo;
    public static volatile SingularAttribute<ContratoDocente, Long> cdoUsuCrea;
    public static volatile SingularAttribute<ContratoDocente, String> cdoListoFirmaElectronica;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaGenContr;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaFirmaDocente;
    public static volatile SingularAttribute<ContratoDocente, Long> cdoAnioAcad;
    public static volatile SingularAttribute<ContratoDocente, Long> prlCodigo;
    public static volatile SingularAttribute<ContratoDocente, Long> cdoUsuModif;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaCrea;
    public static volatile SingularAttribute<ContratoDocente, Long> prgCodigo;
    public static volatile SingularAttribute<ContratoDocente, String> staCodigo;
    public static volatile SingularAttribute<ContratoDocente, BigDecimal> cdoMonto;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaListoFirma;
    public static volatile CollectionAttribute<ContratoDocente, EstadoSolicContrato> estadoSolicContratoCollection;
    public static volatile SingularAttribute<ContratoDocente, Long> aspCodigo;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFecfin;
    public static volatile SingularAttribute<ContratoDocente, String> cdoRevisadoPor;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaFirmaRector;
    public static volatile SingularAttribute<ContratoDocente, String> cdoNumero;
    public static volatile SingularAttribute<ContratoDocente, Date> cdoFechaModif;
    public static volatile CollectionAttribute<ContratoDocente, Honorarios> honorariosCollection;
    public static volatile SingularAttribute<ContratoDocente, Long> areCodigo;
    public static volatile SingularAttribute<ContratoDocente, String> cdoObservaciones;
    public static volatile SingularAttribute<ContratoDocente, RolDocente> rolDocente;
    public static volatile SingularAttribute<ContratoDocente, String> cdoDsctoUsoResid;
    public static volatile CollectionAttribute<ContratoDocente, SolicitudPago> solicitudPagoCollection;
    public static volatile SingularAttribute<ContratoDocente, TiposFormaPago> tiposFormaPago;

}