/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david.oleas
 */
@Embeddable
public class CoordinadorProgramaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESP")
    private Long codigoEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARE_CODIGO")
    private Long areCodigo;

    public CoordinadorProgramaPK() {
    }

    public CoordinadorProgramaPK(Long codigoEsp, Long areCodigo) {
        this.codigoEsp = codigoEsp;
        this.areCodigo = areCodigo;
    }

    public Long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(Long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public Long getAreCodigo() {
        return areCodigo;
    }

    public void setAreCodigo(Long areCodigo) {
        this.areCodigo = areCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.codigoEsp != null ? this.codigoEsp.hashCode() : 0);
        hash = 47 * hash + (this.areCodigo != null ? this.areCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoordinadorProgramaPK other = (CoordinadorProgramaPK) obj;
        if (this.codigoEsp != other.codigoEsp && (this.codigoEsp == null || !this.codigoEsp.equals(other.codigoEsp))) {
            return false;
        }
        if (this.areCodigo != other.areCodigo && (this.areCodigo == null || !this.areCodigo.equals(other.areCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CoordinadorProgramaPK{" + "codigoEsp=" + codigoEsp + ", areCodigo=" + areCodigo + '}';
    }

}
