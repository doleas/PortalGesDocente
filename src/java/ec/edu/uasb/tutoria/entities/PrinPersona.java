/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "PRIN_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrinPersona.findAll", query = "SELECT p FROM PrinPersona p")
    , @NamedQuery(name = "PrinPersona.findByPerCodigo", query = "SELECT p FROM PrinPersona p WHERE p.perCodigo = :perCodigo")
    , @NamedQuery(name = "PrinPersona.findByPerIdDoc", query = "SELECT p FROM PrinPersona p WHERE p.perIdDoc = :perIdDoc")
    , @NamedQuery(name = "PrinPersona.findByPerTipoDoc", query = "SELECT p FROM PrinPersona p WHERE p.perTipoDoc = :perTipoDoc")
    , @NamedQuery(name = "PrinPersona.findByPerPrimerApellido", query = "SELECT p FROM PrinPersona p WHERE p.perPrimerApellido = :perPrimerApellido")
    , @NamedQuery(name = "PrinPersona.findByPerSegundoApellido", query = "SELECT p FROM PrinPersona p WHERE p.perSegundoApellido = :perSegundoApellido")
    , @NamedQuery(name = "PrinPersona.findByPerNombres", query = "SELECT p FROM PrinPersona p WHERE p.perNombres = :perNombres")
    , @NamedQuery(name = "PrinPersona.findByPerFechaNacimiento", query = "SELECT p FROM PrinPersona p WHERE p.perFechaNacimiento = :perFechaNacimiento")
    , @NamedQuery(name = "PrinPersona.findByPerSexo", query = "SELECT p FROM PrinPersona p WHERE p.perSexo = :perSexo")
    , @NamedQuery(name = "PrinPersona.findByPerGenero", query = "SELECT p FROM PrinPersona p WHERE p.perGenero = :perGenero")
    , @NamedQuery(name = "PrinPersona.findByPerEstadoCivil", query = "SELECT p FROM PrinPersona p WHERE p.perEstadoCivil = :perEstadoCivil")
    , @NamedQuery(name = "PrinPersona.findByPerTerceraEdad", query = "SELECT p FROM PrinPersona p WHERE p.perTerceraEdad = :perTerceraEdad")
    , @NamedQuery(name = "PrinPersona.findByPerEmail", query = "SELECT p FROM PrinPersona p WHERE p.perEmail = :perEmail")
    , @NamedQuery(name = "PrinPersona.findByPerCelular", query = "SELECT p FROM PrinPersona p WHERE p.perCelular = :perCelular")
    , @NamedQuery(name = "PrinPersona.findByPerDirecDom", query = "SELECT p FROM PrinPersona p WHERE p.perDirecDom = :perDirecDom")
    , @NamedQuery(name = "PrinPersona.findByPerTelefonoDom", query = "SELECT p FROM PrinPersona p WHERE p.perTelefonoDom = :perTelefonoDom")
    , @NamedQuery(name = "PrinPersona.findByPerPrcDiscap", query = "SELECT p FROM PrinPersona p WHERE p.perPrcDiscap = :perPrcDiscap")
    , @NamedQuery(name = "PrinPersona.findByPerNroCarnetDiscap", query = "SELECT p FROM PrinPersona p WHERE p.perNroCarnetDiscap = :perNroCarnetDiscap")
    , @NamedQuery(name = "PrinPersona.findByPerOcupacionActual", query = "SELECT p FROM PrinPersona p WHERE p.perOcupacionActual = :perOcupacionActual")
    , @NamedQuery(name = "PrinPersona.findByPerEmailTrabajo", query = "SELECT p FROM PrinPersona p WHERE p.perEmailTrabajo = :perEmailTrabajo")
    , @NamedQuery(name = "PrinPersona.findByPerDirecTrabajo", query = "SELECT p FROM PrinPersona p WHERE p.perDirecTrabajo = :perDirecTrabajo")
    , @NamedQuery(name = "PrinPersona.findByPerLugarTrabajo", query = "SELECT p FROM PrinPersona p WHERE p.perLugarTrabajo = :perLugarTrabajo")
    , @NamedQuery(name = "PrinPersona.findByPerTelefonoTrab", query = "SELECT p FROM PrinPersona p WHERE p.perTelefonoTrab = :perTelefonoTrab")
    , @NamedQuery(name = "PrinPersona.findByPerCuentaBanco", query = "SELECT p FROM PrinPersona p WHERE p.perCuentaBanco = :perCuentaBanco")
    , @NamedQuery(name = "PrinPersona.findByPerTipoCuenta", query = "SELECT p FROM PrinPersona p WHERE p.perTipoCuenta = :perTipoCuenta")
    , @NamedQuery(name = "PrinPersona.findByPerNumeroRuc", query = "SELECT p FROM PrinPersona p WHERE p.perNumeroRuc = :perNumeroRuc")
    , @NamedQuery(name = "PrinPersona.findByPerAutoidentificacion", query = "SELECT p FROM PrinPersona p WHERE p.perAutoidentificacion = :perAutoidentificacion")
    , @NamedQuery(name = "PrinPersona.findByPerGrupoSanguineo", query = "SELECT p FROM PrinPersona p WHERE p.perGrupoSanguineo = :perGrupoSanguineo")
    , @NamedQuery(name = "PrinPersona.findByPerSuscripcion", query = "SELECT p FROM PrinPersona p WHERE p.perSuscripcion = :perSuscripcion")
    , @NamedQuery(name = "PrinPersona.findByPerUsuario", query = "SELECT p FROM PrinPersona p WHERE p.perUsuario = :perUsuario")
    , @NamedQuery(name = "PrinPersona.findByPerFechaCrea", query = "SELECT p FROM PrinPersona p WHERE p.perFechaCrea = :perFechaCrea")
    , @NamedQuery(name = "PrinPersona.findByPerFechaAct", query = "SELECT p FROM PrinPersona p WHERE p.perFechaAct = :perFechaAct")
    , @NamedQuery(name = "PrinPersona.findByPerUsuarioAct", query = "SELECT p FROM PrinPersona p WHERE p.perUsuarioAct = :perUsuarioAct")
    , @NamedQuery(name = "PrinPersona.findByPerEnrolCodigo", query = "SELECT p FROM PrinPersona p WHERE p.perEnrolCodigo = :perEnrolCodigo")
    , @NamedQuery(name = "PrinPersona.findByPerProfesion", query = "SELECT p FROM PrinPersona p WHERE p.perProfesion = :perProfesion")
    , @NamedQuery(name = "PrinPersona.findByPerAceptacion", query = "SELECT p FROM PrinPersona p WHERE p.perAceptacion = :perAceptacion")})
public class PrinPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PER_ID_DOC")
    private String perIdDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_TIPO_DOC")
    private String perTipoDoc;
    @Size(max = 100)
    @Column(name = "PER_PRIMER_APELLIDO")
    private String perPrimerApellido;
    @Size(max = 100)
    @Column(name = "PER_SEGUNDO_APELLIDO")
    private String perSegundoApellido;
    @Size(max = 200)
    @Column(name = "PER_NOMBRES")
    private String perNombres;
    @Size(max = 10)
    @Column(name = "PER_FECHA_NACIMIENTO")
    private String perFechaNacimiento;
    @Size(max = 1)
    @Column(name = "PER_SEXO")
    private String perSexo;
    @Size(max = 1)
    @Column(name = "PER_GENERO")
    private String perGenero;
    @Size(max = 30)
    @Column(name = "PER_ESTADO_CIVIL")
    private String perEstadoCivil;
    @Size(max = 1)
    @Column(name = "PER_TERCERA_EDAD")
    private String perTerceraEdad;
    @Size(max = 60)
    @Column(name = "PER_EMAIL")
    private String perEmail;
    @Size(max = 15)
    @Column(name = "PER_CELULAR")
    private String perCelular;
    @Size(max = 250)
    @Column(name = "PER_DIREC_DOM")
    private String perDirecDom;
    @Size(max = 15)
    @Column(name = "PER_TELEFONO_DOM")
    private String perTelefonoDom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PER_PRC_DISCAP")
    private BigDecimal perPrcDiscap;
    @Size(max = 15)
    @Column(name = "PER_NRO_CARNET_DISCAP")
    private String perNroCarnetDiscap;
    @Size(max = 60)
    @Column(name = "PER_OCUPACION_ACTUAL")
    private String perOcupacionActual;
    @Size(max = 60)
    @Column(name = "PER_EMAIL_TRABAJO")
    private String perEmailTrabajo;
    @Size(max = 250)
    @Column(name = "PER_DIREC_TRABAJO")
    private String perDirecTrabajo;
    @Size(max = 250)
    @Column(name = "PER_LUGAR_TRABAJO")
    private String perLugarTrabajo;
    @Size(max = 15)
    @Column(name = "PER_TELEFONO_TRAB")
    private String perTelefonoTrab;
    @Size(max = 15)
    @Column(name = "PER_CUENTA_BANCO")
    private String perCuentaBanco;
    @Size(max = 10)
    @Column(name = "PER_TIPO_CUENTA")
    private String perTipoCuenta;
    @Size(max = 15)
    @Column(name = "PER_NUMERO_RUC")
    private String perNumeroRuc;
    @Size(max = 60)
    @Column(name = "PER_AUTOIDENTIFICACION")
    private String perAutoidentificacion;
    @Size(max = 5)
    @Column(name = "PER_GRUPO_SANGUINEO")
    private String perGrupoSanguineo;
    @Size(max = 1)
    @Column(name = "PER_SUSCRIPCION")
    private String perSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PER_USUARIO")
    private String perUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaCrea;
    @Column(name = "PER_FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaAct;
    @Size(max = 25)
    @Column(name = "PER_USUARIO_ACT")
    private String perUsuarioAct;
    @Column(name = "PER_ENROL_CODIGO")
    private Integer perEnrolCodigo;
    @Size(max = 200)
    @Column(name = "PER_PROFESION")
    private String perProfesion;
    @Size(max = 1)
    @Column(name = "PER_ACEPTACION")
    private String perAceptacion;
    @JoinColumn(name = "BAN_CODIGO", referencedColumnName = "BAN_CODIGO")
    @ManyToOne
    private PrinBanco banCodigo;
    @JoinColumns({
        @JoinColumn(name = "CIU_CODIGO", referencedColumnName = "CIU_CODIGO")
        , @JoinColumn(name = "PAI_CODIGO", referencedColumnName = "PAI_CODIGO")})
    @ManyToOne
    private PrinCiudad prinCiudad;
    @JoinColumn(name = "DIS_CODIGO", referencedColumnName = "DIS_CODIGO")
    @ManyToOne
    private PrinDiscapacidad disCodigo;
    @JoinColumn(name = "NAC_PAI_CODIGO", referencedColumnName = "PAI_CODIGO")
    @ManyToOne
    private PrinPais nacPaiCodigo;
    @JoinColumn(name = "PAI_NACIONALIDAD", referencedColumnName = "PAI_CODIGO")
    @ManyToOne
    private PrinPais paiNacionalidad;

    public PrinPersona() {
    }

    public PrinPersona(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public PrinPersona(Long perCodigo, String perIdDoc, String perTipoDoc, String perUsuario, Date perFechaCrea) {
        this.perCodigo = perCodigo;
        this.perIdDoc = perIdDoc;
        this.perTipoDoc = perTipoDoc;
        this.perUsuario = perUsuario;
        this.perFechaCrea = perFechaCrea;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerIdDoc() {
        return perIdDoc;
    }

    public void setPerIdDoc(String perIdDoc) {
        this.perIdDoc = perIdDoc;
    }

    public String getPerTipoDoc() {
        return perTipoDoc;
    }

    public void setPerTipoDoc(String perTipoDoc) {
        this.perTipoDoc = perTipoDoc;
    }

    public String getPerPrimerApellido() {
        return perPrimerApellido;
    }

    public void setPerPrimerApellido(String perPrimerApellido) {
        this.perPrimerApellido = perPrimerApellido;
    }

    public String getPerSegundoApellido() {
        return perSegundoApellido;
    }

    public void setPerSegundoApellido(String perSegundoApellido) {
        this.perSegundoApellido = perSegundoApellido;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(String perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public String getPerEstadoCivil() {
        return perEstadoCivil;
    }

    public void setPerEstadoCivil(String perEstadoCivil) {
        this.perEstadoCivil = perEstadoCivil;
    }

    public String getPerTerceraEdad() {
        return perTerceraEdad;
    }

    public void setPerTerceraEdad(String perTerceraEdad) {
        this.perTerceraEdad = perTerceraEdad;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public String getPerDirecDom() {
        return perDirecDom;
    }

    public void setPerDirecDom(String perDirecDom) {
        this.perDirecDom = perDirecDom;
    }

    public String getPerTelefonoDom() {
        return perTelefonoDom;
    }

    public void setPerTelefonoDom(String perTelefonoDom) {
        this.perTelefonoDom = perTelefonoDom;
    }

    public BigDecimal getPerPrcDiscap() {
        return perPrcDiscap;
    }

    public void setPerPrcDiscap(BigDecimal perPrcDiscap) {
        this.perPrcDiscap = perPrcDiscap;
    }

    public String getPerNroCarnetDiscap() {
        return perNroCarnetDiscap;
    }

    public void setPerNroCarnetDiscap(String perNroCarnetDiscap) {
        this.perNroCarnetDiscap = perNroCarnetDiscap;
    }

    public String getPerOcupacionActual() {
        return perOcupacionActual;
    }

    public void setPerOcupacionActual(String perOcupacionActual) {
        this.perOcupacionActual = perOcupacionActual;
    }

    public String getPerEmailTrabajo() {
        return perEmailTrabajo;
    }

    public void setPerEmailTrabajo(String perEmailTrabajo) {
        this.perEmailTrabajo = perEmailTrabajo;
    }

    public String getPerDirecTrabajo() {
        return perDirecTrabajo;
    }

    public void setPerDirecTrabajo(String perDirecTrabajo) {
        this.perDirecTrabajo = perDirecTrabajo;
    }

    public String getPerLugarTrabajo() {
        return perLugarTrabajo;
    }

    public void setPerLugarTrabajo(String perLugarTrabajo) {
        this.perLugarTrabajo = perLugarTrabajo;
    }

    public String getPerTelefonoTrab() {
        return perTelefonoTrab;
    }

    public void setPerTelefonoTrab(String perTelefonoTrab) {
        this.perTelefonoTrab = perTelefonoTrab;
    }

    public String getPerCuentaBanco() {
        return perCuentaBanco;
    }

    public void setPerCuentaBanco(String perCuentaBanco) {
        this.perCuentaBanco = perCuentaBanco;
    }

    public String getPerTipoCuenta() {
        return perTipoCuenta;
    }

    public void setPerTipoCuenta(String perTipoCuenta) {
        this.perTipoCuenta = perTipoCuenta;
    }

    public String getPerNumeroRuc() {
        return perNumeroRuc;
    }

    public void setPerNumeroRuc(String perNumeroRuc) {
        this.perNumeroRuc = perNumeroRuc;
    }

    public String getPerAutoidentificacion() {
        return perAutoidentificacion;
    }

    public void setPerAutoidentificacion(String perAutoidentificacion) {
        this.perAutoidentificacion = perAutoidentificacion;
    }

    public String getPerGrupoSanguineo() {
        return perGrupoSanguineo;
    }

    public void setPerGrupoSanguineo(String perGrupoSanguineo) {
        this.perGrupoSanguineo = perGrupoSanguineo;
    }

    public String getPerSuscripcion() {
        return perSuscripcion;
    }

    public void setPerSuscripcion(String perSuscripcion) {
        this.perSuscripcion = perSuscripcion;
    }

    public String getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(String perUsuario) {
        this.perUsuario = perUsuario;
    }

    public Date getPerFechaCrea() {
        return perFechaCrea;
    }

    public void setPerFechaCrea(Date perFechaCrea) {
        this.perFechaCrea = perFechaCrea;
    }

    public Date getPerFechaAct() {
        return perFechaAct;
    }

    public void setPerFechaAct(Date perFechaAct) {
        this.perFechaAct = perFechaAct;
    }

    public String getPerUsuarioAct() {
        return perUsuarioAct;
    }

    public void setPerUsuarioAct(String perUsuarioAct) {
        this.perUsuarioAct = perUsuarioAct;
    }

    public Integer getPerEnrolCodigo() {
        return perEnrolCodigo;
    }

    public void setPerEnrolCodigo(Integer perEnrolCodigo) {
        this.perEnrolCodigo = perEnrolCodigo;
    }

    public String getPerProfesion() {
        return perProfesion;
    }

    public void setPerProfesion(String perProfesion) {
        this.perProfesion = perProfesion;
    }

    public String getPerAceptacion() {
        return perAceptacion;
    }

    public void setPerAceptacion(String perAceptacion) {
        this.perAceptacion = perAceptacion;
    }

    public PrinBanco getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(PrinBanco banCodigo) {
        this.banCodigo = banCodigo;
    }

    public PrinCiudad getPrinCiudad() {
        return prinCiudad;
    }

    public void setPrinCiudad(PrinCiudad prinCiudad) {
        this.prinCiudad = prinCiudad;
    }

    public PrinDiscapacidad getDisCodigo() {
        return disCodigo;
    }

    public void setDisCodigo(PrinDiscapacidad disCodigo) {
        this.disCodigo = disCodigo;
    }

    public PrinPais getNacPaiCodigo() {
        return nacPaiCodigo;
    }

    public void setNacPaiCodigo(PrinPais nacPaiCodigo) {
        this.nacPaiCodigo = nacPaiCodigo;
    }

    public PrinPais getPaiNacionalidad() {
        return paiNacionalidad;
    }

    public void setPaiNacionalidad(PrinPais paiNacionalidad) {
        this.paiNacionalidad = paiNacionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrinPersona)) {
            return false;
        }
        PrinPersona other = (PrinPersona) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.PrinPersona[ perCodigo=" + perCodigo + " ]";
    }
    
}
