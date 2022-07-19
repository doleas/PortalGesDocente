/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marjorie.fiallos
 */
@Entity
@Table(name = "ESTUDIANTE_ULTIMAMATRICULA" , schema = "GESTIONACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteUltimamatricula.findAll", query = "SELECT e FROM EstudianteUltimamatricula e")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCodEstudiante", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.codEstudiante = :codEstudiante")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCedPasEstudiante", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.cedPasEstudiante = :cedPasEstudiante")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByNomEstudiante", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.nomEstudiante = :nomEstudiante")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByApellEstudiante", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.apellEstudiante = :apellEstudiante")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByMatricula", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.estudianteUltimamatriculaPK.matricula = :matricula")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByAnio", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.anio = :anio")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCiclo", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.ciclo = :ciclo")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCodigoEsp", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.estudianteUltimamatriculaPK.codigoEsp = :codigoEsp")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByPrograma", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.programa = :programa")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByInicio", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.inicio = :inicio")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByFin", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.fin = :fin")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCodigoFacultad", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.codigoFacultad = :codigoFacultad")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByCodigoNiveacad", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.codigoNiveacad = :codigoNiveacad")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByArea", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.area = :area")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByEjercicio", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.ejercicio = :ejercicio")
    , @NamedQuery(name = "EstudianteUltimamatricula.findByAnioInicial", query = "SELECT e FROM EstudianteUltimamatricula e WHERE e.anioInicial = :anioInicial")})
public class EstudianteUltimamatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteUltimamatriculaPK estudianteUltimamatriculaPK;
    @Column(name = "COD_ESTUDIANTE")
    private Integer codEstudiante;
    @Size(max = 15)
    @Column(name = "CED_PAS_ESTUDIANTE")
    private String cedPasEstudiante;
    @Size(max = 32)
    @Column(name = "NOM_ESTUDIANTE")
    private String nomEstudiante;
    @Size(max = 65)
    @Column(name = "APELL_ESTUDIANTE")
    private String apellEstudiante;
    @Column(name = "ANIO")
    private BigInteger anio;
    @Column(name = "CICLO")
    private Integer ciclo;
    @Size(max = 500)
    @Column(name = "PROGRAMA")
    private String programa;
    @Column(name = "INICIO")
    private BigInteger inicio;
    @Size(max = 384)
    @Column(name = "FIN")
    private String fin;
    @Column(name = "CODIGO_FACULTAD")
    private Integer codigoFacultad;
    @Size(max = 3)
    @Column(name = "CODIGO_NIVEACAD")
    private String codigoNiveacad;
    @Size(max = 75)
    @Column(name = "AREA")
    private String area;
    @Column(name = "EJERCICIO")
    private Short ejercicio;
    @Column(name = "ANIO_INICIAL")
    private BigInteger anioInicial;

    public EstudianteUltimamatricula() {
    }

    public EstudianteUltimamatricula(EstudianteUltimamatriculaPK estudianteUltimamatriculaPK) {
        this.estudianteUltimamatriculaPK = estudianteUltimamatriculaPK;
    }

    public EstudianteUltimamatricula(String matricula, String codigoEsp) {
        this.estudianteUltimamatriculaPK = new EstudianteUltimamatriculaPK(matricula, codigoEsp);
    }

    public EstudianteUltimamatriculaPK getEstudianteUltimamatriculaPK() {
        return estudianteUltimamatriculaPK;
    }

    public void setEstudianteUltimamatriculaPK(EstudianteUltimamatriculaPK estudianteUltimamatriculaPK) {
        this.estudianteUltimamatriculaPK = estudianteUltimamatriculaPK;
    }

    public Integer getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Integer codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getCedPasEstudiante() {
        return cedPasEstudiante;
    }

    public void setCedPasEstudiante(String cedPasEstudiante) {
        this.cedPasEstudiante = cedPasEstudiante;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }

    public String getApellEstudiante() {
        return apellEstudiante;
    }

    public void setApellEstudiante(String apellEstudiante) {
        this.apellEstudiante = apellEstudiante;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public BigInteger getInicio() {
        return inicio;
    }

    public void setInicio(BigInteger inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Integer getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(Integer codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getCodigoNiveacad() {
        return codigoNiveacad;
    }

    public void setCodigoNiveacad(String codigoNiveacad) {
        this.codigoNiveacad = codigoNiveacad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Short getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Short ejercicio) {
        this.ejercicio = ejercicio;
    }

    public BigInteger getAnioInicial() {
        return anioInicial;
    }

    public void setAnioInicial(BigInteger anioInicial) {
        this.anioInicial = anioInicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteUltimamatriculaPK != null ? estudianteUltimamatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteUltimamatricula)) {
            return false;
        }
        EstudianteUltimamatricula other = (EstudianteUltimamatricula) object;
        if ((this.estudianteUltimamatriculaPK == null && other.estudianteUltimamatriculaPK != null) || (this.estudianteUltimamatriculaPK != null && !this.estudianteUltimamatriculaPK.equals(other.estudianteUltimamatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uasb.tutoria.entities.EstudianteUltimamatricula[ estudianteUltimamatriculaPK=" + estudianteUltimamatriculaPK + " ]";
    }
    
}
