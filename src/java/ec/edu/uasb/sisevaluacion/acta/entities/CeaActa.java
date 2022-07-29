/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.acta.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david.oleas
 */
@Entity
@Table(name = "CEA_ACTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CeaActa.findAll", query = "SELECT c FROM CeaActa c")
    , @NamedQuery(name = "CeaActa.findByCeaCodActa", query = "SELECT c FROM CeaActa c WHERE c.ceaCodActa = :ceaCodActa")
    , @NamedQuery(name = "CeaActa.findByCodArea", query = "SELECT c FROM CeaActa c WHERE c.codArea = :codArea")
    , @NamedQuery(name = "CeaActa.findByCodigoProg", query = "SELECT c FROM CeaActa c WHERE c.codigoProg = :codigoProg")
    , @NamedQuery(name = "CeaActa.findByAnio", query = "SELECT c FROM CeaActa c WHERE c.anio = :anio")
    , @NamedQuery(name = "CeaActa.findByCodEjercicio", query = "SELECT c FROM CeaActa c WHERE c.codEjercicio = :codEjercicio")
    , @NamedQuery(name = "CeaActa.findByCodTrimestre", query = "SELECT c FROM CeaActa c WHERE c.codTrimestre = :codTrimestre")
    , @NamedQuery(name = "CeaActa.findByCeaFechaReunion", query = "SELECT c FROM CeaActa c WHERE c.ceaFechaReunion = :ceaFechaReunion")
    , @NamedQuery(name = "CeaActa.findByCeaParticipantes", query = "SELECT c FROM CeaActa c WHERE c.ceaParticipantes = :ceaParticipantes")
    , @NamedQuery(name = "CeaActa.findByCeaHoraInicio", query = "SELECT c FROM CeaActa c WHERE c.ceaHoraInicio = :ceaHoraInicio")
    , @NamedQuery(name = "CeaActa.findByCeaHoraFin", query = "SELECT c FROM CeaActa c WHERE c.ceaHoraFin = :ceaHoraFin")
    , @NamedQuery(name = "CeaActa.findByCeaOrdedAspectosAcad", query = "SELECT c FROM CeaActa c WHERE c.ceaOrdedAspectosAcad = :ceaOrdedAspectosAcad")
    , @NamedQuery(name = "CeaActa.findByCeaOrdedSolicitudesEst", query = "SELECT c FROM CeaActa c WHERE c.ceaOrdedSolicitudesEst = :ceaOrdedSolicitudesEst")
    , @NamedQuery(name = "CeaActa.findByCeaOrdedAspectosAdm", query = "SELECT c FROM CeaActa c WHERE c.ceaOrdedAspectosAdm = :ceaOrdedAspectosAdm")
    , @NamedQuery(name = "CeaActa.findByCeaResolucionComite", query = "SELECT c FROM CeaActa c WHERE c.ceaResolucionComite = :ceaResolucionComite")
    , @NamedQuery(name = "CeaActa.findByCeaFirmado", query = "SELECT c FROM CeaActa c WHERE c.ceaFirmado = :ceaFirmado")
    , @NamedQuery(name = "CeaActa.findByCeaFirmadopor", query = "SELECT c FROM CeaActa c WHERE c.ceaFirmadopor = :ceaFirmadopor")
    , @NamedQuery(name = "CeaActa.findByCeaFechaFirma", query = "SELECT c FROM CeaActa c WHERE c.ceaFechaFirma = :ceaFechaFirma")
    , @NamedQuery(name = "CeaActa.findByCeaEstado", query = "SELECT c FROM CeaActa c WHERE c.ceaEstado = :ceaEstado")
    , @NamedQuery(name = "CeaActa.findByCeaUsuarioCrea", query = "SELECT c FROM CeaActa c WHERE c.ceaUsuarioCrea = :ceaUsuarioCrea")
    , @NamedQuery(name = "CeaActa.findByCeaFechaCrea", query = "SELECT c FROM CeaActa c WHERE c.ceaFechaCrea = :ceaFechaCrea")
    , @NamedQuery(name = "CeaActa.findByCeaFechaModifica", query = "SELECT c FROM CeaActa c WHERE c.ceaFechaModifica = :ceaFechaModifica")
    , @NamedQuery(name = "CeaActa.findByCeaUsuarioModifica", query = "SELECT c FROM CeaActa c WHERE c.ceaUsuarioModifica = :ceaUsuarioModifica")})
public class CeaActa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEA_COD_ACTA")
    private Long ceaCodActa;
    @Column(name = "COD_AREA")
    private Long codArea;
    @Column(name = "CODIGO_PROG")
    private Long codigoProg;
    @Column(name = "ANIO")
    private Long anio;
    @Column(name = "COD_EJERCICIO")
    private Long codEjercicio;
    @Column(name = "COD_TRIMESTRE")
    private Long codTrimestre;
    @Column(name = "CEA_FECHA_REUNION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceaFechaReunion;
    @Size(max = 8000)
    @Column(name = "CEA_PARTICIPANTES")
    private String ceaParticipantes;
    @Size(max = 16)
    @Column(name = "CEA_HORA_INICIO")
    private String ceaHoraInicio;
    @Size(max = 16)
    @Column(name = "CEA_HORA_FIN")
    private String ceaHoraFin;
    @Size(max = 8000)
    @Column(name = "CEA_ORDED_ASPECTOS_ACAD")
    private String ceaOrdedAspectosAcad;
    @Size(max = 8000)
    @Column(name = "CEA_ORDED_SOLICITUDES_EST")
    private String ceaOrdedSolicitudesEst;
    @Size(max = 8000)
    @Column(name = "CEA_ORDED_ASPECTOS_ADM")
    private String ceaOrdedAspectosAdm;
    @Size(max = 8000)
    @Column(name = "CEA_RESOLUCION_COMITE")
    private String ceaResolucionComite;
    @Size(max = 1)
    @Column(name = "CEA_FIRMADO")
    private String ceaFirmado;
    @Size(max = 25)
    @Column(name = "CEA_FIRMADOPOR")
    private String ceaFirmadopor;
    @Column(name = "CEA_FECHA_FIRMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceaFechaFirma;
    @Size(max = 1)
    @Column(name = "CEA_ESTADO")
    private String ceaEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CEA_USUARIO_CREA")
    private String ceaUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEA_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceaFechaCrea;
    @Column(name = "CEA_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceaFechaModifica;
    @Size(max = 25)
    @Column(name = "CEA_USUARIO_MODIFICA")
    private String ceaUsuarioModifica;
    @OneToMany(mappedBy = "ceaCodActa", fetch = FetchType.LAZY)
    private List<CeaFortalezasDebilidades> ceaFortalezasDebilidadesList;

    public CeaActa() {
    }

    public CeaActa(Long ceaCodActa) {
        this.ceaCodActa = ceaCodActa;
    }

    public CeaActa(Long ceaCodActa, String ceaUsuarioCrea, Date ceaFechaCrea) {
        this.ceaCodActa = ceaCodActa;
        this.ceaUsuarioCrea = ceaUsuarioCrea;
        this.ceaFechaCrea = ceaFechaCrea;
    }

    public Long getCeaCodActa() {
        return ceaCodActa;
    }

    public void setCeaCodActa(Long ceaCodActa) {
        this.ceaCodActa = ceaCodActa;
    }

    public Long getCodArea() {
        return codArea;
    }

    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }

    public Long getCodigoProg() {
        return codigoProg;
    }

    public void setCodigoProg(Long codigoProg) {
        this.codigoProg = codigoProg;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(Long codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public Long getCodTrimestre() {
        return codTrimestre;
    }

    public void setCodTrimestre(Long codTrimestre) {
        this.codTrimestre = codTrimestre;
    }

    public Date getCeaFechaReunion() {
        return ceaFechaReunion;
    }

    public void setCeaFechaReunion(Date ceaFechaReunion) {
        this.ceaFechaReunion = ceaFechaReunion;
    }

    public String getCeaParticipantes() {
        return ceaParticipantes;
    }

    public void setCeaParticipantes(String ceaParticipantes) {
        this.ceaParticipantes = ceaParticipantes;
    }

    public String getCeaHoraInicio() {
        return ceaHoraInicio;
    }

    public void setCeaHoraInicio(String ceaHoraInicio) {
        this.ceaHoraInicio = ceaHoraInicio;
    }

    public String getCeaHoraFin() {
        return ceaHoraFin;
    }

    public void setCeaHoraFin(String ceaHoraFin) {
        this.ceaHoraFin = ceaHoraFin;
    }

    public String getCeaOrdedAspectosAcad() {
        return ceaOrdedAspectosAcad;
    }

    public void setCeaOrdedAspectosAcad(String ceaOrdedAspectosAcad) {
        this.ceaOrdedAspectosAcad = ceaOrdedAspectosAcad;
    }

    public String getCeaOrdedSolicitudesEst() {
        return ceaOrdedSolicitudesEst;
    }

    public void setCeaOrdedSolicitudesEst(String ceaOrdedSolicitudesEst) {
        this.ceaOrdedSolicitudesEst = ceaOrdedSolicitudesEst;
    }

    public String getCeaOrdedAspectosAdm() {
        return ceaOrdedAspectosAdm;
    }

    public void setCeaOrdedAspectosAdm(String ceaOrdedAspectosAdm) {
        this.ceaOrdedAspectosAdm = ceaOrdedAspectosAdm;
    }

    public String getCeaResolucionComite() {
        return ceaResolucionComite;
    }

    public void setCeaResolucionComite(String ceaResolucionComite) {
        this.ceaResolucionComite = ceaResolucionComite;
    }

    public String getCeaFirmado() {
        return ceaFirmado;
    }

    public void setCeaFirmado(String ceaFirmado) {
        this.ceaFirmado = ceaFirmado;
    }

    public String getCeaFirmadopor() {
        return ceaFirmadopor;
    }

    public void setCeaFirmadopor(String ceaFirmadopor) {
        this.ceaFirmadopor = ceaFirmadopor;
    }

    public Date getCeaFechaFirma() {
        return ceaFechaFirma;
    }

    public void setCeaFechaFirma(Date ceaFechaFirma) {
        this.ceaFechaFirma = ceaFechaFirma;
    }

    public String getCeaEstado() {
        return ceaEstado;
    }

    public void setCeaEstado(String ceaEstado) {
        this.ceaEstado = ceaEstado;
    }

    public String getCeaUsuarioCrea() {
        return ceaUsuarioCrea;
    }

    public void setCeaUsuarioCrea(String ceaUsuarioCrea) {
        this.ceaUsuarioCrea = ceaUsuarioCrea;
    }

    public Date getCeaFechaCrea() {
        return ceaFechaCrea;
    }

    public void setCeaFechaCrea(Date ceaFechaCrea) {
        this.ceaFechaCrea = ceaFechaCrea;
    }

    public Date getCeaFechaModifica() {
        return ceaFechaModifica;
    }

    public void setCeaFechaModifica(Date ceaFechaModifica) {
        this.ceaFechaModifica = ceaFechaModifica;
    }

    public String getCeaUsuarioModifica() {
        return ceaUsuarioModifica;
    }

    public void setCeaUsuarioModifica(String ceaUsuarioModifica) {
        this.ceaUsuarioModifica = ceaUsuarioModifica;
    }

    @XmlTransient
    public List<CeaFortalezasDebilidades> getCeaFortalezasDebilidadesList() {
        return ceaFortalezasDebilidadesList;
    }

    public void setCeaFortalezasDebilidadesList(List<CeaFortalezasDebilidades> ceaFortalezasDebilidadesList) {
        this.ceaFortalezasDebilidadesList = ceaFortalezasDebilidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceaCodActa != null ? ceaCodActa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CeaActa)) {
            return false;
        }
        CeaActa other = (CeaActa) object;
        if ((this.ceaCodActa == null && other.ceaCodActa != null) || (this.ceaCodActa != null && !this.ceaCodActa.equals(other.ceaCodActa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.sisevaluacion.acta.entities.CeaActa[ ceaCodActa=" + ceaCodActa + " ]";
    }
    
    @Override
    public CeaActa clone() throws CloneNotSupportedException {
        return (CeaActa) super.clone();
    }
    
}
