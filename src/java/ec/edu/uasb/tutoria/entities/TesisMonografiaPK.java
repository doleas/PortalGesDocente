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
public class TesisMonografiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESP")
    private long codigoEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_NIVEACAD")
    private long codigoNiveacad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTUDIANTE")
    private long codEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MATRICULA")
    private long matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROFESOR")
    private long codProfesor;

    public TesisMonografiaPK() {
    }

    public TesisMonografiaPK(long codigoEsp, long codigoNiveacad, long codEstudiante, long matricula, String tipo, long codProfesor) {
        this.codigoEsp = codigoEsp;
        this.codigoNiveacad = codigoNiveacad;
        this.codEstudiante = codEstudiante;
        this.matricula = matricula;
        this.tipo = tipo;
        this.codProfesor = codProfesor;
    }

    public long getCodigoEsp() {
        return codigoEsp;
    }

    public void setCodigoEsp(long codigoEsp) {
        this.codigoEsp = codigoEsp;
    }

    public long getCodigoNiveacad() {
        return codigoNiveacad;
    }

    public void setCodigoNiveacad(long codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public long getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(long codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(long codProfesor) {
        this.codProfesor = codProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEsp;
        hash += (int) codigoNiveacad;
        hash += (int) codEstudiante;
        hash += (int) matricula;
        hash += (tipo != null ? tipo.hashCode() : 0);
        hash += (int) codProfesor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisMonografiaPK)) {
            return false;
        }
        TesisMonografiaPK other = (TesisMonografiaPK) object;
        if (this.codigoEsp != other.codigoEsp) {
            return false;
        }
        if (this.codigoNiveacad != other.codigoNiveacad) {
            return false;
        }
        if (this.codEstudiante != other.codEstudiante) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        if (this.codProfesor != other.codProfesor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.TesisMonografiaPK[ codigoEsp=" + codigoEsp + ", codigoNiveacad=" + codigoNiveacad + ", codEstudiante=" + codEstudiante + ", matricula=" + matricula + ", tipo=" + tipo + ", codProfesor=" + codProfesor + " ]";
    }
    
}
