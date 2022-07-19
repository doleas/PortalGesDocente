package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import ec.edu.uasb.portalgesdocente.entities.DatosViajeroPK;
import ec.edu.uasb.portalgesdocente.entities.Rubros;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(DatosViajero.class)
public class DatosViajero_ { 

    public static volatile SingularAttribute<DatosViajero, String> dviRutaPasaje;
    public static volatile SingularAttribute<DatosViajero, BigDecimal> dviValorDiario;
    public static volatile SingularAttribute<DatosViajero, Date> dviFechaHasta;
    public static volatile SingularAttribute<DatosViajero, String> dviTipoPasaje;
    public static volatile SingularAttribute<DatosViajero, Short> dviCantidad;
    public static volatile SingularAttribute<DatosViajero, Rubros> rubros;
    public static volatile SingularAttribute<DatosViajero, ContratoDocente> contratoDocente;
    public static volatile SingularAttribute<DatosViajero, DatosViajeroPK> datosViajeroPK;
    public static volatile SingularAttribute<DatosViajero, Date> dviFechaDesde;

}