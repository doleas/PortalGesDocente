/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.bean;

import ec.edu.uasb.entities.AnioAcademico;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.session.AnioAcademicoFacadeLocal;
import ec.edu.uasb.vinculacion.external.session.AreaAcademicaFacadeLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author marjorie.fiallos
 */
@ManagedBean(name = "reporteTutoriaForm")
@ViewScoped
public class ReporteTutoriaManageBean {

    @EJB
    private AnioAcademicoFacadeLocal anioAcademicoFacade;
    @EJB
    private AreaAcademicaFacadeLocal areaFacade;
    private List<AnioAcademico> academicos = new ArrayList<AnioAcademico>();
    private String smTipo = null;
    private String titulo = null;
    private String ls_reporte = null;
    private Usuario usr;
    private Long anio;

    public String getSmTipo() {
        return smTipo;
    }

    public void setSmTipo(String smTipo) {
        this.smTipo = smTipo;
    }

    public String getLs_reporte() {
        return ls_reporte;
    }

    public void setLs_reporte(String ls_reporte) {
        this.ls_reporte = ls_reporte;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public List<AnioAcademico> getAcademicos() {
        return academicos;
    }

    public void setAcademicos(List<AnioAcademico> academicos) {
        this.academicos = academicos;
    }

    @PostConstruct
    public void init() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        academicos = anioAcademicoFacade.findAll();
        if (!academicos.isEmpty()) {
            anio = academicos.get(0).getAnio();
        }
        anio = null;
//        smciclo = String.valueOf(ciclo.findByEstado('A').get(0).getCicloAcademicoPK().getAnio());
    }

    public void tipoListener() {
        anio = null;
        if (smTipo.equalsIgnoreCase("D")) {
            ls_reporte = "InfTutoAcadDet";
            titulo = " Detalle Tutorías académicas- " + anio;

        } else if (smTipo.equalsIgnoreCase("C")) {
            ls_reporte = "InfTutoAcadCuantEst";
            titulo = "Cuantitativo Tutorías académicas" + anio;
        } else if (smTipo.equalsIgnoreCase("P")) {
            ls_reporte = "InfTutoAcadCuant";
            titulo = "Cuantitativo Tutorías académicas" + anio;
        }

    }

    public void verReporte(String tipo) {
        Calendar cal = Calendar.getInstance();
        String path = "GestionAdmin";
        String codInstancia = areaFacade.areasByUsuario(usr.getUsuCodigo()).toString();
        String url = "&codInstancia=" + codInstancia
                + "&anio=" + anio
                + "&tipo=" + tipo
                + "&path=" + path
                + "&titulo=" + titulo
                + "&reporte=" + ls_reporte;

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", url);
        RequestContext.getCurrentInstance().execute("pdfWidget.show();");
    }

}
