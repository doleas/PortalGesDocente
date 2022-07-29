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
@Table(name = "CEA_FORTALEZAS_DEBILIDADES", schema = "EVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CeaFortalezasDebilidades.findAll", query = "SELECT c FROM CeaFortalezasDebilidades c")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdCodFortdeb", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdCodFortdeb = :cfdCodFortdeb")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdTipo", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdTipo = :cfdTipo")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdDescripcion", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdDescripcion = :cfdDescripcion")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdUsuarioCrea", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdUsuarioCrea = :cfdUsuarioCrea")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdFechaCrea", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdFechaCrea = :cfdFechaCrea")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdFechaModifica", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdFechaModifica = :cfdFechaModifica")
    , @NamedQuery(name = "CeaFortalezasDebilidades.findByCfdUsuarioModifica", query = "SELECT c FROM CeaFortalezasDebilidades c WHERE c.cfdUsuarioModifica = :cfdUsuarioModifica")})
public class CeaFortalezasDebilidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CFD_COD_FORTDEB")
    private Long cfdCodFortdeb;
    @Size(max = 1)
    @Column(name = "CFD_TIPO")
    private String cfdTipo;
    @Size(max = 200)
    @Column(name = "CFD_DESCRIPCION")
    private String cfdDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CFD_USUARIO_CREA")
    private String cfdUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CFD_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfdFechaCrea;
    @Column(name = "CFD_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfdFechaModifica;
    @Size(max = 25)
    @Column(name = "CFD_USUARIO_MODIFICA")
    private String cfdUsuarioModifica;
    @JoinColumn(name = "CEA_COD_ACTA", referencedColumnName = "CEA_COD_ACTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private CeaActa ceaCodActa;

    public CeaFortalezasDebilidades() {
    }

    public CeaFortalezasDebilidades(Long cfdCodFortdeb) {
        this.cfdCodFortdeb = cfdCodFortdeb;
    }

    public CeaFortalezasDebilidades(Long cfdCodFortdeb, String cfdUsuarioCrea, Date cfdFechaCrea) {
        this.cfdCodFortdeb = cfdCodFortdeb;
        this.cfdUsuarioCrea = cfdUsuarioCrea;
        this.cfdFechaCrea = cfdFechaCrea;
    }

    public Long getCfdCodFortdeb() {
        return cfdCodFortdeb;
    }

    public void setCfdCodFortdeb(Long cfdCodFortdeb) {
        this.cfdCodFortdeb = cfdCodFortdeb;
    }

    public String getCfdTipo() {
        return cfdTipo;
    }

    public void setCfdTipo(String cfdTipo) {
        this.cfdTipo = cfdTipo;
    }

    public String getCfdDescripcion() {
        return cfdDescripcion;
    }

    public void setCfdDescripcion(String cfdDescripcion) {
        this.cfdDescripcion = cfdDescripcion;
    }

    public String getCfdUsuarioCrea() {
        return cfdUsuarioCrea;
    }

    public void setCfdUsuarioCrea(String cfdUsuarioCrea) {
        this.cfdUsuarioCrea = cfdUsuarioCrea;
    }

    public Date getCfdFechaCrea() {
        return cfdFechaCrea;
    }

    public void setCfdFechaCrea(Date cfdFechaCrea) {
        this.cfdFechaCrea = cfdFechaCrea;
    }

    public Date getCfdFechaModifica() {
        return cfdFechaModifica;
    }

    public void setCfdFechaModifica(Date cfdFechaModifica) {
        this.cfdFechaModifica = cfdFechaModifica;
    }

    public String getCfdUsuarioModifica() {
        return cfdUsuarioModifica;
    }

    public void setCfdUsuarioModifica(String cfdUsuarioModifica) {
        this.cfdUsuarioModifica = cfdUsuarioModifica;
    }

    public CeaActa getCeaCodActa() {
        return ceaCodActa;
    }

    public void setCeaCodActa(CeaActa ceaCodActa) {
        this.ceaCodActa = ceaCodActa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfdCodFortdeb != null ? cfdCodFortdeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CeaFortalezasDebilidades)) {
            return false;
        }
        CeaFortalezasDebilidades other = (CeaFortalezasDebilidades) object;
        if ((this.cfdCodFortdeb == null && other.cfdCodFortdeb != null) || (this.cfdCodFortdeb != null && !this.cfdCodFortdeb.equals(other.cfdCodFortdeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.sisevaluacion.acta.entities.CeaFortalezasDebilidades[ cfdCodFortdeb=" + cfdCodFortdeb + " ]";
    }
    
}
