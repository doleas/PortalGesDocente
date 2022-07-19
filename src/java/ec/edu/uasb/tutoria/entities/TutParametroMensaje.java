/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TUT_PARAMETRO_MENSAJE" , schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutParametroMensaje.findAll", query = "SELECT t FROM TutParametroMensaje t")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmCodigo", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmCodigo = :tpmCodigo")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmMensaje", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmMensaje = :tpmMensaje")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmEstadoSolicitud", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmEstadoSolicitud = :tpmEstadoSolicitud")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmUsuarioCrea", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmUsuarioCrea = :tpmUsuarioCrea")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmFechaCrea", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmFechaCrea = :tpmFechaCrea")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmFechaModifica", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmFechaModifica = :tpmFechaModifica")
    , @NamedQuery(name = "TutParametroMensaje.findByTpmUsuarioModifica", query = "SELECT t FROM TutParametroMensaje t WHERE t.tpmUsuarioModifica = :tpmUsuarioModifica")})
public class TutParametroMensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPM_CODIGO")
    private Long tpmCodigo;
    @Size(max = 8000)
    @Column(name = "TPM_MENSAJE")
    private String tpmMensaje;
    @Size(max = 1)
    @Column(name = "TPM_ESTADO_SOLICITUD")
    private String tpmEstadoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TPM_USUARIO_CREA")
    private String tpmUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPM_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tpmFechaCrea;
    @Column(name = "TPM_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tpmFechaModifica;
    @Size(max = 25)
    @Column(name = "TPM_USUARIO_MODIFICA")
    private String tpmUsuarioModifica;

    public TutParametroMensaje() {
    }

    public TutParametroMensaje(Long tpmCodigo) {
        this.tpmCodigo = tpmCodigo;
    }

    public TutParametroMensaje(Long tpmCodigo, String tpmUsuarioCrea, Date tpmFechaCrea) {
        this.tpmCodigo = tpmCodigo;
        this.tpmUsuarioCrea = tpmUsuarioCrea;
        this.tpmFechaCrea = tpmFechaCrea;
    }

    public Long getTpmCodigo() {
        return tpmCodigo;
    }

    public void setTpmCodigo(Long tpmCodigo) {
        this.tpmCodigo = tpmCodigo;
    }

    public String getTpmMensaje() {
        return tpmMensaje;
    }

    public void setTpmMensaje(String tpmMensaje) {
        this.tpmMensaje = tpmMensaje;
    }

    public String getTpmEstadoSolicitud() {
        return tpmEstadoSolicitud;
    }

    public void setTpmEstadoSolicitud(String tpmEstadoSolicitud) {
        this.tpmEstadoSolicitud = tpmEstadoSolicitud;
    }

    public String getTpmUsuarioCrea() {
        return tpmUsuarioCrea;
    }

    public void setTpmUsuarioCrea(String tpmUsuarioCrea) {
        this.tpmUsuarioCrea = tpmUsuarioCrea;
    }

    public Date getTpmFechaCrea() {
        return tpmFechaCrea;
    }

    public void setTpmFechaCrea(Date tpmFechaCrea) {
        this.tpmFechaCrea = tpmFechaCrea;
    }

    public Date getTpmFechaModifica() {
        return tpmFechaModifica;
    }

    public void setTpmFechaModifica(Date tpmFechaModifica) {
        this.tpmFechaModifica = tpmFechaModifica;
    }

    public String getTpmUsuarioModifica() {
        return tpmUsuarioModifica;
    }

    public void setTpmUsuarioModifica(String tpmUsuarioModifica) {
        this.tpmUsuarioModifica = tpmUsuarioModifica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpmCodigo != null ? tpmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutParametroMensaje)) {
            return false;
        }
        TutParametroMensaje other = (TutParametroMensaje) object;
        if ((this.tpmCodigo == null && other.tpmCodigo != null) || (this.tpmCodigo != null && !this.tpmCodigo.equals(other.tpmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TutParametroMensaje[ tpmCodigo=" + tpmCodigo + " ]";
    }
    
}
