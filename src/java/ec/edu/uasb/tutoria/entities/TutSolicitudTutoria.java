/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "TUT_SOLICITUD_TUTORIA", schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutSolicitudTutoria.findAll", query = "SELECT t FROM TutSolicitudTutoria t")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstCodigo", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstCodigo = :tstCodigo")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstCodigoSolicitante", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstCodigoSolicitante = :tstCodigoSolicitante")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstTipoSolicitante", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstTipoSolicitante = :tstTipoSolicitante")
    , @NamedQuery(name = "TutSolicitudTutoria.findByCodArea", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.codArea = :codArea")
    , @NamedQuery(name = "TutSolicitudTutoria.findByCodigoEsp", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.codigoEsp = :codigoEsp")
    , @NamedQuery(name = "TutSolicitudTutoria.findByArea", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.area = :area")
    , @NamedQuery(name = "TutSolicitudTutoria.findByPrograma", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.programa = :programa")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstFaseTutoria", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstFaseTutoria = :tstFaseTutoria")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstAnioEstudiante", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstAnioEstudiante = :tstAnioEstudiante")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstTipoTutoria", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstTipoTutoria = :tstTipoTutoria")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstModalidad", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstModalidad = :tstModalidad")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstTema", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstTema = :tstTema")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstFechaTutoria", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstFechaTutoria = :tstFechaTutoria")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstDuracion", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstDuracion = :tstDuracion")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstEdificio", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstEdificio = :tstEdificio")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstPiso", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstPiso = :tstPiso")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstInstalacion", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstInstalacion = :tstInstalacion")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstObservacion", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstObservacion = :tstObservacion")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstTipoGrupo", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstTipoGrupo = :tstTipoGrupo")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstEstadoSolicitado", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstEstadoSolicitado = :tstEstadoSolicitado")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstAprobadoPor", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstAprobadoPor = :tstAprobadoPor")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstFechaAprobado", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstFechaAprobado = :tstFechaAprobado")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstAnioSolicitud", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstAnioSolicitud = :tstAnioSolicitud")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstCodEjercicio", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstCodEjercicio = :tstCodEjercicio")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstCodProfesor", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstCodProfesor = :tstCodProfesor")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstCodInstancia", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstCodInstancia = :tstCodInstancia")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstUsuarioCrea", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstUsuarioCrea = :tstUsuarioCrea")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstFechaCrea", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstFechaCrea = :tstFechaCrea")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstFechaModifica", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstFechaModifica = :tstFechaModifica")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstUsuarioModifica", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstUsuarioModifica = :tstUsuarioModifica")
    , @NamedQuery(name = "TutSolicitudTutoria.findByTstHora", query = "SELECT t FROM TutSolicitudTutoria t WHERE t.tstHora = :tstHora")})
public class TutSolicitudTutoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TST_CODIGO")
    private Long tstCodigo;
    @Column(name = "TST_CODIGO_SOLICITANTE")
    private Long tstCodigoSolicitante;
    @Size(max = 60)
    @Column(name = "TST_TIPO_SOLICITANTE")
    private String tstTipoSolicitante;
    @Column(name = "COD_AREA")
    private Long codArea;
    @Column(name = "CODIGO_ESP")
    private Long codigoEsp;
    @Size(max = 100)
    @Column(name = "AREA")
    private String area;
    @Size(max = 500)
    @Column(name = "PROGRAMA")
    private String programa;
    @Size(max = 60)
    @Column(name = "TST_FASE_TUTORIA")
    private String tstFaseTutoria;
    @Column(name = "TST_ANIO_ESTUDIANTE")
    private Integer tstAnioEstudiante;
    @Size(max = 1)
    @Column(name = "TST_TIPO_TUTORIA")
    private String tstTipoTutoria;
    @Size(max = 1)
    @Column(name = "TST_MODALIDAD")
    private String tstModalidad;
    @Size(max = 8000)
    @Column(name = "TST_TEMA")
    private String tstTema;
    @Column(name = "TST_FECHA_TUTORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tstFechaTutoria;
    @Column(name = "TST_DURACION")
    private Integer tstDuracion;
    @Size(max = 200)
    @Column(name = "TST_EDIFICIO")
    private String tstEdificio;
    @Size(max = 100)
    @Column(name = "TST_PISO")
    private String tstPiso;
    @Size(max = 200)
    @Column(name = "TST_INSTALACION")
    private String tstInstalacion;
    @Size(max = 8000)
    @Column(name = "TST_OBSERVACION")
    private String tstObservacion;
    @Size(max = 1)
    @Column(name = "TST_TIPO_GRUPO")
    private String tstTipoGrupo;
    @Size(max = 1)
    @Column(name = "TST_ESTADO_SOLICITADO")
    private String tstEstadoSolicitado;
    @Size(max = 25)
    @Column(name = "TST_APROBADO_POR")
    private String tstAprobadoPor;
    @Column(name = "TST_FECHA_APROBADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tstFechaAprobado;
    @Column(name = "TST_ANIO_SOLICITUD")
    private Integer tstAnioSolicitud;
    @Column(name = "TST_COD_EJERCICIO")
    private Long tstCodEjercicio;
    @Column(name = "TST_COD_PROFESOR")
    private Long tstCodProfesor;
    @Column(name = "TST_COD_INSTANCIA")
    private Long tstCodInstancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TST_USUARIO_CREA")
    private String tstUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TST_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tstFechaCrea;
    @Column(name = "TST_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tstFechaModifica;
    @Size(max = 25)
    @Column(name = "TST_USUARIO_MODIFICA")
    private String tstUsuarioModifica;
    @Size(max = 16)
    @Column(name = "TST_HORA")
    private String tstHora;
    @Size(max = 100)
    @Column(name = "TST_LINK")
    private String tstLink;
    @Size(max = 60)
    @Column(name = "TST_CORREO")
    private String tstCorreo;
    @Size(max = 8000)
    @Column(name = "TST_OBSERVACION_ESTUDIANTE")
    private String tstObservacionEstudiante;
    @Size(max = 100)
    @Column(name = "TST_MATERIA")
    private String tstMateria;
    @Column(name = "TST_TUTOR")
    private Long tstTutor;
    @Size(max = 1)
    @Column(name = "TST_ASISTIO")
    private String tstAsistio;
    @Transient
    private String docente;
    @Transient
    private String tutor;
    @OneToMany(mappedBy = "tstCodigoSolicitud", fetch = FetchType.LAZY)
    private List<TutGrupoTutoria> tutGrupoTutoriaList;

    public TutSolicitudTutoria() {
    }

    public TutSolicitudTutoria(Long tstCodigo) {
        this.tstCodigo = tstCodigo;
    }

    public TutSolicitudTutoria(Long tstCodigo, String tstUsuarioCrea, Date tstFechaCrea) {
        this.tstCodigo = tstCodigo;
        this.tstUsuarioCrea = tstUsuarioCrea;
        this.tstFechaCrea = tstFechaCrea;
    }

    public Long getTstCodigo() {
        return tstCodigo;
    }

    public void setTstCodigo(Long tstCodigo) {
        this.tstCodigo = tstCodigo;
    }

    public Long getTstCodigoSolicitante() {
        return tstCodigoSolicitante;
    }

    public void setTstCodigoSolicitante(Long tstCodigoSolicitante) {
        this.tstCodigoSolicitante = tstCodigoSolicitante;
    }

    public String getTstTipoSolicitante() {
        return tstTipoSolicitante;
    }

    public void setTstTipoSolicitante(String tstTipoSolicitante) {
        this.tstTipoSolicitante = tstTipoSolicitante;
    }

    public Long getCodArea() {
        return codArea;
    }

    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }

    public Long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(Long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getTstFaseTutoria() {
        return tstFaseTutoria;
    }

    public void setTstFaseTutoria(String tstFaseTutoria) {
        this.tstFaseTutoria = tstFaseTutoria;
    }

    public Integer getTstAnioEstudiante() {
        return tstAnioEstudiante;
    }

    public void setTstAnioEstudiante(Integer tstAnioEstudiante) {
        this.tstAnioEstudiante = tstAnioEstudiante;
    }

    public String getTstTipoTutoria() {
        return tstTipoTutoria;
    }

    public void setTstTipoTutoria(String tstTipoTutoria) {
        this.tstTipoTutoria = tstTipoTutoria;
    }

    public String getTstModalidad() {
        return tstModalidad;
    }

    public void setTstModalidad(String tstModalidad) {
        this.tstModalidad = tstModalidad;
    }

    public String getTstTema() {
        return tstTema;
    }

    public void setTstTema(String tstTema) {
        this.tstTema = tstTema;
    }

    public Date getTstFechaTutoria() {
        return tstFechaTutoria;
    }

    public void setTstFechaTutoria(Date tstFechaTutoria) {
        this.tstFechaTutoria = tstFechaTutoria;
    }

    public Integer getTstDuracion() {
        return tstDuracion;
    }

    public void setTstDuracion(Integer tstDuracion) {
        this.tstDuracion = tstDuracion;
    }

    public String getTstEdificio() {
        return tstEdificio;
    }

    public void setTstEdificio(String tstEdificio) {
        this.tstEdificio = tstEdificio;
    }

    public String getTstInstalacion() {
        return tstInstalacion;
    }

    public void setTstInstalacion(String tstInstalacion) {
        this.tstInstalacion = tstInstalacion;
    }

    public String getTstObservacion() {
        return tstObservacion;
    }

    public void setTstObservacion(String tstObservacion) {
        this.tstObservacion = tstObservacion;
    }

    public String getTstTipoGrupo() {
        return tstTipoGrupo;
    }

    public void setTstTipoGrupo(String tstTipoGrupo) {
        this.tstTipoGrupo = tstTipoGrupo;
    }

    public String getTstEstadoSolicitado() {
        return tstEstadoSolicitado;
    }

    public void setTstEstadoSolicitado(String tstEstadoSolicitado) {
        this.tstEstadoSolicitado = tstEstadoSolicitado;
    }

    public String getTstAprobadoPor() {
        return tstAprobadoPor;
    }

    public void setTstAprobadoPor(String tstAprobadoPor) {
        this.tstAprobadoPor = tstAprobadoPor;
    }

    public Date getTstFechaAprobado() {
        return tstFechaAprobado;
    }

    public void setTstFechaAprobado(Date tstFechaAprobado) {
        this.tstFechaAprobado = tstFechaAprobado;
    }

    public Integer getTstAnioSolicitud() {
        return tstAnioSolicitud;
    }

    public void setTstAnioSolicitud(Integer tstAnioSolicitud) {
        this.tstAnioSolicitud = tstAnioSolicitud;
    }

    public Long getTstCodEjercicio() {
        return tstCodEjercicio;
    }

    public void setTstCodEjercicio(Long tstCodEjercicio) {
        this.tstCodEjercicio = tstCodEjercicio;
    }

    public Long getTstCodProfesor() {
        return tstCodProfesor;
    }

    public void setTstCodProfesor(Long tstCodProfesor) {
        this.tstCodProfesor = tstCodProfesor;
    }

    public Long getTstCodInstancia() {
        return tstCodInstancia;
    }

    public void setTstCodInstancia(Long tstCodInstancia) {
        this.tstCodInstancia = tstCodInstancia;
    }

    public String getTstUsuarioCrea() {
        return tstUsuarioCrea;
    }

    public void setTstUsuarioCrea(String tstUsuarioCrea) {
        this.tstUsuarioCrea = tstUsuarioCrea;
    }

    public Date getTstFechaCrea() {
        return tstFechaCrea;
    }

    public void setTstFechaCrea(Date tstFechaCrea) {
        this.tstFechaCrea = tstFechaCrea;
    }

    public Date getTstFechaModifica() {
        return tstFechaModifica;
    }

    public void setTstFechaModifica(Date tstFechaModifica) {
        this.tstFechaModifica = tstFechaModifica;
    }

    public String getTstUsuarioModifica() {
        return tstUsuarioModifica;
    }

    public void setTstUsuarioModifica(String tstUsuarioModifica) {
        this.tstUsuarioModifica = tstUsuarioModifica;
    }

    public String getTstHora() {
        return tstHora;
    }

    public void setTstHora(String tstHora) {
        this.tstHora = tstHora;
    }

    public String getTstLink() {
        return tstLink;
    }

    public void setTstLink(String tstLink) {
        this.tstLink = tstLink;
    }

    public String getTstCorreo() {
        return tstCorreo;
    }

    public void setTstCorreo(String tstCorreo) {
        this.tstCorreo = tstCorreo;
    }

    public String getTstPiso() {
        return tstPiso;
    }

    public void setTstPiso(String tstPiso) {
        this.tstPiso = tstPiso;
    }

    public String getTstObservacionEstudiante() {
        return tstObservacionEstudiante;
    }

    public void setTstObservacionEstudiante(String tstObservacionEstudiante) {
        this.tstObservacionEstudiante = tstObservacionEstudiante;
    }

    public String getTstMateria() {
        return tstMateria;
    }

    public Long getTstTutor() {
        return tstTutor;
    }

    public void setTstTutor(Long tstTutor) {
        this.tstTutor = tstTutor;
    }

    public void setTstMateria(String tstMateria) {
        this.tstMateria = tstMateria;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getinstancia() {
        String variable = "";
        if (this.tstCodInstancia != null) {
            switch (Integer.parseInt(this.tstCodInstancia.toString())) {
                case 1:
                    variable = "CASA ANDINA";
                    break;
                case 2:
                    variable = "UNIDAD DE GESTIÓN DE EDUCACIÓN VIRTUAL";
                    break;
            }
        }
        return variable;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getTstAsistio() {
        return tstAsistio;
    }

    public void setTstAsistio(String tstAsistio) {
        this.tstAsistio = tstAsistio;
    }

    
    @XmlTransient
    public List<TutGrupoTutoria> getTutGrupoTutoriaList() {
        return tutGrupoTutoriaList;
    }

    public void setTutGrupoTutoriaList(List<TutGrupoTutoria> tutGrupoTutoriaList) {
        this.tutGrupoTutoriaList = tutGrupoTutoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tstCodigo != null ? tstCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutSolicitudTutoria)) {
            return false;
        }
        TutSolicitudTutoria other = (TutSolicitudTutoria) object;
        if ((this.tstCodigo == null && other.tstCodigo != null) || (this.tstCodigo != null && !this.tstCodigo.equals(other.tstCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TutSolicitudTutoria[ tstCodigo=" + tstCodigo + " ]";
    }

}
