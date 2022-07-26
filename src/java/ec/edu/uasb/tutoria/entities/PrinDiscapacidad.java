/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "PRIN_DISCAPACIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrinDiscapacidad.findAll", query = "SELECT p FROM PrinDiscapacidad p")
    , @NamedQuery(name = "PrinDiscapacidad.findByDisCodigo", query = "SELECT p FROM PrinDiscapacidad p WHERE p.disCodigo = :disCodigo")
    , @NamedQuery(name = "PrinDiscapacidad.findByDisNombre", query = "SELECT p FROM PrinDiscapacidad p WHERE p.disNombre = :disNombre")})
public class PrinDiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIS_CODIGO")
    private Short disCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DIS_NOMBRE")
    private String disNombre;
    @OneToMany(mappedBy = "disCodigo")
    private List<PrinPersona> prinPersonaList;

    public PrinDiscapacidad() {
    }

    public PrinDiscapacidad(Short disCodigo) {
        this.disCodigo = disCodigo;
    }

    public PrinDiscapacidad(Short disCodigo, String disNombre) {
        this.disCodigo = disCodigo;
        this.disNombre = disNombre;
    }

    public Short getDisCodigo() {
        return disCodigo;
    }

    public void setDisCodigo(Short disCodigo) {
        this.disCodigo = disCodigo;
    }

    public String getDisNombre() {
        return disNombre;
    }

    public void setDisNombre(String disNombre) {
        this.disNombre = disNombre;
    }

    @XmlTransient
    public List<PrinPersona> getPrinPersonaList() {
        return prinPersonaList;
    }

    public void setPrinPersonaList(List<PrinPersona> prinPersonaList) {
        this.prinPersonaList = prinPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disCodigo != null ? disCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrinDiscapacidad)) {
            return false;
        }
        PrinDiscapacidad other = (PrinDiscapacidad) object;
        if ((this.disCodigo == null && other.disCodigo != null) || (this.disCodigo != null && !this.disCodigo.equals(other.disCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.PrinDiscapacidad[ disCodigo=" + disCodigo + " ]";
    }
    
}
