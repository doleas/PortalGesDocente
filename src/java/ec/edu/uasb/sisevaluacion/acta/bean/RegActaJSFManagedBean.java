/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.acta.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.bean.NavigationJSFManagedBean;
import ec.edu.uasb.entities.Area;
import ec.edu.uasb.entities.CicloAcademico;
import ec.edu.uasb.entities.CoordinadorPrograma;

import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.session.AreaFacadeLocal;
import ec.edu.uasb.session.CicloAcademicoFacadeLocal;
import ec.edu.uasb.session.CoordinadorProgramaFacadeLocal;
import ec.edu.uasb.sisevaluacion.acta.entities.CeaActa;
import ec.edu.uasb.sisevaluacion.acta.session.CeaActaFacadeLocal;
import ec.edu.uasb.utils.JsfUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "regactabean")
@ViewScoped
public class RegActaJSFManagedBean extends BaseJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120420L;
    @EJB
    private CicloAcademicoFacadeLocal cicloAcademicoFacade;

    @EJB
    private CoordinadorProgramaFacadeLocal coordinadorProgramaFacade;

    @EJB
    private CeaActaFacadeLocal ceaActaFacade;
    
    @EJB
    private AreaFacadeLocal areaFacade;

    private final Usuario usr;
    private final SimpleDateFormat formatter;
    private Long anio;
    /*Se creo una nueva variable para que el docente guarde el año a donde desea copiar el sylabus. Se creo Getter y Setter MV*/
    private Long anioCopiar;

    private List<CicloAcademico> ciclos = new ArrayList<CicloAcademico>();
    private List<CoordinadorPrograma> listProgramas = new ArrayList<CoordinadorPrograma>();
    private List<Area> listaAreas = new ArrayList<Area>();

    private CoordinadorPrograma programaSelected;
    private CeaActa ceaActa;

    private Integer activeTabIndex = 0;
    private Integer activeTabIndexObj = 0;
    private Integer activeTabIndexArtic = 0;
    private Integer activeTabIndexProc = 0;
    private Integer activeTabIndexEval = 0;
    private Integer activeTabIndexObserv = 0;
    private Integer activeTabIndexBiblio = 0;
    private String tituloMantTab;
    private String msgNotificacion;
    private String smarea = null;
    
    private boolean sylabusPendientes;

    private Date thoraactaini;
    private Date thoraactafin;
    @ManagedProperty(value = "#{navigationMgmtBean}")
    private NavigationJSFManagedBean navJSFManagedBean;

    /**
     * Variables temporales implementadas de Articulacion, Ambito y Formacion
     */
    private String accion;
    private String ckedtrescomite;

    private InputTextarea itxtactapart = new InputTextarea();
    private InputTextarea itxtactaspacad = new InputTextarea();
    private InputTextarea itxtactasolest = new InputTextarea();
    private InputTextarea itxtactaaspadm = new InputTextarea();

    //<editor-fold defaultstate="collapsed" desc="Propiedades ">
    public void setNavJSFManagedBean(NavigationJSFManagedBean navJSFManagedBean) {
        this.navJSFManagedBean = navJSFManagedBean;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getAnioCopiar() {
        return anioCopiar;
    }

    public void setAnioCopiar(Long anioCopiar) {
        this.anioCopiar = anioCopiar;
    }

    public List<CicloAcademico> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloAcademico> ciclos) {
        this.ciclos = ciclos;
    }

    public Integer getActiveTabIndex() {
        return activeTabIndex;
    }

    public void setActiveTabIndex(Integer activeTabIndex) {
        this.activeTabIndex = activeTabIndex;
    }

    public String getTituloMantTab() {
        return tituloMantTab;
    }

    public void setTituloMantTab(String tituloMantTab) {
        this.tituloMantTab = tituloMantTab;
    }

    public boolean isSylabusPendientes() {
        return sylabusPendientes;
    }

    public void setSylabusPendientes(boolean sylabusPendientes) {
        this.sylabusPendientes = sylabusPendientes;
    }

    public String getMsgNotificacion() {
        return msgNotificacion;
    }

    public void setMsgNotificacion(String msgNotificacion) {
        this.msgNotificacion = msgNotificacion;
    }

    public Integer getActiveTabIndexObj() {
        return activeTabIndexObj;
    }

    public void setActiveTabIndexObj(Integer activeTabIndexObj) {
        this.activeTabIndexObj = activeTabIndexObj;
    }

    public Integer getActiveTabIndexArtic() {
        return activeTabIndexArtic;
    }

    public void setActiveTabIndexArtic(Integer activeTabIndexArtic) {
        this.activeTabIndexArtic = activeTabIndexArtic;
    }

    public Integer getActiveTabIndexProc() {
        return activeTabIndexProc;
    }

    public void setActiveTabIndexProc(Integer activeTabIndexProc) {
        this.activeTabIndexProc = activeTabIndexProc;
    }

    public Integer getActiveTabIndexEval() {
        return activeTabIndexEval;
    }

    public void setActiveTabIndexEval(Integer activeTabIndexEval) {
        this.activeTabIndexEval = activeTabIndexEval;
    }

    public Integer getActiveTabIndexObserv() {
        return activeTabIndexObserv;
    }

    public void setActiveTabIndexObserv(Integer activeTabIndexObserv) {
        this.activeTabIndexObserv = activeTabIndexObserv;
    }

    public Integer getActiveTabIndexBiblio() {
        return activeTabIndexBiblio;
    }

    public void setActiveTabIndexBiblio(Integer activeTabIndexBiblio) {
        this.activeTabIndexBiblio = activeTabIndexBiblio;
    }

    public List<CoordinadorPrograma> getListProgramas() {
        return listProgramas;
    }

    public void setListProgramas(List<CoordinadorPrograma> listProgramas) {
        this.listProgramas = listProgramas;
    }

    public CoordinadorPrograma getProgramaSelected() {
        return programaSelected;
    }

    public void setProgramaSelected(CoordinadorPrograma programaSelected) {
        this.programaSelected = programaSelected;
    }

    public CeaActa getCeaActa() {
        return ceaActa;
    }

    public void setCeaActa(CeaActa ceaActa) {
        this.ceaActa = ceaActa;
    }

    public Date getThoraactaini() {
        return thoraactaini;
    }

    public void setThoraactaini(Date thoraactaini) {
        this.thoraactaini = thoraactaini;
    }

    public Date getThoraactafin() {
        return thoraactafin;
    }

    public void setThoraactafin(Date thoraactafin) {
        this.thoraactafin = thoraactafin;
    }

    public InputTextarea getItxtactapart() {
        return itxtactapart;
    }

    public void setItxtactapart(InputTextarea itxtactapart) {
        this.itxtactapart = itxtactapart;
    }

    public InputTextarea getItxtactaspacad() {
        return itxtactaspacad;
    }

    public void setItxtactaspacad(InputTextarea itxtactaspacad) {
        this.itxtactaspacad = itxtactaspacad;
    }

    public InputTextarea getItxtactasolest() {
        return itxtactasolest;
    }

    public void setItxtactasolest(InputTextarea itxtactasolest) {
        this.itxtactasolest = itxtactasolest;
    }

    public InputTextarea getItxtactaaspadm() {
        return itxtactaaspadm;
    }

    public void setItxtactaaspadm(InputTextarea itxtactaaspadm) {
        this.itxtactaaspadm = itxtactaaspadm;
    }

    public String getCkedtrescomite() {
        return ckedtrescomite;
    }

    public void setCkedtrescomite(String ckedtrescomite) {
        this.ckedtrescomite = ckedtrescomite;
    }

    public List<Area> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(List<Area> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public String getSmarea() {
        return smarea;
    }

    public void setSmarea(String smarea) {
        this.smarea = smarea;
    }

    //</editor-fold>
    /**
     * Creates a new instance of RegSyllabusJSFManagedBean
     */
    public RegActaJSFManagedBean() {
        this.setPaginaMant("/pages/opcion/actaComite/regActaComite");
//        this.setPaginaTema("/pages/syllabus/regTema"); // debe ser incluida tambien en el navigationBean
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        formatter = new SimpleDateFormat("dd MMMM yyyy", new Locale("es"));
    }

    @PostConstruct
    private void recuperarListados() {
        ciclos = cicloAcademicoFacade.findAll();
//        if (!ciclos.isEmpty()) {
//            anio = ciclos.get(0).getAnio();
//            handleCicloChange();
//        }
    }

    @Override
    public void init() {
        activeTabIndex = 0;
        activeTabIndexObj = 0;
        activeTabIndexArtic = 0;
        activeTabIndexProc = 0;
        activeTabIndexEval = 0;
        activeTabIndexObserv = 0;
        activeTabIndexBiblio = 0;
        ceaActa = new CeaActa();
        listaAreas = areaFacade.findAll();
    }

    private void recuperarContenidos() {

        RequestContext.getCurrentInstance().update("formMant:tabView:dataTemas");
        RequestContext.getCurrentInstance().update("formMant:tabView:tabViewArtic");
        RequestContext.getCurrentInstance().update("formMant:tabView:tabViewBiblio:dataBiblioGeneral");
    }

    public void editarActa_processAction() {
        this.setPaginaMant("/pages/opcion/actaComite/regActaComite");
        resetActa();
        try {
            ceaActa = ceaActaFacade.findByAreaProgAnio(programaSelected.getCoordinadorProgramaPK().getAreCodigo(), programaSelected.getCoordinadorProgramaPK().getCodigoEsp(), anio);
        } catch (Exception e) {
            e.getStackTrace();
        }
        RequestContext.getCurrentInstance().update("formMant:panelMant");
    }

    private void resetActa() {
        
    }

    public void handleCicloChange() {
        if (anio != null && smarea != null){
            listProgramas = coordinadorProgramaFacade.getProgramasByCoordAnio(Long.parseLong(smarea), anio);
        }
    }

    public String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        if (pattern == null) {
            throw new NullPointerException("pattern");
        }

//        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return formatter.format(date);
    }

    //<editor-fold defaultstate="collapsed" desc="Operaciones sobre temas y bibliografía ">
    public void onRowSelect(SelectEvent event) {

    }

    @Override
    public void editarButton_processAction(ActionEvent ae) {
        switch (activeTabIndex) {
            case 3:
                tituloMantTab = "Editar Tema";
                break;
            case 4:
                tituloMantTab = "Editar Bibliografía";
                break;
            default:
                throw new AssertionError();
        }
    }

    public void imprimirSp() {
        String urlReporte = "tipo=pdf"
                + "&anio=" + programaSelected.getAnio()
                + "&per=" + programaSelected.getCodigoNiveacad()
                + "&par=" + programaSelected.getNumParalelos()
                + "&prog=" + programaSelected.getCoordinadorProgramaPK().getCodigoEsp();

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", urlReporte);
        // System.out.println(urlReporte);
    }

    //</editor-fold>
    public void enviarButton_processAction(ActionEvent ae) {
        if (checkActa() == false) {
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("mensajeWidget.show();");
            return;
        }
        try {
            ceaActa.setCeaEstado("E");
            ceaActaFacade.edit(ceaActa);
            //Enviar Notificacion
            JsfUtil.addSuccessMessage(null, "Notificación enviada");
            RequestContext.getCurrentInstance().execute("mantWidget.hide();");
            RequestContext.getCurrentInstance().update("formAsignaturas:dataAsig");

        } catch (Exception e) {
//            super.getNavigationJSFManagedBean().setMsgError("No puedo enviar el comunicado. Por favor comuniquese con el call-center de la Universidad");
//            RequestContext.getCurrentInstance().update("dialogMessage");
//            RequestContext.getCurrentInstance().execute("mensajeWidget.show();");
        }

    }

    private boolean checkActa() {
        ArrayList msgErrores = new ArrayList();
        if (ceaActa != null) {
            if (anio == 2020 && (ceaActa.getCeaParticipantes() == null || ceaActa.getCeaHoraInicio() == null || ceaActa.getCeaHoraFin() == null)) {
                msgErrores.add("2.1. Descripción de la asignatura");
            }
            
        }
        if (!msgErrores.isEmpty()) {
            super.getNavigationJSFManagedBean().setMensaje(msgErrores.get(0).toString());
            JsfUtil.addErrorMessages(null, msgErrores);
        }
        return msgErrores.isEmpty();
    }

}
