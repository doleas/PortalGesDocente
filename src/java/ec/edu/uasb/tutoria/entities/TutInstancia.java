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
@Table(name = "TUT_INSTANCIA" ,schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutInstancia.findAll", query = "SELECT t FROM TutInstancia t")
    , @NamedQuery(name = "TutInstancia.findByTinCodigo", query = "SELECT t FROM TutInstancia t WHERE t.tinCodigo = :tinCodigo")
    , @NamedQuery(name = "TutInstancia.findByDepCodigo", query = "SELECT t FROM TutInstancia t WHERE t.depCodigo = :depCodigo")
    , @NamedQuery(name = "TutInstancia.findByTinNombre", query = "SELECT t FROM TutInstancia t WHERE t.tinNombre = :tinNombre")
    , @NamedQuery(name = "TutInstancia.findByTinDescripcion", query = "SELECT t FROM TutInstancia t WHERE t.tinDescripcion = :tinDescripcion")
    , @NamedQuery(name = "TutInstancia.findByTinResponsale", query = "SELECT t FROM TutInstancia t WHERE t.tinResponsale = :tinResponsale")
    , @NamedQuery(name = "TutInstancia.findByTinEmail", query = "SELECT t FROM TutInstancia t WHERE t.tinEmail = :tinEmail")
    , @NamedQuery(name = "TutInstancia.findByTinTipo", query = "SELECT t FROM TutInstancia t WHERE t.tinTipo = :tinTipo")
    , @NamedQuery(name = "TutInstancia.findByTinEstado", query = "SELECT t FROM TutInstancia t WHERE t.tinEstado = :tinEstado")
    , @NamedQuery(name = "TutInstancia.findByTinUsuarioCrea", query = "SELECT t FROM TutInstancia t WHERE t.tinUsuarioCrea = :tinUsuarioCrea")
    , @NamedQuery(name = "TutInstancia.findByTinFechaCrea", query = "SELECT t FROM TutInstancia t WHERE t.tinFechaCrea = :tinFechaCrea")
    , @NamedQuery(name = "TutInstancia.findByTinFechaModifica", query = "SELECT t FROM TutInstancia t WHERE t.tinFechaModifica = :tinFechaModifica")
    , @NamedQuery(name = "TutInstancia.findByTinUsuarioModifica", query = "SELECT t FROM TutInstancia t WHERE t.tinUsuarioModifica = :tinUsuarioModifica")})
public class TutInstancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIN_CODIGO")
    private Long tinCodigo;
    @Column(name = "DEP_CODIGO")
    private Long depCodigo;
    @Size(max = 100)
    @Column(name = "TIN_NOMBRE")
    private String tinNombre;
    @Size(max = 200)
    @Column(name = "TIN_DESCRIPCION")
    private String tinDescripcion;
    @Size(max = 100)
    @Column(name = "TIN_RESPONSALE")
    private String tinResponsale;
    @Size(max = 60)
    @Column(name = "TIN_EMAIL")
    private String tinEmail;
    @Size(max = 1)
    @Column(name = "TIN_TIPO")
    private String tinTipo;
    @Size(max = 1)
    @Column(name = "TIN_ESTADO")
    private String tinEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIN_USUARIO_CREA")
    private String tinUsuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIN_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tinFechaCrea;
    @Column(name = "TIN_FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tinFechaModifica;
    @Size(max = 25)
    @Column(name = "TIN_USUARIO_MODIFICA")
    private String tinUsuarioModifica;

    public TutInstancia() {
    }

    public TutInstancia(Long tinCodigo) {
        this.tinCodigo = tinCodigo;
    }

    public TutInstancia(Long tinCodigo, String tinUsuarioCrea, Date tinFechaCrea) {
        this.tinCodigo = tinCodigo;
        this.tinUsuarioCrea = tinUsuarioCrea;
        this.tinFechaCrea = tinFechaCrea;
    }

    public Long getTinCodigo() {
        return tinCodigo;
    }

    public void setTinCodigo(Long tinCodigo) {
        this.tinCodigo = tinCodigo;
    }

    public Long getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(Long depCodigo) {
        this.depCodigo = depCodigo;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinDescripcion() {
        return tinDescripcion;
    }

    public void setTinDescripcion(String tinDescripcion) {
        this.tinDescripcion = tinDescripcion;
    }

    public String getTinResponsale() {
        return tinResponsale;
    }

    public void setTinResponsale(String tinResponsale) {
        this.tinResponsale = tinResponsale;
    }

    public String getTinEmail() {
        return tinEmail;
    }

    public void setTinEmail(String tinEmail) {
        this.tinEmail = tinEmail;
    }

    public String getTinTipo() {
        return tinTipo;
    }

    public void setTinTipo(String tinTipo) {
        this.tinTipo = tinTipo;
    }

    public String getTinEstado() {
        return tinEstado;
    }

    public void setTinEstado(String tinEstado) {
        this.tinEstado = tinEstado;
    }

    public String getTinUsuarioCrea() {
        return tinUsuarioCrea;
    }

    public void setTinUsuarioCrea(String tinUsuarioCrea) {
        this.tinUsuarioCrea = tinUsuarioCrea;
    }

    public Date getTinFechaCrea() {
        return tinFechaCrea;
    }

    public void setTinFechaCrea(Date tinFechaCrea) {
        this.tinFechaCrea = tinFechaCrea;
    }

    public Date getTinFechaModifica() {
        return tinFechaModifica;
    }

    public void setTinFechaModifica(Date tinFechaModifica) {
        this.tinFechaModifica = tinFechaModifica;
    }

    public String getTinUsuarioModifica() {
        return tinUsuarioModifica;
    }

    public void setTinUsuarioModifica(String tinUsuarioModifica) {
        this.tinUsuarioModifica = tinUsuarioModifica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tinCodigo != null ? tinCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutInstancia)) {
            return false;
        }
        TutInstancia other = (TutInstancia) object;
        if ((this.tinCodigo == null && other.tinCodigo != null) || (this.tinCodigo != null && !this.tinCodigo.equals(other.tinCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TutInstancia[ tinCodigo=" + tinCodigo + " ]";
    }
    
}
