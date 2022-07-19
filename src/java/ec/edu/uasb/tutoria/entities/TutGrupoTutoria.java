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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "TUT_GRUPO_TUTORIA" , schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutGrupoTutoria.findAll", query = "SELECT t FROM TutGrupoTutoria t")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtCodigo", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtCodigo = :tgtCodigo")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtCodigoEstudiante", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtCodigoEstudiante = :tgtCodigoEstudiante")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtUsuarioCrea", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtUsuarioCrea = :tgtUsuarioCrea")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtFechaCrea", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtFechaCrea = :tgtFechaCrea")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtFechaModifica", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtFechaModifica = :tgtFechaModifica")
    , @NamedQuery(name = "TutGrupoTutoria.findByTgtUsuarioModifica", query = "SELECT t FROM TutGrupoTutoria t WHERE t.tgtUsuarioModifica = :tgtUsuarioModifica")})
public class TutGrupoTutoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TGT_CODIGO")
    private Long tgtCodigo;
    @Column(name = "TGT_CODIGO_ESTUDIANTE")
    private Long tgtCodigoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TGT_USUARIO_CREA")
    private String tgtUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TGT_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgtFechaCrea;
    @Column(name = "TGT_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgtFechaModifica;
    @Size(max = 25)
    @Column(name = "TGT_USUARIO_MODIFICA")
    private String tgtUsuarioModifica;
    @JoinColumn(name = "TST_CODIGO_SOLICITUD", referencedColumnName = "TST_CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TutSolicitudTutoria tstCodigoSolicitud;

    public TutGrupoTutoria() {
    }

    public TutGrupoTutoria(Long tgtCodigo) {
        this.tgtCodigo = tgtCodigo;
    }

    public TutGrupoTutoria(Long tgtCodigo, String tgtUsuarioCrea, Date tgtFechaCrea) {
        this.tgtCodigo = tgtCodigo;
        this.tgtUsuarioCrea = tgtUsuarioCrea;
        this.tgtFechaCrea = tgtFechaCrea;
    }

    public Long getTgtCodigo() {
        return tgtCodigo;
    }

    public void setTgtCodigo(Long tgtCodigo) {
        this.tgtCodigo = tgtCodigo;
    }

    public Long getTgtCodigoEstudiante() {
        return tgtCodigoEstudiante;
    }

    public void setTgtCodigoEstudiante(Long tgtCodigoEstudiante) {
        this.tgtCodigoEstudiante = tgtCodigoEstudiante;
    }

    public String getTgtUsuarioCrea() {
        return tgtUsuarioCrea;
    }

    public void setTgtUsuarioCrea(String tgtUsuarioCrea) {
        this.tgtUsuarioCrea = tgtUsuarioCrea;
    }

    public Date getTgtFechaCrea() {
        return tgtFechaCrea;
    }

    public void setTgtFechaCrea(Date tgtFechaCrea) {
        this.tgtFechaCrea = tgtFechaCrea;
    }

    public Date getTgtFechaModifica() {
        return tgtFechaModifica;
    }

    public void setTgtFechaModifica(Date tgtFechaModifica) {
        this.tgtFechaModifica = tgtFechaModifica;
    }

    public String getTgtUsuarioModifica() {
        return tgtUsuarioModifica;
    }

    public void setTgtUsuarioModifica(String tgtUsuarioModifica) {
        this.tgtUsuarioModifica = tgtUsuarioModifica;
    }

    public TutSolicitudTutoria getTstCodigoSolicitud() {
        return tstCodigoSolicitud;
    }

    public void setTstCodigoSolicitud(TutSolicitudTutoria tstCodigoSolicitud) {
        this.tstCodigoSolicitud = tstCodigoSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tgtCodigo != null ? tgtCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutGrupoTutoria)) {
            return false;
        }
        TutGrupoTutoria other = (TutGrupoTutoria) object;
        if ((this.tgtCodigo == null && other.tgtCodigo != null) || (this.tgtCodigo != null && !this.tgtCodigo.equals(other.tgtCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TutGrupoTutoria[ tgtCodigo=" + tgtCodigo + " ]";
    }
    
}
