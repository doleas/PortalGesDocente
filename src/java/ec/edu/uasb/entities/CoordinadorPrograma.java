/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david.oleas
 */
@Entity
@Table(name = "COORDINADOR_PROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordinadorPrograma.findAll", query = "SELECT c FROM CoordinadorPrograma c")
    , @NamedQuery(name = "CoordinadorPrograma.findByAreNombre", query = "SELECT c FROM CoordinadorPrograma c WHERE c.areNombre = :areNombre")
    , @NamedQuery(name = "CoordinadorPrograma.findByCodEjercicio", query = "SELECT c FROM CoordinadorPrograma c WHERE c.codEjercicio = :codEjercicio")
    , @NamedQuery(name = "CoordinadorPrograma.findByAnio", query = "SELECT c FROM CoordinadorPrograma c WHERE c.anio = :anio")
    , @NamedQuery(name = "CoordinadorPrograma.findByCodigoNiveacad", query = "SELECT c FROM CoordinadorPrograma c WHERE c.codigoNiveacad = :codigoNiveacad")
    , @NamedQuery(name = "CoordinadorPrograma.findByNivelAcademico", query = "SELECT c FROM CoordinadorPrograma c WHERE c.nivelAcademico = :nivelAcademico")
    , @NamedQuery(name = "CoordinadorPrograma.findByNombrePrograma", query = "SELECT c FROM CoordinadorPrograma c WHERE c.nombrePrograma = :nombrePrograma")
    , @NamedQuery(name = "CoordinadorPrograma.findByNumParalelos", query = "SELECT c FROM CoordinadorPrograma c WHERE c.numParalelos = :numParalelos")
    , @NamedQuery(name = "CoordinadorPrograma.findByCodCoordinador", query = "SELECT c FROM CoordinadorPrograma c WHERE c.codCoordinador = :codCoordinador")
    , @NamedQuery(name = "CoordinadorPrograma.findByApellidoCoordinador", query = "SELECT c FROM CoordinadorPrograma c WHERE c.apellidoCoordinador = :apellidoCoordinador")
    , @NamedQuery(name = "CoordinadorPrograma.findByNombreCoordinador", query = "SELECT c FROM CoordinadorPrograma c WHERE c.nombreCoordinador = :nombreCoordinador")
    , @NamedQuery(name = "CoordinadorPrograma.findByEmailCoordinador", query = "SELECT c FROM CoordinadorPrograma c WHERE c.emailCoordinador = :emailCoordinador")
    , @NamedQuery(name = "CoordinadorPrograma.findByDatalta", query = "SELECT c FROM CoordinadorPrograma c WHERE c.datalta = :datalta")
    , @NamedQuery(name = "CoordinadorPrograma.findByDatbaja", query = "SELECT c FROM CoordinadorPrograma c WHERE c.datbaja = :datbaja")})
public class CoordinadorPrograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoordinadorProgramaPK coordinadorProgramaPK;
    @Size(max = 75)
    @Column(name = "ARE_NOMBRE")
    private String areNombre;
    @Column(name = "COD_EJERCICIO")
    private Short codEjercicio;
    @Column(name = "ANIO")
    private BigInteger anio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_NIVEACAD")
    private String codigoNiveacad;
    @Size(max = 75)
    @Column(name = "NIVEL_ACADEMICO")
    private String nivelAcademico;
    @Size(max = 75)
    @Column(name = "NOMBRE_PROGRAMA")
    private String nombrePrograma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NUM_PARALELOS")
    private Double numParalelos;
    @Column(name = "COD_COORDINADOR")
    private Double codCoordinador;
    @Size(max = 65)
    @Column(name = "APELLIDO_COORDINADOR")
    private String apellidoCoordinador;
    @Size(max = 32)
    @Column(name = "NOMBRE_COORDINADOR")
    private String nombreCoordinador;
    @Size(max = 100)
    @Column(name = "EMAIL_COORDINADOR")
    private String emailCoordinador;
    @Size(max = 27)
    @Column(name = "DATALTA")
    private String datalta;
    @Size(max = 27)
    @Column(name = "DATBAJA")
    private String datbaja;

    public CoordinadorPrograma() {
    }
    
    public CoordinadorPrograma(CoordinadorProgramaPK coordinadorProgramaPK) {
        this.coordinadorProgramaPK = coordinadorProgramaPK;
    }

    public CoordinadorProgramaPK getCoordinadorProgramaPK() {
        return coordinadorProgramaPK;
    }

    public void setCoordinadorProgramaPK(CoordinadorProgramaPK coordinadorProgramaPK) {
        this.coordinadorProgramaPK = coordinadorProgramaPK;
    }
    
    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public Short getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(Short codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public String getCodigoNiveacad() {
        return codigoNiveacad;
    }

    public void setCodigoNiveacad(String codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public Double getNumParalelos() {
        return numParalelos;
    }

    public void setNumParalelos(Double numParalelos) {
        this.numParalelos = numParalelos;
    }

    public Double getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(Double codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

    public String getApellidoCoordinador() {
        return apellidoCoordinador;
    }

    public void setApellidoCoordinador(String apellidoCoordinador) {
        this.apellidoCoordinador = apellidoCoordinador;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getEmailCoordinador() {
        return emailCoordinador;
    }

    public void setEmailCoordinador(String emailCoordinador) {
        this.emailCoordinador = emailCoordinador;
    }

    public String getDatalta() {
        return datalta;
    }

    public void setDatalta(String datalta) {
        this.datalta = datalta;
    }

    public String getDatbaja() {
        return datbaja;
    }

    public void setDatbaja(String datbaja) {
        this.datbaja = datbaja;
    }
    
}
