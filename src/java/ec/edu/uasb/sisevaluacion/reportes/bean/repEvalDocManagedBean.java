/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.reportes.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.entities.AnioAcademico;
import ec.edu.uasb.entities.Area;
import ec.edu.uasb.entities.Programa;
import ec.edu.uasb.seg.entities.Perfil;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.session.AnioAcademicoFacadeLocal;
import ec.edu.uasb.session.AreaFacadeLocal;
import ec.edu.uasb.session.ProgramaFacadeLocal;
import ec.edu.uasb.sisevaluacion.tutoria.session.ConsultaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "repEvalDocBean")
@ViewScoped
public class repEvalDocManagedBean extends BaseJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120420L;

    @EJB
    private AnioAcademicoFacadeLocal anioAcademicoFacade;
    @EJB
    private AreaFacadeLocal areaFacade;
    @EJB
    private ProgramaFacadeLocal programaFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;

    private String urlReporte = null;
    private final Usuario usr;
    private final List<Perfil> perfiles;
    private List<AnioAcademico> academicos = new ArrayList<AnioAcademico>();
    private List<String[]> listDocProg = new ArrayList<String[]>();
    private List<Area> areas = new ArrayList<Area>();
    private String filtrarAreas;
    private List<Programa> programas = new ArrayList<Programa>();
    private Long area;
    private Long anio;
    private Programa progra;
    private String smtipo;
    private String[] selectedProgDocMateria;

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    public void setProgra(Programa progra) {
        this.progra = progra;
    }

    public Programa getProgra() {
        return progra;
    }

    public String[] getSelectedProgDocMateria() {
        return selectedProgDocMateria;
    }

    public void setSelectedProgDocMateria(String[] selectedProgDocMateria) {
        this.selectedProgDocMateria = selectedProgDocMateria;
    }

    public List<String[]> getListDocProg() {
        return listDocProg;
    }

    public void setListDocProg(List<String[]> listDocProg) {
        this.listDocProg = listDocProg;
    }

    public String getSmtipo() {
        return smtipo;
    }

    public void setSmtipo(String smtipo) {
        this.smtipo = smtipo;
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

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public List<Programa> getProgramas() {
        return programas;
    }
//</editor-fold>

    /**
     * Creates a new instance of SolicContratoJSFManagedBean
     */
    public repEvalDocManagedBean() {
        this.usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        // seguridad en perfiles y areas
        perfiles = (List<Perfil>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfiles");
        filtrarAreas = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("filtrarAreas");
        for (Perfil pef : perfiles) {
            if (pef.getIdPerfil().equals("SEC_GREC") || pef.getIdPerfil().equals("US_BIBLI")) {
                filtrarAreas = "T";
                break;
            }
        }
    }

    @Override
    public void init() {
        programas.clear();
        areas.clear();
        area = null;
        progra = null;
    }

    @PostConstruct
    private void recuperarListados() {
        academicos = anioAcademicoFacade.findAll();
        if (!academicos.isEmpty()) {
            anio = academicos.get(0).getAnio();
        }
        recuperarAreas();
    }

//<editor-fold defaultstate="collapsed" desc="Anio, Areas y programas">
    private void recuperarAreas() {
        if (filtrarAreas.equals("T")) {
            areas = areaFacade.findAll();
        } else if (filtrarAreas.equals("A")) {
            areas = areaFacade.getAreasByPersona(usr.getUsuCodigo());
        }
        area = areas.size() >= 1 ? areas.get(0).getAreCodigo() : null;
        if (area != null) {
            recuperarProgramas();
        }
    }

    private void recuperarProgramas() {
        programas.clear();
        if (area != null && anio != null) {
            programas = programaFacade.getProgramasByArea(area, anio);
            if (programas.size() == 1) {
                progra = programas.get(0);
            }
        }
    }

    public void handleAreaAnioProgChange(String select) {
        if (select.equals("programa")) {
            smtipo = null;
        } else if (select.equals("anio") || select.equals("areas")) {
            progra = null;
            smtipo = null;
            recuperarProgramas();
        } else if (select.equals("reporte")) {
            if (smtipo.equals("D") || smtipo.equals("T") || smtipo.equals("C") || smtipo.equals("DTA")) {
                recDocPrograma();
            }
        }

    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Validar">
    public int validar() {
        int resp = 0;
        String ls_reporte = null;
        String ls_tipo = null;
        String ls_codProfesor = null;
        urlReporte = "";
        if (anio == null) {
            resp = -1;
        } else if (smtipo == null) {
            resp = -1;
        } else {
            ls_tipo = "P";
            ls_codProfesor = "T";
            if (smtipo.equalsIgnoreCase("D")) {
                if (selectedProgDocMateria != null) {
                    ls_tipo = "D";
                    ls_codProfesor = selectedProgDocMateria[0];
                }
                ls_reporte = "EvalDeEstudAlDocenteAnual";
            } else if (smtipo.equalsIgnoreCase("CD")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAlDocenteConsol2020";
                } else {
                    ls_reporte = "EvalDeEstudAlDocenteConsol";
                }
            } else if (smtipo.equalsIgnoreCase("A")) {
                ls_reporte = "EvalDeEstudAAsignaturaAnual";
            } else if (smtipo.equalsIgnoreCase("CA")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAAsignaturaConsol2020";
                } else {
                    ls_reporte = "EvalDeEstudAAsignaturaConsol";
                }
            } else if (smtipo.equalsIgnoreCase("T")) {
                if (selectedProgDocMateria != null) {
                    ls_tipo = "D";
                    ls_codProfesor = selectedProgDocMateria[0];
                }
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAlTutorAnual2020";
                } else {
                    ls_reporte = "EvalDeEstudAlTutorAnual";
                }
            } else if (smtipo.equalsIgnoreCase("CT")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAlTutorConsol2020";
                } else {
                    ls_reporte = "EvalDeEstudAlTutorConsol";
                }
            } else if (smtipo.equalsIgnoreCase("P")) {
                ls_reporte = "EvalDeEstudAlProgramaAnual";
            } else if (smtipo.equalsIgnoreCase("CP")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAlProgramaConsol2020";
                } else {
                    ls_reporte = "EvalDeEstudAlProgramaConsol";
                }
            } else if (smtipo.equalsIgnoreCase("CPM")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeEstudAlProgramaMInvestigacionConsol2020";
                } else {
                    ls_reporte = "EvalDeEstudAlProgramaMInvestigacionConsol";
                }
            } else if (smtipo.equalsIgnoreCase("CPD")) {
                ls_reporte = "EvalDeEstudAlProgramaDoctoConsol";
            } else if (smtipo.equalsIgnoreCase("C")) {
                if (selectedProgDocMateria != null) {
                    ls_tipo = "D";
                    ls_codProfesor = selectedProgDocMateria[0];
                }
                ls_reporte = "EvalDeCoordAlDocenteAnual";
            } else if (smtipo.equalsIgnoreCase("CC")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeCoordAlDocenteConsol2020";
                } else {
                    ls_reporte = "EvalDeCoordAlDocenteConsol";
                }
            } else if (smtipo.equalsIgnoreCase("COP")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeCoordAlProgramaAnual2020";
                } else {
                    ls_reporte = "EvalDeCoordAlProgramaAnual";
                }
            } else if (smtipo.equalsIgnoreCase("CCOP")) {
                if (anio >= 2020) {
                    ls_reporte = "EvalDeCoordAlProgramaConsol2020";
                } else {
                    ls_reporte = "EvalDeCoordAlProgramaConsol";
                }
            } else if (smtipo.equalsIgnoreCase("DTA")) {
                ls_codProfesor = selectedProgDocMateria[0];
                ls_reporte = "EvalDeEstudAlDocenteAnualTutoAcad";

            }
            if (smtipo.equalsIgnoreCase("DTA")) {
                urlReporte
                        = "&reporte=" + ls_reporte
                        + "&anio=" + anio
                        + "&codProfesor=" + ls_codProfesor
                        + "&codArea=" + area;
            } else {
                urlReporte = "&tipReporte=" + ls_tipo
                        + "&reporte=" + ls_reporte
                        + "&anio=" + anio
                        + "&codProfesor=" + ls_codProfesor
                        + "&codArea=T"
                        + "&codEsp=" + progra.getProgramaPK().getPrgCodigo()
                        + "&codTrim=T";
            }

        }
        return resp;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Imprimir">
    public void imprimirPrograma_processAction(ActionEvent ae) {
        selectedProgDocMateria = null;
        imprimirButton_processAction(ae);
    }

    @Override
    public void imprimirButton_processAction(ActionEvent ae) {
        if (validar() == 0) {
            urlReporte = urlReporte
                    + "&tipo=pdf"
                    + "&path=GestionAdmin";
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", urlReporte);
        }
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Recuperar Docente Programa">
    public void recDocPrograma() {
        listDocProg.clear();
        String ls_codencuesta = null;
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        if (smtipo.equalsIgnoreCase("D") || smtipo.equalsIgnoreCase("C")) {

            sql.append("SELECT DISTINCT MATERIA.CODIGO_PROFESOR, MATERIA.APELLIDO_PROFESOR +' '+   MATERIA.NOMBRE_PROFESOR nombre ")
                    .append(" FROM VISTA_COORDINADOR_PROGRAMA AS MATERIA  ")
                    .append(" INNER JOIN EVALUACION.ENCUESTA_REALIZADA AS ENCRE on MATERIA.ANIO = ENCRE.ANIO ")
                    .append(" AND MATERIA.CICLO = ENCRE.CICLO AND MATERIA.CODIGO_ESP = ENCRE.CODIGO_ESP AND MATERIA.CODIGO_NIVEL =ENCRE.CODIGO_NIVEL  ")
                    .append(" AND MATERIA.COD_PARALELO = ENCRE.CODIGO_PARALELO AND MATERIA.CODIGO_MATERIA = ENCRE.CODIGO_MATERIA AND MATERIA.CODIGO_PROFESOR = ENCRE.CODIGO_PROFESOR ")
                    .append(" WHERE  ENCRE.ANIO = ").append(anio)
                    .append(" AND MATERIA.CODIGO_ESP = ").append(progra.getProgramaPK().getPrgCodigo())
                    .append(" ORDER BY nombre ASC");
        }
        if (smtipo.equalsIgnoreCase("T")) {
//            sql.append("DECLARE @PROFESOR TABLE (CODIGO_PROFESOR NUMERIC(7,0), nombre_profesor VARCHAR(32), apellido_profesor VARCHAR(35) ) ")
//                    .append("	INSERT  INTO @PROFESOR(CODIGO_PROFESOR,nombre_profesor, apellido_profesor) ")
//                    .append("	SELECT CODIGO_PROFESOR,nombre_profesor, apellido_profesor ")
//                    .append("	FROM interfaseOcu.dbo.PROFESOR ")
//                    .append(" SELECT DISTINCT prof.codigo_profesor, ")
//                    .append(" prof.APELLIDO_PROFESOR+' '+prof.NOMBRE_PROFESOR nombre")
//                    .append(" FROM interfaseOcu.EVALUACION.ENCUESTA_REALIZADA encre")
//                    .append(" INNER JOIN @PROFESOR prof ON encre.CODIGO_PROFESOR = prof.CODIGO_PROFESOR")
////                    .append(" WHERE encre.CODIGO_ENCUESTA = 16")
//                    .append(" WHERE encre.ANIO=").append(anio)
//                    .append(" AND encre.CODIGO_ESP = ").append(progra.getProgramaPK().getPrgCodigo())
//                    .append(" ORDER BY nombre ASC");
            sql.append("SELECT  DISTINCT PROFESOR.codigo_profesor,  PROFESOR.APELLIDO_PROFESOR+' '+PROFESOR.NOMBRE_PROFESOR nombre ")
                    .append("	 FROM interfaseOcu.EVALUACION.ENCUESTA_REALIZADA ENCUESTA_REALIZADA ")
                    .append("	INNER JOIN interfaseOcu.EVALUACION.ENCUESTA ENCUESTA  ON ENCUESTA_REALIZADA.CODIGO_ENCUESTA = ENCUESTA.CODIGO_ENCUESTA ")
                    .append("	INNER JOIN interfaseOcu.dbo.PROFESOR PROFESOR  ON PROFESOR.CODIGO_PROFESOR = ENCUESTA_REALIZADA.CODIGO_PROFESOR ")
                    .append(" WHERE  ENCUESTA_REALIZADA.ANIO = ").append(anio)
                    .append(" AND ENCUESTA_REALIZADA.CODIGO_ESP = ").append(progra.getProgramaPK().getPrgCodigo())
                    .append(" AND ENCUESTA.TIPO = 'T' ORDER BY nombre ASC");

        }
        if (smtipo.equalsIgnoreCase("DTA")) {
            sql.append("DECLARE @PROFESOR TABLE (CODIGO_PROFESOR NUMERIC(7,0), NOMBRE_PROFESOR VARCHAR(500)) ")
                    .append(" INSERT  INTO @PROFESOR(CODIGO_PROFESOR,NOMBRE_PROFESOR)")
                    .append(" SELECT CODIGO_PROFESOR, NOMBRE_PROFESOR +' '+  APELLIDO_PROFESOR AS NOMBRE_PROFESOR ")
                    .append(" FROM interfaseOcu.dbo.PROFESOR")
                    .append(" SELECT distinct p.CODIGO_PROFESOR, p.NOMBRE_PROFESOR")
                    .append(" FROM interfaseOcu.EVALUACION.RESPUESTA_TUTACAD r")
                    .append(" INNER JOIN @PROFESOR p ON p.CODIGO_PROFESOR= r.CODIGO_PROFESOR ")
                    .append(" INNER JOIN  interfaseOcu.GESTIONACADEMICA.INFO_COORDINADOR_PROGRAMA i ON i.CODIGO_PROFESOR=p.CODIGO_PROFESOR")
                    .append(" WHERE R.ANIO =").append(anio)
                    .append(" AND i.CODIGO_ESP = ").append(progra.getProgramaPK().getPrgCodigo())
                    .append(" ORDER BY NOMBRE_PROFESOR ASC");

        }
//        System.out.println("sql.toString() " + sql.toString());
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] programaciclo;
                programaciclo = new String[2];
                programaciclo[0] = object[0].toString();
                programaciclo[1] = object[1].toString();
                listDocProg.add(i, programaciclo);
            }
        }
    }

    //</editor-fold>
}
