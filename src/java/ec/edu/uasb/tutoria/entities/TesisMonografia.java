/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "TESIS_MONOGRAFIA", schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisMonografia.findAll", query = "SELECT t FROM TesisMonografia t")
    , @NamedQuery(name = "TesisMonografia.findByCodigoEsp", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.codigoEsp = :codigoEsp")
    , @NamedQuery(name = "TesisMonografia.findByCodigoNiveacad", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.codigoNiveacad = :codigoNiveacad")
    , @NamedQuery(name = "TesisMonografia.findByPrograma", query = "SELECT t FROM TesisMonografia t WHERE t.programa = :programa")
    , @NamedQuery(name = "TesisMonografia.findByTema", query = "SELECT t FROM TesisMonografia t WHERE t.tema = :tema")
    , @NamedQuery(name = "TesisMonografia.findByCodEstudiante", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.codEstudiante = :codEstudiante")
    , @NamedQuery(name = "TesisMonografia.findByCedPasEstudiante", query = "SELECT t FROM TesisMonografia t WHERE t.cedPasEstudiante = :cedPasEstudiante")
    , @NamedQuery(name = "TesisMonografia.findByNombreEstudiante", query = "SELECT t FROM TesisMonografia t WHERE t.nombreEstudiante = :nombreEstudiante")
    , @NamedQuery(name = "TesisMonografia.findByTiptrabajo", query = "SELECT t FROM TesisMonografia t WHERE t.tiptrabajo = :tiptrabajo")
    , @NamedQuery(name = "TesisMonografia.findByNumConsultas", query = "SELECT t FROM TesisMonografia t WHERE t.numConsultas = :numConsultas")
    , @NamedQuery(name = "TesisMonografia.findByNumHoras", query = "SELECT t FROM TesisMonografia t WHERE t.numHoras = :numHoras")
    , @NamedQuery(name = "TesisMonografia.findByMatricula", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.matricula = :matricula")
    , @NamedQuery(name = "TesisMonografia.findByTipo", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.tipo = :tipo")
    , @NamedQuery(name = "TesisMonografia.findByRoldocen", query = "SELECT t FROM TesisMonografia t WHERE t.roldocen = :roldocen")
    , @NamedQuery(name = "TesisMonografia.findByTipHoras", query = "SELECT t FROM TesisMonografia t WHERE t.tipHoras = :tipHoras")
    , @NamedQuery(name = "TesisMonografia.findByAnioEstudiante", query = "SELECT t FROM TesisMonografia t WHERE t.anioEstudiante = :anioEstudiante")
    , @NamedQuery(name = "TesisMonografia.findByNombresProfesor", query = "SELECT t FROM TesisMonografia t WHERE t.nombresProfesor = :nombresProfesor")
    , @NamedQuery(name = "TesisMonografia.findByEstadoTesMon", query = "SELECT t FROM TesisMonografia t WHERE t.estadoTesMon = :estadoTesMon")
    , @NamedQuery(name = "TesisMonografia.findByEstadoProceso", query = "SELECT t FROM TesisMonografia t WHERE t.estadoProceso = :estadoProceso")
    , @NamedQuery(name = "TesisMonografia.findByFecha", query = "SELECT t FROM TesisMonografia t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TesisMonografia.findByFechaIni", query = "SELECT t FROM TesisMonografia t WHERE t.fechaIni = :fechaIni")
    , @NamedQuery(name = "TesisMonografia.findByFechaFin", query = "SELECT t FROM TesisMonografia t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "TesisMonografia.findByAnioInicio", query = "SELECT t FROM TesisMonografia t WHERE t.anioInicio = :anioInicio")
    , @NamedQuery(name = "TesisMonografia.findByAnioFin", query = "SELECT t FROM TesisMonografia t WHERE t.anioFin = :anioFin")
    , @NamedQuery(name = "TesisMonografia.findByTipprograma", query = "SELECT t FROM TesisMonografia t WHERE t.tipprograma = :tipprograma")
    , @NamedQuery(name = "TesisMonografia.findBySistema", query = "SELECT t FROM TesisMonografia t WHERE t.sistema = :sistema")
    , @NamedQuery(name = "TesisMonografia.findByCodProfesor", query = "SELECT t FROM TesisMonografia t WHERE t.tesisMonografiaPK.codProfesor = :codProfesor")
    , @NamedQuery(name = "TesisMonografia.findByCedPasProfesor", query = "SELECT t FROM TesisMonografia t WHERE t.cedPasProfesor = :cedPasProfesor")})
public class TesisMonografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TesisMonografiaPK tesisMonografiaPK;
    @Size(max = 500)
    @Column(name = "PROGRAMA")
    private String programa;
    @Size(max = 8000)
    @Column(name = "TEMA")
    private String tema;
    @Size(max = 15)
    @Column(name = "CED_PAS_ESTUDIANTE")
    private String cedPasEstudiante;
    @Size(max = 200)
    @Column(name = "NOMBRE_ESTUDIANTE")
    private String nombreEstudiante;
    @Size(max = 200)
    @Column(name = "TIPTRABAJO")
    private String tiptrabajo;
    @Column(name = "NUM_CONSULTAS")
    private Integer numConsultas;
    @Column(name = "NUM_HORAS")
    private Integer numHoras;
    @Size(max = 30)
    @Column(name = "ROLDOCEN")
    private String roldocen;
    @Size(max = 10)
    @Column(name = "TIP_HORAS")
    private String tipHoras;
    @Column(name = "ANIO_ESTUDIANTE")
    private Long anioEstudiante;
    @Size(max = 60)
    @Column(name = "NOMBRES_PROFESOR")
    private String nombresProfesor;
    @Size(max = 1)
    @Column(name = "ESTADO_TES_MON")
    private String estadoTesMon;
    @Size(max = 1)
    @Column(name = "ESTADO_PROCESO")
    private String estadoProceso;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ANIO_INICIO")
    private Integer anioInicio;
    @Column(name = "ANIO_FIN")
    private Integer anioFin;
    @Size(max = 60)
    @Column(name = "TIPPROGRAMA")
    private String tipprograma;
    @Size(max = 30)
    @Column(name = "SISTEMA")
    private String sistema;
    @Size(max = 30)
    @Column(name = "CED_PAS_PROFESOR")
    private String cedPasProfesor;

    public TesisMonografia() {
    }

    public TesisMonografia(TesisMonografiaPK tesisMonografiaPK) {
        this.tesisMonografiaPK = tesisMonografiaPK;
    }

    public TesisMonografia(long codigoEsp, long codigoNiveacad, long codEstudiante, long matricula, String tipo, long codProfesor) {
        this.tesisMonografiaPK = new TesisMonografiaPK(codigoEsp, codigoNiveacad, codEstudiante, matricula, tipo, codProfesor);
    }

    public TesisMonografiaPK getTesisMonografiaPK() {
        return tesisMonografiaPK;
    }

    public void setTesisMonografiaPK(TesisMonografiaPK tesisMonografiaPK) {
        this.tesisMonografiaPK = tesisMonografiaPK;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCedPasEstudiante() {
        return cedPasEstudiante;
    }

    public void setCedPasEstudiante(String cedPasEstudiante) {
        this.cedPasEstudiante = cedPasEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getTiptrabajo() {
        return tiptrabajo;
    }

    public void setTiptrabajo(String tiptrabajo) {
        this.tiptrabajo = tiptrabajo;
    }

    public Integer getNumConsultas() {
        return numConsultas;
    }

    public void setNumConsultas(Integer numConsultas) {
        this.numConsultas = numConsultas;
    }

    public Integer getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Integer numHoras) {
        this.numHoras = numHoras;
    }

    public String getRoldocen() {
        return roldocen;
    }

    public void setRoldocen(String roldocen) {
        this.roldocen = roldocen;
    }

    public String getTipHoras() {
        return tipHoras;
    }

    public void setTipHoras(String tipHoras) {
        this.tipHoras = tipHoras;
    }

    public Long getAnioEstudiante() {
        return anioEstudiante;
    }

    public void setAnioEstudiante(Long anioEstudiante) {
        this.anioEstudiante = anioEstudiante;
    }

    public String getNombresProfesor() {
        return nombresProfesor;
    }

    public void setNombresProfesor(String nombresProfesor) {
        this.nombresProfesor = nombresProfesor;
    }

    public String getEstadoTesMon() {
        return estadoTesMon;
    }

    public void setEstadoTesMon(String estadoTesMon) {
        this.estadoTesMon = estadoTesMon;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }

    public String getTipprograma() {
        return tipprograma;
    }

    public void setTipprograma(String tipprograma) {
        this.tipprograma = tipprograma;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getCedPasProfesor() {
        return cedPasProfesor;
    }

    public void setCedPasProfesor(String cedPasProfesor) {
        this.cedPasProfesor = cedPasProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tesisMonografiaPK != null ? tesisMonografiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisMonografia)) {
            return false;
        }
        TesisMonografia other = (TesisMonografia) object;
        if ((this.tesisMonografiaPK == null && other.tesisMonografiaPK != null) || (this.tesisMonografiaPK != null && !this.tesisMonografiaPK.equals(other.tesisMonografiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TesisMonografia[ tesisMonografiaPK=" + tesisMonografiaPK + " ]";
    }
    
}
