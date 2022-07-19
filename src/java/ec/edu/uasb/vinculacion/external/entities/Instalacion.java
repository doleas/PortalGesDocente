/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author xavier.duque
 */
@Entity
public class Instalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "EDIF_CODIGO")
    private Long edifCodigo;
    @Basic(optional = false)

    @Column(name = "EDIF_DESC")
    private String edifDesc;

    @OneToMany(mappedBy = "EdifCodigo")
    private Collection<InsAula> inasAulaCollection;

    public Instalacion() {
    }

    public Instalacion(Long edifCodigo) {
        this.edifCodigo = edifCodigo;

    }

    public Long getEdifCodigo() {
        return edifCodigo;
    }

    public void setEdifCodigo(Long edifCodigo) {
        this.edifCodigo = edifCodigo;
    }

    public String getEdifDesc() {
        return edifDesc;
    }

    public void setEdifDesc(String edifDesc) {
        this.edifDesc = edifDesc;
    }  

    public Collection<InsAula> getInasAulaCollection() {
        return inasAulaCollection;
    }

    public void setInasAulaCollection(Collection<InsAula> inasAulaCollection) {
        this.inasAulaCollection = inasAulaCollection;
    }

  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.edifCodigo);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instalacion other = (Instalacion) obj;
        if (!Objects.equals(this.edifCodigo, other.edifCodigo)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Instalacion{" + "edifCodigo=" + edifCodigo + ", edifDesc=" + edifDesc + '}';
    }

}
