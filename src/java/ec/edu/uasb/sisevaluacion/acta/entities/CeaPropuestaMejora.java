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
@Table(name = "CEA_PROPUESTA_MEJORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CeaPropuestaMejora.findAll", query = "SELECT c FROM CeaPropuestaMejora c")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmCodPropuesta", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmCodPropuesta = :cpmCodPropuesta")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCodArea", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.codArea = :codArea")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCodProg", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.codProg = :codProg")
    , @NamedQuery(name = "CeaPropuestaMejora.findByAnio", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.anio = :anio")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCodEjercicio", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.codEjercicio = :codEjercicio")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmFechaElaboracion", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmFechaElaboracion = :cpmFechaElaboracion")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmResponsableSeguimiento", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmResponsableSeguimiento = :cpmResponsableSeguimiento")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmFechaSeguimiento", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmFechaSeguimiento = :cpmFechaSeguimiento")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmUsuarioCrea", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmUsuarioCrea = :cpmUsuarioCrea")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmEstado", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmEstado = :cpmEstado")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmFechaCrea", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmFechaCrea = :cpmFechaCrea")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmFechaModifica", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmFechaModifica = :cpmFechaModifica")
    , @NamedQuery(name = "CeaPropuestaMejora.findByCpmUsuarioModifica", query = "SELECT c FROM CeaPropuestaMejora c WHERE c.cpmUsuarioModifica = :cpmUsuarioModifica")})
public class CeaPropuestaMejora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPM_COD_PROPUESTA")
    private Long cpmCodPropuesta;
    @Column(name = "COD_AREA")
    private Long codArea;
    @Column(name = "COD_PROG")
    private Long codProg;
    @Column(name = "ANIO")
    private Long anio;
    @Size(max = 100)
    @Column(name = "COD_EJERCICIO")
    private String codEjercicio;
    @Column(name = "CPM_FECHA_ELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpmFechaElaboracion;
    @Size(max = 25)
    @Column(name = "CPM_RESPONSABLE_SEGUIMIENTO")
    private String cpmResponsableSeguimiento;
    @Column(name = "CPM_FECHA_SEGUIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpmFechaSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CPM_USUARIO_CREA")
    private String cpmUsuarioCrea;
    @Size(max = 1)
    @Column(name = "CPM_ESTADO")
    private String cpmEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPM_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpmFechaCrea;
    @Column(name = "CPM_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpmFechaModifica;
    @Size(max = 25)
    @Column(name = "CPM_USUARIO_MODIFICA")
    private String cpmUsuarioModifica;
    @OneToMany(mappedBy = "cpmCodPropuesta", fetch = FetchType.LAZY)
    private List<CeaDetallePropmejora> ceaDetallePropmejoraList;

    public CeaPropuestaMejora() {
    }

    public CeaPropuestaMejora(Long cpmCodPropuesta) {
        this.cpmCodPropuesta = cpmCodPropuesta;
    }

    public CeaPropuestaMejora(Long cpmCodPropuesta, String cpmUsuarioCrea, Date cpmFechaCrea) {
        this.cpmCodPropuesta = cpmCodPropuesta;
        this.cpmUsuarioCrea = cpmUsuarioCrea;
        this.cpmFechaCrea = cpmFechaCrea;
    }

    public Long getCpmCodPropuesta() {
        return cpmCodPropuesta;
    }

    public void setCpmCodPropuesta(Long cpmCodPropuesta) {
        this.cpmCodPropuesta = cpmCodPropuesta;
    }

    public Long getCodArea() {
        return codArea;
    }

    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }

    public Long getCodProg() {
        return codProg;
    }

    public void setCodProg(Long codProg) {
        this.codProg = codProg;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public String getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(String codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public Date getCpmFechaElaboracion() {
        return cpmFechaElaboracion;
    }

    public void setCpmFechaElaboracion(Date cpmFechaElaboracion) {
        this.cpmFechaElaboracion = cpmFechaElaboracion;
    }

    public String getCpmResponsableSeguimiento() {
        return cpmResponsableSeguimiento;
    }

    public void setCpmResponsableSeguimiento(String cpmResponsableSeguimiento) {
        this.cpmResponsableSeguimiento = cpmResponsableSeguimiento;
    }

    public Date getCpmFechaSeguimiento() {
        return cpmFechaSeguimiento;
    }

    public void setCpmFechaSeguimiento(Date cpmFechaSeguimiento) {
        this.cpmFechaSeguimiento = cpmFechaSeguimiento;
    }

    public String getCpmUsuarioCrea() {
        return cpmUsuarioCrea;
    }

    public void setCpmUsuarioCrea(String cpmUsuarioCrea) {
        this.cpmUsuarioCrea = cpmUsuarioCrea;
    }

    public String getCpmEstado() {
        return cpmEstado;
    }

    public void setCpmEstado(String cpmEstado) {
        this.cpmEstado = cpmEstado;
    }

    public Date getCpmFechaCrea() {
        return cpmFechaCrea;
    }

    public void setCpmFechaCrea(Date cpmFechaCrea) {
        this.cpmFechaCrea = cpmFechaCrea;
    }

    public Date getCpmFechaModifica() {
        return cpmFechaModifica;
    }

    public void setCpmFechaModifica(Date cpmFechaModifica) {
        this.cpmFechaModifica = cpmFechaModifica;
    }

    public String getCpmUsuarioModifica() {
        return cpmUsuarioModifica;
    }

    public void setCpmUsuarioModifica(String cpmUsuarioModifica) {
        this.cpmUsuarioModifica = cpmUsuarioModifica;
    }

    @XmlTransient
    public List<CeaDetallePropmejora> getCeaDetallePropmejoraList() {
        return ceaDetallePropmejoraList;
    }

    public void setCeaDetallePropmejoraList(List<CeaDetallePropmejora> ceaDetallePropmejoraList) {
        this.ceaDetallePropmejoraList = ceaDetallePropmejoraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpmCodPropuesta != null ? cpmCodPropuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CeaPropuestaMejora)) {
            return false;
        }
        CeaPropuestaMejora other = (CeaPropuestaMejora) object;
        if ((this.cpmCodPropuesta == null && other.cpmCodPropuesta != null) || (this.cpmCodPropuesta != null && !this.cpmCodPropuesta.equals(other.cpmCodPropuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.sisevaluacion.acta.entities.CeaPropuestaMejora[ cpmCodPropuesta=" + cpmCodPropuesta + " ]";
    }
    
}
