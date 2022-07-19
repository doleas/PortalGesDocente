package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.PrinBanco;
import ec.edu.uasb.tutoria.entities.PrinCiudad;
import ec.edu.uasb.tutoria.entities.PrinDiscapacidad;
import ec.edu.uasb.tutoria.entities.PrinPais;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(PrinPersona.class)
public class PrinPersona_ { 

    public static volatile SingularAttribute<PrinPersona, Long> perCodigo;
    public static volatile SingularAttribute<PrinPersona, String> perNombres;
    public static volatile SingularAttribute<PrinPersona, PrinDiscapacidad> disCodigo;
    public static volatile SingularAttribute<PrinPersona, String> perGrupoSanguineo;
    public static volatile SingularAttribute<PrinPersona, PrinBanco> banCodigo;
    public static volatile SingularAttribute<PrinPersona, String> perSuscripcion;
    public static volatile SingularAttribute<PrinPersona, PrinPais> nacPaiCodigo;
    public static volatile SingularAttribute<PrinPersona, String> perEmailTrabajo;
    public static volatile SingularAttribute<PrinPersona, String> perTipoCuenta;
    public static volatile SingularAttribute<PrinPersona, Integer> perEnrolCodigo;
    public static volatile SingularAttribute<PrinPersona, String> perTipoDoc;
    public static volatile SingularAttribute<PrinPersona, String> perUsuarioAct;
    public static volatile SingularAttribute<PrinPersona, String> perNumeroRuc;
    public static volatile SingularAttribute<PrinPersona, String> perAutoidentificacion;
    public static volatile SingularAttribute<PrinPersona, String> perNroCarnetDiscap;
    public static volatile SingularAttribute<PrinPersona, String> perDirecTrabajo;
    public static volatile SingularAttribute<PrinPersona, String> perSexo;
    public static volatile SingularAttribute<PrinPersona, String> perPrimerApellido;
    public static volatile SingularAttribute<PrinPersona, String> perOcupacionActual;
    public static volatile SingularAttribute<PrinPersona, String> perCuentaBanco;
    public static volatile SingularAttribute<PrinPersona, String> perAceptacion;
    public static volatile SingularAttribute<PrinPersona, String> perDirecDom;
    public static volatile SingularAttribute<PrinPersona, String> perEstadoCivil;
    public static volatile SingularAttribute<PrinPersona, String> perTelefonoTrab;
    public static volatile SingularAttribute<PrinPersona, String> perTelefonoDom;
    public static volatile SingularAttribute<PrinPersona, String> perIdDoc;
    public static volatile SingularAttribute<PrinPersona, String> perCelular;
    public static volatile SingularAttribute<PrinPersona, String> perEmail;
    public static volatile SingularAttribute<PrinPersona, PrinCiudad> prinCiudad;
    public static volatile SingularAttribute<PrinPersona, PrinPais> paiNacionalidad;
    public static volatile SingularAttribute<PrinPersona, String> perTerceraEdad;
    public static volatile SingularAttribute<PrinPersona, Date> perFechaCrea;
    public static volatile SingularAttribute<PrinPersona, String> perFechaNacimiento;
    public static volatile SingularAttribute<PrinPersona, String> perSegundoApellido;
    public static volatile SingularAttribute<PrinPersona, String> perProfesion;
    public static volatile SingularAttribute<PrinPersona, String> perUsuario;
    public static volatile SingularAttribute<PrinPersona, Date> perFechaAct;
    public static volatile SingularAttribute<PrinPersona, String> perLugarTrabajo;
    public static volatile SingularAttribute<PrinPersona, BigDecimal> perPrcDiscap;
    public static volatile SingularAttribute<PrinPersona, String> perGenero;

}