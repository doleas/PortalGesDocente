/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marjorie.fiallos
 */
@Embeddable
public class EstudianteUltimamatriculaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MATRICULA")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_ESP")
    private String codigoEsp;

    public EstudianteUltimamatriculaPK() {
    }

    public EstudianteUltimamatriculaPK(String matricula, String codigoEsp) {
        this.matricula = matricula;
        this.codigoEsp = codigoEsp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(String codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        hash += (codigoEsp != null ? codigoEsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteUltimamatriculaPK)) {
            return false;
        }
        EstudianteUltimamatriculaPK other = (EstudianteUltimamatriculaPK) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.codigoEsp == null && other.codigoEsp != null) || (this.codigoEsp != null && !this.codigoEsp.equals(other.codigoEsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.EstudianteUltimamatriculaPK[ matricula=" + matricula + ", codigoEsp=" + codigoEsp + " ]";
    }
    
}
