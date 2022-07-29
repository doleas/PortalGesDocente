/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.acta.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author david.oleas
 */
@Entity
@Table(name = "CEA_DETALLE_PROPMEJORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CeaDetallePropmejora.findAll", query = "SELECT c FROM CeaDetallePropmejora c")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpCodDetpropuesta", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpCodDetpropuesta = :cdpCodDetpropuesta")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpAcciones", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpAcciones = :cdpAcciones")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpResultadoEsperado", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpResultadoEsperado = :cdpResultadoEsperado")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpTemporalidad", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpTemporalidad = :cdpTemporalidad")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpSegCumplimiento", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpSegCumplimiento = :cdpSegCumplimiento")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpSegReflexion", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpSegReflexion = :cdpSegReflexion")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpFortalezas", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpFortalezas = :cdpFortalezas")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpDebilidades", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpDebilidades = :cdpDebilidades")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpUsuarioCrea", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpUsuarioCrea = :cdpUsuarioCrea")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpFechaCrea", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpFechaCrea = :cdpFechaCrea")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpFechaModifica", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpFechaModifica = :cdpFechaModifica")
    , @NamedQuery(name = "CeaDetallePropmejora.findByCdpUsuarioModifica", query = "SELECT c FROM CeaDetallePropmejora c WHERE c.cdpUsuarioModifica = :cdpUsuarioModifica")})
public class CeaDetallePropmejora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDP_COD_DETPROPUESTA")
    private Long cdpCodDetpropuesta;
    @Size(max = 8000)
    @Column(name = "CDP_ACCIONES")
    private String cdpAcciones;
    @Size(max = 8000)
    @Column(name = "CDP_RESULTADO_ESPERADO")
    private String cdpResultadoEsperado;
    @Size(max = 8000)
    @Column(name = "CDP_TEMPORALIDAD")
    private String cdpTemporalidad;
    @Size(max = 8000)
    @Column(name = "CDP_SEG_CUMPLIMIENTO")
    private String cdpSegCumplimiento;
    @Size(max = 8000)
    @Column(name = "CDP_SEG_REFLEXION")
    private String cdpSegReflexion;
    @Size(max = 8000)
    @Column(name = "CDP_FORTALEZAS")
    private String cdpFortalezas;
    @Size(max = 8000)
    @Column(name = "CDP_DEBILIDADES")
    private String cdpDebilidades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CDP_USUARIO_CREA")
    private String cdpUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDP_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFechaCrea;
    @Column(name = "CDP_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFechaModifica;
    @Size(max = 25)
    @Column(name = "CDP_USUARIO_MODIFICA")
    private String cdpUsuarioModifica;
    @JoinColumn(name = "CPM_COD_PROPUESTA", referencedColumnName = "CPM_COD_PROPUESTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private CeaPropuestaMejora cpmCodPropuesta;

    public CeaDetallePropmejora() {
    }

    public CeaDetallePropmejora(Long cdpCodDetpropuesta) {
        this.cdpCodDetpropuesta = cdpCodDetpropuesta;
    }

    public CeaDetallePropmejora(Long cdpCodDetpropuesta, String cdpUsuarioCrea, Date cdpFechaCrea) {
        this.cdpCodDetpropuesta = cdpCodDetpropuesta;
        this.cdpUsuarioCrea = cdpUsuarioCrea;
        this.cdpFechaCrea = cdpFechaCrea;
    }

    public Long getCdpCodDetpropuesta() {
        return cdpCodDetpropuesta;
    }

    public void setCdpCodDetpropuesta(Long cdpCodDetpropuesta) {
        this.cdpCodDetpropuesta = cdpCodDetpropuesta;
    }

    public String getCdpAcciones() {
        return cdpAcciones;
    }

    public void setCdpAcciones(String cdpAcciones) {
        this.cdpAcciones = cdpAcciones;
    }

    public String getCdpResultadoEsperado() {
        return cdpResultadoEsperado;
    }

    public void setCdpResultadoEsperado(String cdpResultadoEsperado) {
        this.cdpResultadoEsperado = cdpResultadoEsperado;
    }

    public String getCdpTemporalidad() {
        return cdpTemporalidad;
    }

    public void setCdpTemporalidad(String cdpTemporalidad) {
        this.cdpTemporalidad = cdpTemporalidad;
    }

    public String getCdpSegCumplimiento() {
        return cdpSegCumplimiento;
    }

    public void setCdpSegCumplimiento(String cdpSegCumplimiento) {
        this.cdpSegCumplimiento = cdpSegCumplimiento;
    }

    public String getCdpSegReflexion() {
        return cdpSegReflexion;
    }

    public void setCdpSegReflexion(String cdpSegReflexion) {
        this.cdpSegReflexion = cdpSegReflexion;
    }

    public String getCdpFortalezas() {
        return cdpFortalezas;
    }

    public void setCdpFortalezas(String cdpFortalezas) {
        this.cdpFortalezas = cdpFortalezas;
    }

    public String getCdpDebilidades() {
        return cdpDebilidades;
    }

    public void setCdpDebilidades(String cdpDebilidades) {
        this.cdpDebilidades = cdpDebilidades;
    }

    public String getCdpUsuarioCrea() {
        return cdpUsuarioCrea;
    }

    public void setCdpUsuarioCrea(String cdpUsuarioCrea) {
        this.cdpUsuarioCrea = cdpUsuarioCrea;
    }

    public Date getCdpFechaCrea() {
        return cdpFechaCrea;
    }

    public void setCdpFechaCrea(Date cdpFechaCrea) {
        this.cdpFechaCrea = cdpFechaCrea;
    }

    public Date getCdpFechaModifica() {
        return cdpFechaModifica;
    }

    public void setCdpFechaModifica(Date cdpFechaModifica) {
        this.cdpFechaModifica = cdpFechaModifica;
    }

    public String getCdpUsuarioModifica() {
        return cdpUsuarioModifica;
    }

    public void setCdpUsuarioModifica(String cdpUsuarioModifica) {
        this.cdpUsuarioModifica = cdpUsuarioModifica;
    }

    public CeaPropuestaMejora getCpmCodPropuesta() {
        return cpmCodPropuesta;
    }

    public void setCpmCodPropuesta(CeaPropuestaMejora cpmCodPropuesta) {
        this.cpmCodPropuesta = cpmCodPropuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdpCodDetpropuesta != null ? cdpCodDetpropuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CeaDetallePropmejora)) {
            return false;
        }
        CeaDetallePropmejora other = (CeaDetallePropmejora) object;
        if ((this.cdpCodDetpropuesta == null && other.cdpCodDetpropuesta != null) || (this.cdpCodDetpropuesta != null && !this.cdpCodDetpropuesta.equals(other.cdpCodDetpropuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.sisevaluacion.acta.entities.CeaDetallePropmejora[ cdpCodDetpropuesta=" + cdpCodDetpropuesta + " ]";
    }
    
}
