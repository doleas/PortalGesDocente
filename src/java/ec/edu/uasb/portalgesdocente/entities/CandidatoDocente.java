/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portalgesdocente.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor.barba
 */
@Entity
public class CandidatoDocente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRF_CODIGO")
    private Long prfCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNIPRS")
    private String dniprs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPODOC")
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRES_APELLIDOS")
    private String nombresApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXPRS")
    private String sexprs;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "EMAIL")
    private String emailContratado;
    @Column(name = "ASISTENTE_ACAD")
    private String asistenteAcad;

    public CandidatoDocente() {
    }

    public CandidatoDocente(Long prfCodigo, String dniprs,String tipoDoc, String nombresApellidos, String domicilio, String sexprs, String titulo,
            String asistenteAcad, String emailContratado) {
        this.prfCodigo = prfCodigo;
        this.dniprs = dniprs;
        this.tipoDoc = tipoDoc;
        this.nombresApellidos = nombresApellidos;
        this.domicilio = domicilio;
        this.sexprs = sexprs;
        this.titulo = titulo;
        this.asistenteAcad = asistenteAcad;
        this.emailContratado = emailContratado;
    }

    public CandidatoDocente(Long prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    public Long getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(Long prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getDniprs() {
        return dniprs;
    }

    public void setDniprs(String dniprs) {
        this.dniprs = dniprs;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getSexprs() {
        return sexprs;
    }

    public void setSexprs(String sexprs) {
        this.sexprs = sexprs;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAsistenteAcad() {
        return asistenteAcad;
    }

    public void setAsistenteAcad(String asistenteAcad) {
        this.asistenteAcad = asistenteAcad;
    }

    public String getEmailContratado() {
        return emailContratado;
    }

    public void setEmailContratado(String emailContratado) {
        this.emailContratado = emailContratado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.prfCodigo != null ? this.prfCodigo.hashCode() : 0);
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
        final CandidatoDocente other = (CandidatoDocente) obj;
        return !(this.prfCodigo != other.prfCodigo && (this.prfCodigo == null || !this.prfCodigo.equals(other.prfCodigo)));
    }

    @Override
    public String toString() {
        return "CandidatoDocente{" + "prfCodigo=" + prfCodigo 
                + ", dniprs=" + dniprs 
                + ", tipoDoc=" + tipoDoc 
                + ", nombresApellidos=" + nombresApellidos 
                + ", domicilio=" + domicilio 
                + ", sexprs=" + sexprs 
                + ", titulo=" + titulo 
                + ", asistenteAcad=" + asistenteAcad
                + '}';
    }

}
