/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.bean.NavigationJSFManagedBean;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.tutoria.entities.EstudianteUltimamatricula;
import ec.edu.uasb.tutoria.entities.PrinPersona;
import ec.edu.uasb.tutoria.entities.TutSolicitudTutoria;
import ec.edu.uasb.tutoria.entities.TutGrupoTutoria;
import ec.edu.uasb.tutoria.session.EstudianteUltimamatriculaFacadeLocal;
import ec.edu.uasb.tutoria.session.PrinPersonaFacadeLocal;
import ec.edu.uasb.tutoria.session.TesisMonografiaFacadeLocal;
import ec.edu.uasb.tutoria.session.TutGrupoTutoriaFacadeLocal;
import ec.edu.uasb.tutoria.session.TutInstanciaFacadeLocal;
import ec.edu.uasb.tutoria.session.TutSolicitudTutoriaFacadeLocal;
import ec.edu.uasb.utils.JsfUtil;
import ec.edu.uasb.vinculacion.external.entities.Instalacion;
import ec.edu.uasb.vinculacion.external.session.AreaAcademicaFacadeLocal;
import ec.edu.uasb.vinculacion.external.session.InsAulaFacadeLocal;
import ec.edu.uasb.vinculacion.external.session.InstalacionFacadeLocal;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.context.RequestContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author marjorie.fiallos
 */
@ManagedBean(name = "aprobarTutoriaForm")
@ViewScoped
public class AprobarTutoriaManagedBean extends BaseJSFManagedBean implements Serializable {

    @EJB
    private TutSolicitudTutoriaFacadeLocal solicitudFacade;
    @EJB
    private TutGrupoTutoriaFacadeLocal grupoFacade;
    @EJB
    private EstudianteUltimamatriculaFacadeLocal estudianteFacade;
    @EJB
    private InstalacionFacadeLocal instalacionFacade;
    @EJB
    private InsAulaFacadeLocal insaulaFacade;
    @EJB
    private TutInstanciaFacadeLocal instancia;
    @EJB
    private TesisMonografiaFacadeLocal tesisMonografiaFacade;
    @EJB
    private AreaAcademicaFacadeLocal areaFacade;
    @EJB
    private PrinPersonaFacadeLocal personaFacade;
    private PrinPersona docente;
    private TutSolicitudTutoria solicitudSelected;
    private Object solicitudes = null;
    private LinkedHashMap<String, String> listTutoresbyfase = new LinkedHashMap<String, String>();
    private List<String[]> listSolicitud = new ArrayList<String[]>();
    private List<TutSolicitudTutoria> listSolicitudaux = new ArrayList<TutSolicitudTutoria>();
    private List<String[]> listaMaterias = new ArrayList<String[]>();
    private List<String[]> listaDocentes = new ArrayList<String[]>();
    private List<String[]> selectedgrupo = new ArrayList<String[]>();
    private List<String[]> selectedsolicitud = new ArrayList<String[]>();
    private List<String[]> selectedasistio = new ArrayList<String[]>();
    private List<String[]> listaTutores = new ArrayList<String[]>();
    private List<Instalacion> listaEdificios = new ArrayList<Instalacion>();
    private List<String[]> listaPisos = new ArrayList<String[]>();
    private List<String[]> listaInstalacion = new ArrayList<String[]>();
    private List<String[]> listaEstudiantes = new ArrayList<String[]>();
    private List<String[]> listaTuto = new ArrayList<String[]>();
    private List v;
    private List v2;
    private List z;
    private List x;
    private List m;
    private TutSolicitudTutoria solicitud;
    private TutGrupoTutoria grupo;
    private Usuario usr;
    @ManagedProperty(value = "#{navigationMgmtBean}")
    private NavigationJSFManagedBean navJSFManagedBean;
    private Integer anioAcadEstudiante;
    private Integer codSolicitante;
    private String programa;
    private String cedula;
    private String fase;
    private String area;
    private String estado;
    private String[] selectedOptions;
    /*CAMBIOS DE TIPOS*/
    private InputTextarea itxtema = new InputTextarea();
    private InputTextarea itxtobserv = new InputTextarea();
    private InputTextarea itxtlink = new InputTextarea();
    private InputTextarea itxtcorreo = new InputTextarea();
    private String itxnombres;
    private String itxcedula;
    private String nombres;
    private Date fecSolicitud;
    private Date fechaSolicitud;
    private Date fechaactual;
    private Date fechanow;
    private Date fechainicial;
    private Date hora;
    private HtmlSelectOneMenu smtipogrupo = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtiptutoria = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtutorporfase = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smmateria = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smdocente = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtutor = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smmodalidad = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smedifcio = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smpiso = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu sminstalacion = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smDuracion = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smestado = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smestado2 = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smtipsolicitante = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smnombres = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu smbusqueda = new HtmlSelectOneMenu();
    private EstudianteUltimamatricula mat = new EstudianteUltimamatricula();
    private boolean verPanelCompas = false;
    private boolean btutorporfase = false;
    private boolean bpresencial = false;
    private boolean bvirtual = false;
    private boolean bmensaje = false;
    private boolean aceptar = false;
    private boolean guardar = false;
    private boolean cancelar = false;
    private boolean anular = false;
    private boolean bdocente = false;
    private boolean btutor = false;
    private boolean beditar = false;
    private boolean verPanel = false;
    private boolean verLabel = false;
    private boolean mostrarTabla = false;
    private boolean mostrarTabla2 = false;
    private boolean mostrarColumna = false;
    private boolean mostrardatestudiante = false;
    private boolean mostrarcambios = false;
    private boolean mostrarcambios2 = false;
    private boolean mostrarcambios3 = false;
    private boolean mostrarcambios4 = false;
    private boolean verBoton = false;
    private boolean mostrarcomponente = false;
    private boolean ismanual = true;
    private boolean vermanual = false;
    private boolean asistio = false;
    private boolean verfiltro = false;
    private boolean verfiltro2 = false;
    private boolean mostarFecha = false;
    private boolean mostarFecha2 = false;
    private boolean blink = false;
    private boolean isEnable = false;
    //<editor-fold defaultstate="collapsed" desc="Propiedades ">

    public Integer getAnioAcadEstudiante() {
        return anioAcadEstudiante;
    }

    public void setAnioAcadEstudiante(Integer anioAcadEstudiante) {
        this.anioAcadEstudiante = anioAcadEstudiante;
    }

    public TutSolicitudTutoria getSolicitudSelected() {
        return solicitudSelected;
    }

    public void setSolicitudSelected(TutSolicitudTutoria solicitudSelected) {
        this.solicitudSelected = solicitudSelected;
    }

    public List<String[]> getListSolicitud() {
        return listSolicitud;
    }

    public void setListSolicitud(List<String[]> listSolicitud) {
        this.listSolicitud = listSolicitud;
    }

    public NavigationJSFManagedBean getNavJSFManagedBean() {
        return navJSFManagedBean;
    }

    public void setNavJSFManagedBean(NavigationJSFManagedBean navJSFManagedBean) {
        this.navJSFManagedBean = navJSFManagedBean;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public List<Instalacion> getListaEdificios() {
        return listaEdificios;
    }

    public void setListaEdificios(List<Instalacion> listaEdificios) {
        this.listaEdificios = listaEdificios;
    }

    public List<String[]> getListaInstalacion() {
        return listaInstalacion;
    }

    public void setListaInstalacion(List<String[]> listaInstalacion) {
        this.listaInstalacion = listaInstalacion;
    }

    public TutGrupoTutoria getGrupo() {
        return grupo;
    }

    public void setGrupo(TutGrupoTutoria grupo) {
        this.grupo = grupo;
    }

    public EstudianteUltimamatricula getMat() {
        return mat;
    }

    public void setMat(EstudianteUltimamatricula mat) {
        this.mat = mat;
    }

    public HtmlSelectOneMenu getSmtipogrupo() {
        return smtipogrupo;
    }

    public void setSmtipogrupo(HtmlSelectOneMenu smtipogrupo) {
        this.smtipogrupo = smtipogrupo;
    }

    public InputTextarea getItxtema() {
        return itxtema;
    }

    public void setItxtema(InputTextarea itxtema) {
        this.itxtema = itxtema;
    }

    public Date getFecSolicitud() {
        return fecSolicitud;
    }

    public void setFecSolicitud(Date fecSolicitud) {
        this.fecSolicitud = fecSolicitud;
    }

    public HtmlSelectOneMenu getSmtiptutoria() {
        return smtiptutoria;
    }

    public void setSmtiptutoria(HtmlSelectOneMenu smtiptutoria) {
        this.smtiptutoria = smtiptutoria;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isVerPanelCompas() {
        return verPanelCompas;
    }

    public void setVerPanelCompas(boolean verPanelCompas) {
        this.verPanelCompas = verPanelCompas;
    }

    public LinkedHashMap<String, String> getListTutoresbyfase() {
        return listTutoresbyfase;
    }

    public void setListTutoresbyfase(LinkedHashMap<String, String> listTutoresbyfase) {
        this.listTutoresbyfase = listTutoresbyfase;
    }

    public TutSolicitudTutoria getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(TutSolicitudTutoria solicitud) {
        this.solicitud = solicitud;
    }

    public boolean isBtutorporfase() {
        return btutorporfase;
    }

    public void setBtutorporfase(boolean btutorporfase) {
        this.btutorporfase = btutorporfase;
    }

    public HtmlSelectOneMenu getSmtutorporfase() {
        return smtutorporfase;
    }

    public void setSmtutorporfase(HtmlSelectOneMenu smtutorporfase) {
        this.smtutorporfase = smtutorporfase;
    }

    public InputTextarea getItxtobserv() {
        return itxtobserv;
    }

    public void setItxtobserv(InputTextarea itxtobserv) {
        this.itxtobserv = itxtobserv;
    }

    public HtmlSelectOneMenu getSmmodalidad() {
        return smmodalidad;
    }

    public void setSmmodalidad(HtmlSelectOneMenu smmodalidad) {
        this.smmodalidad = smmodalidad;
    }

    public HtmlSelectOneMenu getSmedifcio() {
        return smedifcio;
    }

    public void setSmedifcio(HtmlSelectOneMenu smedifcio) {
        this.smedifcio = smedifcio;
    }

    public HtmlSelectOneMenu getSmpiso() {
        return smpiso;
    }

    public void setSmpiso(HtmlSelectOneMenu smpiso) {
        this.smpiso = smpiso;
    }

    public HtmlSelectOneMenu getSminstalacion() {
        return sminstalacion;
    }

    public void setSminstalacion(HtmlSelectOneMenu sminstalacion) {
        this.sminstalacion = sminstalacion;
    }

    public boolean isBpresencial() {
        return bpresencial;
    }

    public void setBpresencial(boolean bpresencial) {
        this.bpresencial = bpresencial;
    }

    public boolean isBvirtual() {
        return bvirtual;
    }

    public void setBvirtual(boolean bvirtual) {
        this.bvirtual = bvirtual;
    }

    public boolean isBmensaje() {
        return bmensaje;
    }

    public void setBmensaje(boolean bmensaje) {
        this.bmensaje = bmensaje;
    }

    public InputTextarea getItxtlink() {
        return itxtlink;
    }

    public void setItxtlink(InputTextarea itxtlink) {
        this.itxtlink = itxtlink;
    }

    public InputTextarea getItxtcorreo() {
        return itxtcorreo;
    }

    public void setItxtcorreo(InputTextarea itxtcorreo) {
        this.itxtcorreo = itxtcorreo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

    public boolean isAnular() {
        return anular;
    }

    public void setAnular(boolean anular) {
        this.anular = anular;
    }

    public List<String[]> getListaPisos() {
        return listaPisos;
    }

    public void setListaPisos(List<String[]> listaPisos) {
        this.listaPisos = listaPisos;
    }

    public List<String[]> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<String[]> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<String[]> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<String[]> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<String[]> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<String[]> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public HtmlSelectOneMenu getSmmateria() {
        return smmateria;
    }

    public void setSmmateria(HtmlSelectOneMenu smmateria) {
        this.smmateria = smmateria;
    }

    public HtmlSelectOneMenu getSmdocente() {
        return smdocente;
    }

    public void setSmdocente(HtmlSelectOneMenu smdocente) {
        this.smdocente = smdocente;
    }

    public HtmlSelectOneMenu getSmtutor() {
        return smtutor;
    }

    public void setSmtutor(HtmlSelectOneMenu smtutor) {
        this.smtutor = smtutor;
    }

    public boolean isBdocente() {
        return bdocente;
    }

    public void setBdocente(boolean bdocente) {
        this.bdocente = bdocente;
    }

    public boolean isBtutor() {
        return btutor;
    }

    public void setBtutor(boolean btutor) {
        this.btutor = btutor;
    }

    public boolean isCancelar() {
        return cancelar;
    }

    public void setCancelar(boolean cancelar) {
        this.cancelar = cancelar;
    }

    public boolean isBeditar() {
        return beditar;
    }

    public void setBeditar(boolean beditar) {
        this.beditar = beditar;
    }

    public List<TutSolicitudTutoria> getListSolicitudaux() {
        return listSolicitudaux;
    }

    public void setListSolicitudaux(List<TutSolicitudTutoria> listSolicitudaux) {
        this.listSolicitudaux = listSolicitudaux;
    }

    public HtmlSelectOneMenu getSmDuracion() {
        return smDuracion;
    }

    public void setSmDuracion(HtmlSelectOneMenu smDuracion) {
        this.smDuracion = smDuracion;
    }

    public List<String[]> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<String[]> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<String[]> getListaTuto() {
        return listaTuto;
    }

    public void setListaTuto(List<String[]> listaTuto) {
        this.listaTuto = listaTuto;
    }

    public boolean isBlink() {
        return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public void setSelectedOptions(String[] selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public List<String[]> getSelectedgrupo() {
        return selectedgrupo;
    }

    public void setSelectedgrupo(List<String[]> selectedgrupo) {
        this.selectedgrupo = selectedgrupo;
    }

    public boolean isVerPanel() {
        return verPanel;
    }

    public void setVerPanel(boolean verPanel) {
        this.verPanel = verPanel;
    }

    public boolean isVerLabel() {
        return verLabel;
    }

    public void setVerLabel(boolean verLabel) {
        this.verLabel = verLabel;
    }

    public boolean isMostrarTabla() {
        return mostrarTabla;
    }

    public void setMostrarTabla(boolean mostrarTabla) {
        this.mostrarTabla = mostrarTabla;
    }

    public boolean isMostrarTabla2() {
        return mostrarTabla2;
    }

    public void setMostrarTabla2(boolean mostrarTabla2) {
        this.mostrarTabla2 = mostrarTabla2;
    }

    public HtmlSelectOneMenu getSmestado() {
        return smestado;
    }

    public void setSmestado(HtmlSelectOneMenu smestado) {
        this.smestado = smestado;
    }

    public boolean isMostrarColumna() {
        return mostrarColumna;
    }

    public void setMostrarColumna(boolean mostrarColumna) {
        this.mostrarColumna = mostrarColumna;
    }

    public List<String[]> getSelectedsolicitud() {
        return selectedsolicitud;
    }

    public void setSelectedsolicitud(List<String[]> selectedsolicitud) {
        this.selectedsolicitud = selectedsolicitud;
    }

    public Object getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Object solicitudes) {
        this.solicitudes = solicitudes;
    }

    public boolean isMostrardatestudiante() {
        return mostrardatestudiante;
    }

    public void setMostrardatestudiante(boolean mostrardatestudiante) {
        this.mostrardatestudiante = mostrardatestudiante;
    }

    public HtmlSelectOneMenu getSmestado2() {
        return smestado2;
    }

    public void setSmestado2(HtmlSelectOneMenu smestado2) {
        this.smestado2 = smestado2;
    }

    public boolean isMostrarcambios() {
        return mostrarcambios;
    }

    public void setMostrarcambios(boolean mostrarcambios) {
        this.mostrarcambios = mostrarcambios;
    }

    public boolean isVerBoton() {
        return verBoton;
    }

    public void setVerBoton(boolean verBoton) {
        this.verBoton = verBoton;
    }

    public Date getFechaactual() {
        return fechaactual;
    }

    public void setFechaactual(Date fechaactual) {
        this.fechaactual = fechaactual;
    }

    public boolean isMostrarcomponente() {
        return mostrarcomponente;
    }

    public void setMostrarcomponente(boolean mostrarcomponente) {
        this.mostrarcomponente = mostrarcomponente;
    }

    public boolean isIsmanual() {
        return ismanual;
    }

    public void setIsmanual(boolean ismanual) {
        this.ismanual = ismanual;
    }

    public boolean isVermanual() {
        return vermanual;
    }

    public void setVermanual(boolean vermanual) {
        this.vermanual = vermanual;
    }

    public String getItxnombres() {
        return itxnombres;
    }

    public void setItxnombres(String itxnombres) {
        this.itxnombres = itxnombres;
    }

    public String getItxcedula() {
        return itxcedula;
    }

    public void setItxcedula(String itxcedula) {
        this.itxcedula = itxcedula;
    }

    public HtmlSelectOneMenu getSmtipsolicitante() {
        return smtipsolicitante;
    }

    public void setSmtipsolicitante(HtmlSelectOneMenu smtipsolicitante) {
        this.smtipsolicitante = smtipsolicitante;
    }

    public PrinPersona getDocente() {
        return docente;
    }

    public void setDocente(PrinPersona docente) {
        this.docente = docente;
    }

    public Integer getCodSolicitante() {
        return codSolicitante;
    }

    public void setCodSolicitante(Integer codSolicitante) {
        this.codSolicitante = codSolicitante;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public List<String[]> getSelectedasistio() {
        return selectedasistio;
    }

    public void setSelectedasistio(List<String[]> selectedasistio) {
        this.selectedasistio = selectedasistio;
    }

    public HtmlSelectOneMenu getSmbusqueda() {
        return smbusqueda;
    }

    public void setSmbusqueda(HtmlSelectOneMenu smbusqueda) {
        this.smbusqueda = smbusqueda;
    }

    public HtmlSelectOneMenu getSmnombres() {
        return smnombres;
    }

    public void setSmnombres(HtmlSelectOneMenu smnombres) {
        this.smnombres = smnombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public boolean isVerfiltro() {
        return verfiltro;
    }

    public void setVerfiltro(boolean verfiltro) {
        this.verfiltro = verfiltro;
    }

    public boolean isVerfiltro2() {
        return verfiltro2;
    }

    public void setVerfiltro2(boolean verfiltro2) {
        this.verfiltro2 = verfiltro2;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public boolean isMostarFecha() {
        return mostarFecha;
    }

    public void setMostarFecha(boolean mostarFecha) {
        this.mostarFecha = mostarFecha;
    }

    public boolean isMostarFecha2() {
        return mostarFecha2;
    }

    public void setMostarFecha2(boolean mostarFecha2) {
        this.mostarFecha2 = mostarFecha2;
    }

    public boolean isMostrarcambios2() {
        return mostrarcambios2;
    }

    public void setMostrarcambios2(boolean mostrarcambios2) {
        this.mostrarcambios2 = mostrarcambios2;
    }

    public boolean isMostrarcambios3() {
        return mostrarcambios3;
    }

    public void setMostrarcambios3(boolean mostrarcambios3) {
        this.mostrarcambios3 = mostrarcambios3;
    }

    public boolean isMostrarcambios4() {
        return mostrarcambios4;
    }

    public void setMostrarcambios4(boolean mostrarcambios4) {
        this.mostrarcambios4 = mostrarcambios4;
    }

    public Date getFechanow() {
        return fechanow;
    }

    public void setFechanow(Date fechanow) {
        this.fechanow = fechanow;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    //</editor-fold>
    /**
     * Creates a new instance of SolicitudTutoriaJSFManagedBean
     */
    public AprobarTutoriaManagedBean() {
        this.setPaginaMant("/pages/tutoriaaprobarTutoria");
        solicitudSelected = null;

    }

    @PostConstruct
    public void init() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        solicitud = new TutSolicitudTutoria();
        grupo = new TutGrupoTutoria();
        estado = null;
        selectedgrupo.clear();
        selectedsolicitud.clear();
        this.itxtema.setValue(null);
        this.smtipogrupo.setValue(null);
        Calendar cal = Calendar.getInstance();
        listSolicitud.clear();
        mostrarTabla = true;
        mostrarTabla2 = false;
        mostrarColumna = false;
        mostarFecha = false;
        mostarFecha2 = false;
        ismanual = true;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -3);
        fechaactual = new Date();
        fechainicial = c.getTime();

    }

    public boolean isIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    // <editor-fold defaultstate="collapsed" desc="OBTENER CAMPOS POR DEFECTO">
    private void obtenerCampos() {

        mat = estudianteFacade.findStudent(solicitud.getTstCodigoSolicitante());
        anioAcadEstudiante = mat.getAnio().intValue();
        area = mat.getArea();
        programa = mat.getPrograma();
        cedula = mat.getCedPasEstudiante();
        StringBuilder sql = new StringBuilder();
        sql.append(" EXEC interfaseOcu.GESTIONACADEMICA.sp_certificado_notas  @cedula = ").append(cedula);
        v = solicitudFacade.ejecutaSqlList(sql.toString());
        Object[] object = (Object[]) v.get(0);
        int a = Math.round(Float.parseFloat(object[36].toString()));
        int b = Math.round(Float.parseFloat(object[37].toString()));
        if (a <= b) {
            fase = "FASE DE INVESTIGACIÓN";
        } else {
            fase = "FASE DOCENCIA";
        }
        listaEdificios = instalacionFacade.getListaEdificios();

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="RESET">  
    private void reset() {
        solicitud = new TutSolicitudTutoria();
        estado = null;
        grupo = new TutGrupoTutoria();
        solicitudSelected = null;
        anioAcadEstudiante = null;
        area = null;
        programa = null;
        cedula = null;
        selectedgrupo.clear();
        selectedsolicitud.clear();
        hora = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.AM_PM, Calendar.AM);
        cal.set(Calendar.HOUR, 8);
        cal.set(Calendar.MINUTE, 00);
        hora = cal.getTime();
        fecSolicitud = null;
        smtipogrupo.setValue(null);
        smtiptutoria.setValue(null);
        smtutorporfase.setValue(null);
        smmateria.setValue(null);
        smdocente.setValue(null);
        smtutor.setValue(null);
        sminstalacion.setValue(null);
        smedifcio.setValue(null);
        smmodalidad.setValue(null);
        smpiso.setValue(null);
        smDuracion.setValue(null);
        smbusqueda.setValue(null);
        smestado2.setValue(null);
        nombres = null;
        smtipsolicitante.setValue(null);
        itxtema.setValue(null);
        itxtobserv.setValue(null);
        itxnombres = null;
        itxcedula = null;
        itxtlink.setValue(null);
        itxtcorreo.setValue(null);
        listaTuto.clear();
        listaEstudiantes.clear();
        listTutoresbyfase.clear();
        listaInstalacion.clear();
        listaEdificios.clear();
        listaPisos.clear();
        listaDocentes.clear();
        listaMaterias.clear();
        listaTutores.clear();
        btutorporfase = false;
        verPanelCompas = false;
        bpresencial = false;
        bvirtual = false;
        bmensaje = false;
        aceptar = false;
        anular = false;
        guardar = false;
        cancelar = false;
        bdocente = false;
        btutor = false;
        beditar = false;
        verLabel = false;
        verPanel = false;
        mostrarcambios = true;
        mostrarcambios2 = true;
        mostrarcambios3 = false;
        mostrarcambios4 = false;
        blink = true;
        verfiltro = false;
        verfiltro2 = false;
        mostarFecha = false;
        mostarFecha2 = false;

    }
    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON NUEVO">  

    @Override
    public void nuevoButton_processAction(ActionEvent ae) {
        this.setPaginaMant("/pages/tutoria/aprobarTutoriaModal");
        super.nuevoButton_processAction(ae);
        reset();
        mostrardatestudiante = false;
        beditar = false;
        mostrarcambios = false;
        mostrarcambios2 = false;
        mostrarcambios3 = false;
        mostrarcambios4 = false;
        bpresencial = false;
        bmensaje = false;
        bvirtual = false;
        ismanual = false;
        vermanual = true;
        verBoton = true;
        verfiltro = false;
        verfiltro2 = false;
        mostarFecha = false;
        mostarFecha2 = true;

    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON CANCELAR">  
    @Override
    public void cancelarButton_processAction(ActionEvent ae) {
        if (smestado.getValue().toString().equalsIgnoreCase("T")) {
            verBoton = true;
        } else {
            verBoton = false;
        }

        solicitud = new TutSolicitudTutoria();
        reset();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON EDITAR">  
    @Override
    public void editarButton_processAction(ActionEvent ae) {
        reset();
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        this.setPaginaMant("/pages/tutoria/aprobarTutoriaModal");
        super.editarButton_processAction(ae);
        Object[] sol = (Object[]) solicitudes;
        beditar = true;
        mostrarcambios = true;
        mostrarcambios2 = true;
        mostrarcambios3 = false;
        mostrarcambios4 = false;
        vermanual = false;
        ismanual = true;
        verfiltro = false;
        verfiltro2 = false;
        mostarFecha = true;
        mostarFecha2 = false;
        solicitud = new TutSolicitudTutoria();
        grupo = new TutGrupoTutoria();
        solicitud = solicitudFacade.find(Long.parseLong(sol[0].toString()));
        if (solicitud.getTstTipoSolicitante().equals("ESTUDIANTE")) {
            obtenerCampos();
            mostrardatestudiante = true;
            anioAcadEstudiante = (solicitud.getTstAnioEstudiante() == null ? null : solicitud.getTstAnioEstudiante());
            programa = (solicitud.getPrograma() == null ? null : solicitud.getPrograma());
            area = (solicitud.getArea() == null ? null : solicitud.getArea());
            fase = (solicitud.getTstFaseTutoria() == null ? null : solicitud.getTstFaseTutoria());

        } else {
            mostrardatestudiante = false;
            bdocente = false;
        }
        itxtema.setValue(solicitud.getTstTema());
        fecSolicitud = (solicitud.getTstFechaTutoria() == null ? null : new java.sql.Date(solicitud.getTstFechaTutoria().getTime()));
        try {
            hora = (solicitud.getTstHora() == null ? null : sf.parse(solicitud.getTstHora()));
        } catch (ParseException ex) {
            Logger.getLogger(AprobarTutoriaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaEdificios = instalacionFacade.getListaEdificios();
        smtiptutoria.setValue(solicitud.getTstTipoTutoria());
        smtipogrupo.setValue(solicitud.getTstTipoGrupo());
        smmodalidad.setValue(solicitud.getTstModalidad());
        modalidadvalueChangeListener();
        if (solicitud.getTstModalidad().equals("P")) {
            // mostrarcambios2 = false;
            bpresencial = false;
            mostrarcambios3 = false;
            mostrarcambios4 = false;
            if (solicitud.getTstTipoSolicitante().equals("PROFESOR")) {
                bpresencial = true;
                smedifcio.setValue(solicitud.getTstEdificio().trim());
                smpiso.setValue(solicitud.getTstPiso().replaceAll("\\s*$", "").trim());
                sminstalacion.setValue(solicitud.getTstInstalacion());
            }
        } else if (solicitud.getTstModalidad().equals("V")) {
            bvirtual = false;
            if (solicitud.getTstTipoSolicitante().equals("PROFESOR")) {
                bvirtual = true;
            }
        }
        smmateria.setValue(solicitud.getTstMateria());
        smdocente.setValue(solicitud.getTstCodProfesor());
        smDuracion.setValue(solicitud.getTstDuracion());
        itxtcorreo.setValue(solicitud.getTstCorreo());
        itxtlink.setValue(solicitud.getTstLink());
        itxtobserv.setValue(solicitud.getTstObservacion());
        if (solicitud.getTstCodProfesor() != null) {
            smtutorporfase.setValue("D");
        } else if (solicitud.getTstTutor() != null) {
            smtutorporfase.setValue("T");
        } else if (solicitud.getTstCodInstancia() != null) {
            smtutorporfase.setValue(solicitud.getTstCodInstancia());
        }
        smtutor.setValue(solicitud.getTstTutor());
        itxtcorreo.setValue(solicitud.getTstCorreo());
        itxtlink.setValue(solicitud.getTstLink());
        itxtobserv.setValue(solicitud.getTstObservacionEstudiante());
        if (solicitud.getTstTipoSolicitante().equals("ESTUDIANTE")) {
            //mostrarProfeorTutor();

            if (solicitud.getTstTipoGrupo().equals("G")) {
                classmatesList();
                verPanel = true;
                verPanelCompas = false;
                verPanel = true;
                StringBuilder sql = new StringBuilder();
                sql.append("select TGT_CODIGO,TGT_CODIGO_ESTUDIANTE from interfaseOcu.GESTIONACADEMICA.TUT_GRUPO_TUTORIA where TST_CODIGO_SOLICITUD=").append(solicitud.getTstCodigo());
                v = solicitudFacade.ejecutaSqlList(sql.toString());
                if (v.size() > 0) {
                    for (int i = 0; i < v.size(); i++) {
                        StringBuilder q = new StringBuilder();
                        Object[] object = (Object[]) v.get(i);
                        q.append("select distinct e.cod_Estudiante,e.nom_Estudiante +' '+ e.apell_Estudiante from interfaseOcu.GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e where e.cod_Estudiante = ").append(Long.parseLong(object[1].toString()));
                        z = solicitudFacade.ejecutaSqlList(q.toString());
                        if (z.size() > 0) {
                            for (int j = 0; j < z.size(); j++) {
                                Object[] o = (Object[]) z.get(j);
                                String[] estudiante;
                                estudiante = new String[2];
                                estudiante[0] = o[0].toString();
                                estudiante[1] = o[1].toString();
                                listaTuto.add(estudiante);
                            }
                        }

                    }
                } else {
                    listaTuto.clear();
                }
            }
            tipTutorporfasevalueChangeListener();
            // docenteByMateria();

        } else if (solicitud.getTstTipoSolicitante().equals("PROFESOR")) {
            btutorporfase = true;

            m = instancia.mostrarInstancias();
            if (m.size() > 0) {
                for (int x = 0; x < m.size(); x++) {
                    Object[] b = (Object[]) m.get(x);
                    listTutoresbyfase.put(b[1].toString(), b[0].toString());
                }
            }
        }
        pisoByEdificio();
        instalcionByPiso();

        RequestContext.getCurrentInstance().update("formMant:panelMant");

    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="BOTON SALVAR">  
    @Override
    public void guardarButton_processAction(ActionEvent ae) {
        try {

            if (smbusqueda.getValue() != null) {
                if (smtipsolicitante.getValue().toString().equals("ESTUDIANTE") && smbusqueda.getValue().toString().equals("N")) {
                    mat = estudianteFacade.findStudent(estudianteFacade.findStudentbyNombrescod(nombres));
                    anioAcadEstudiante = mat.getAnio().intValue();
                    area = mat.getArea();
                    programa = mat.getPrograma();
                    codSolicitante = mat.getCodEstudiante();
                    cedula = mat.getCedPasEstudiante();
                    StringBuilder sql = new StringBuilder();
                    sql.append(" EXEC interfaseOcu.GESTIONACADEMICA.sp_certificado_notas  @cedula = ").append(cedula);
                    v = solicitudFacade.ejecutaSqlList(sql.toString());
                    if (v.size() > 0) {
                        Object[] object = (Object[]) v.get(0);
                        int a = Math.round(Float.parseFloat(object[36].toString()));
                        int b = Math.round(Float.parseFloat(object[37].toString()));
                        if (a <= b) {
                            fase = "FASE DE INVESTIGACIÓN";
                        } else {
                            fase = "FASE DOCENCIA";
                        }
                    }
                } else if (smtipsolicitante.getValue().toString().equals("PROFESOR") && smbusqueda.getValue().toString().equals("N")) {
                    docente = personaFacade.findByNombrescod(nombres);
                    codSolicitante = docente.getPerCodigo().intValue();
                }
            }
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
            Calendar cal = Calendar.getInstance();
            StringBuilder mensaje;
            if (solicitud.getTstCodigo() != null) {
                solicitud.setTstEstadoSolicitado(smestado2.getValue().toString());
                if (smestado2.getValue().toString().equals("C")) {
                    solicitud.setTstFechaTutoria(new java.sql.Date(fecSolicitud.getTime()));
                    solicitud.setTstHora(sf.format(hora));
                    solicitud.setTstDuracion(smDuracion.getValue() == null ? null : Integer.parseInt(smDuracion.getValue().toString()));
                    solicitud.setTstEdificio(smedifcio.getValue() == null ? null : smedifcio.getValue().toString());
                    solicitud.setTstPiso(smpiso.getValue() == null ? null : smpiso.getValue().toString());
                    solicitud.setTstInstalacion(sminstalacion.getValue() == null ? null : sminstalacion.getValue().toString());
                    solicitud.setTstModalidad(smmodalidad.getValue() == null ? null : smmodalidad.getValue().toString());
                    solicitud.setTstCorreo(itxtcorreo.getValue() == null ? null : itxtcorreo.getValue().toString());
                    solicitud.setTstLink(itxtlink.getValue() == null ? null : itxtlink.getValue().toString());
                }
                if (smestado2.getValue().toString().equals("A")) {
                    solicitud.setTstAprobadoPor(usr.getUsuCedPass());
                    solicitud.setTstEdificio(smedifcio.getValue() == null ? null : smedifcio.getValue().toString());
                    solicitud.setTstPiso(smpiso.getValue() == null ? null : smpiso.getValue().toString());
                    solicitud.setTstInstalacion(sminstalacion.getValue() == null ? null : sminstalacion.getValue().toString());
                    solicitud.setTstCorreo(itxtcorreo.getValue() == null ? null : itxtcorreo.getValue().toString());
                    solicitud.setTstLink(itxtlink.getValue() == null ? null : itxtlink.getValue().toString());

                }
                solicitud.setTstUsuarioModifica(usr.getUsuCedPass());
                solicitud.setTstFechaModifica(new Date());
                if (!smestado2.getValue().toString().equals("A")) {
                    solicitudFacade.edit(solicitud);
                    JsfUtil.addSuccessMessage(null, "Solicitud Guardada!");
                } else {
                    long time1 = fechaactual.getTime();
                    long time2 = solicitud.getTstFechaTutoria().getTime();
                    //if (fecSolicitud.before(fechaactual)) {
                    if (time2 < time1) {
                        JsfUtil.addErrorMessage(null, "Acción no permitida tutoría de fecha pasada, por favor proceda a Cambiar o Rechazar.");
                    } else {
                        solicitudFacade.edit(solicitud);
                        JsfUtil.addSuccessMessage(null, "Solicitud Guardada!");
                    }

                }

            } else {
                if (smtipsolicitante.getValue().toString().equalsIgnoreCase("ESTUDIANTE")) {
                    solicitud.setTstAnioEstudiante(anioAcadEstudiante);
                    solicitud.setPrograma(programa);
                    solicitud.setCodArea(mat.getCodigoFacultad().longValue());
                    solicitud.setArea(area);
                    solicitud.setCodigoEsp(Long.parseLong(mat.getEstudianteUltimamatriculaPK().getCodigoEsp()));
                    solicitud.setTstFaseTutoria(fase);
                    solicitud.setTstTipoTutoria("A");
                    solicitud.setTstTipoGrupo("I");
                    solicitud.setTstCodEjercicio(mat.getEjercicio().longValue());
                } else {
                    solicitud.setTstTipoTutoria("T");
                }
                solicitud.setTstAnioSolicitud(cal.get(Calendar.YEAR));
                solicitud.setTstModalidad("P");
                solicitud.setTstEstadoSolicitado("T");
                solicitud.setTstAsistio("S");
                solicitud.setTstCodigoSolicitante(codSolicitante.longValue());
                solicitud.setTstTipoSolicitante(smtipsolicitante.getValue().toString());
                solicitud.setTstTema(itxtema.getValue() == null ? null : itxtema.getValue().toString().toUpperCase());
                solicitud.setTstFechaTutoria(new java.sql.Date(fecSolicitud.getTime()));
                solicitud.setTstHora(sf.format(hora));
                solicitud.setTstDuracion(smDuracion.getValue() == null ? null : Integer.parseInt(smDuracion.getValue().toString()));
                solicitud.setTstObservacion(itxtobserv.getValue() == null ? null : itxtobserv.getValue().toString().toUpperCase());
                solicitud.setTstCodInstancia(areaFacade.areasByUsuario(usr.getUsuCodigo()));
                solicitud.setTstUsuarioCrea(usr.getUsuCedPass());
                solicitud.setTstFechaCrea(new Date());
                solicitudFacade.create(solicitud);
                JsfUtil.addSuccessMessage(null, "Solicitud Guardada!");
                solicitudFacade.solicitudTutoriaCalendarizacion(solicitud.getTstCodigo());

            }

        } catch (Exception e) {
            JsfUtil.addErrorMessage(null, "Error al Guardar Solicitud");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            cargarTabla();
            solicitud = new TutSolicitudTutoria();
        }
        RequestContext.getCurrentInstance()
                .update("formSolicitudTuto:dataSolicitud pnlEst");
        RequestContext.getCurrentInstance()
                .execute("mantWidget.hide();");
    }
    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="BOTON CONCLUIR">  

    public void concluirButton_processAction(ActionEvent ae) {
        try {
            Iterator<String[]> sp = listSolicitud.iterator();
            isEnable = false;
            while (sp.hasNext()) {
                Object[] o = sp.next();
                if (o[9].toString().equals("0")) {
                    if (o[10] != null) {
                        solicitud = new TutSolicitudTutoria();
                        solicitud = solicitudFacade.find(Long.parseLong(o[0].toString()));
                        solicitud.setTstEstadoSolicitado("T");
                        if (o[10].equals("S")) {
                            solicitud.setTstAsistio(o[10].toString());
                        }
                        solicitud.setTstUsuarioModifica(usr.getUsuCedPass());
                        solicitud.setTstFechaModifica(new Date());
                        solicitudFacade.edit(solicitud);
                        solicitudFacade.solicitudTutoriaCalendarizacion(solicitud.getTstCodigo());
                    }
                }

            }
            JsfUtil.addSuccessMessage(null, "Solicitudes Concluidas!");

        } catch (Exception e) {
            JsfUtil.addErrorMessage(null, "Error al Concluir Solicitud");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            solicitud = new TutSolicitudTutoria();
            listSolicitud.clear();
            cargarTabla();
        }
        RequestContext.getCurrentInstance()
                .update("formSolicitudTuto:dataSolicitud");
        RequestContext.getCurrentInstance()
                .execute("mantWidget.hide();");
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="VALUECHANGELISTENER">  VALUECHANGELISTENER
    public void mostrarProfeorTutor() {
        bdocente = false;
        btutor = false;
        listaMaterias.clear();
        if (smtutorporfase.getValue() != null) {
            if (smtutorporfase.getValue().toString().equalsIgnoreCase("D")) {
                bdocente = true;
                StringBuilder sql = new StringBuilder();
                sql.append(" EXEC interfaseOcu.GESTIONACADEMICA.sp_getMatProfEstudiante  @codestudiante = ").append(usr.getUsuCodigo()).append(" ,@codEsp = ").append(mat.getEstudianteUltimamatriculaPK().getCodigoEsp());
                v = solicitudFacade.ejecutaSqlList(sql.toString());
                for (int i = 0; i < v.size(); i++) {
                    Object[] object = (Object[]) v.get(i);
                    String[] materia;
                    materia = new String[2];
                    materia[0] = object[0].toString();
                    materia[1] = object[1].toString();
                    listaMaterias.add(materia);
                }
            } else if (smtutorporfase.getValue().toString().equalsIgnoreCase("T")) {
                btutor = true;
                x = tesisMonografiaFacade.obtenerListaTutores(mat.getCodEstudiante(), mat.getAnio().intValue(), mat.getEstudianteUltimamatriculaPK().getCodigoEsp());
                for (int j = 0; j < x.size(); j++) {
                    Object[] object = (Object[]) x.get(j);
                    String[] tutor;
                    tutor = new String[2];
                    tutor[0] = object[0].toString();
                    tutor[1] = object[1].toString();
                    listaTutores.add(tutor);
                }
            }
        }
    }

    public void docenteByMateria() {
        listaDocentes.clear();
        if (smmateria.getValue() != null) {
            StringBuilder sql = new StringBuilder();
            sql.append(" EXEC interfaseOcu.GESTIONACADEMICA.sp_getMatProfEstudiante  @codestudiante = ").append(usr.getUsuCodigo()).append(" ,@codEsp = ").append(mat.getEstudianteUltimamatriculaPK().getCodigoEsp());
            v = solicitudFacade.ejecutaSqlList(sql.toString());
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] docentes;
                docentes = new String[2];
                if (smmateria.getValue().toString().equalsIgnoreCase(object[9].toString())) {
                    docentes[0] = object[4].toString();
                    docentes[1] = object[5].toString() + ' ' + object[6].toString();
                    listaDocentes.add(docentes);
                }
            }
        }
    }

    public void pisoByEdificio() {
        listaPisos.clear();
        if (smedifcio.getValue() != null) {
            listaPisos = insaulaFacade.getListaPisobyEdificio(smedifcio.getValue().toString());
        }
    }

    public void instalcionByPiso() {
        listaInstalacion.clear();
        if (smpiso.getValue() != null && smedifcio.getValue() != null) {
            listaInstalacion = insaulaFacade.getListaInstalcionbyPiso(smpiso.getValue().toString(), smedifcio.getValue().toString());
        }
    }

    public void classmatesList() {
        listaEstudiantes.clear();
        verPanelCompas = false;
        verLabel = false;
        if (smtipogrupo.getValue() != null) {
            if (smtipogrupo.getValue().toString().equalsIgnoreCase("G")) {
                verPanelCompas = true;
                verLabel = true;
                listaEstudiantes = estudianteFacade.obtenerListaCompañeros(mat.getEjercicio(), mat.getEstudianteUltimamatriculaPK().getCodigoEsp(), mat.getCodEstudiante());
            }
        }
    }

    public void tipTutorporfasevalueChangeListener() {
        listTutoresbyfase.clear();
        btutorporfase = true;
        if (smtiptutoria.getValue() != null) {
            if (smtiptutoria.getValue().toString().equals("A") && fase.equals("FASE DOCENCIA")) {
                listTutoresbyfase.put("DOCENTE", "D");

            } else if (smtiptutoria.getValue().toString().equals("A") && fase.equals("FASE DE INVESTIGACIÓN")) {
                listTutoresbyfase.put("TUTOR", "T");
                listTutoresbyfase.put("DOCENTE", "D");
            }
            v = instancia.buscarCodigobyTipo(smtiptutoria.getValue().toString());
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                listTutoresbyfase.put(object[1].toString(), object[0].toString());
            }

        }
    }

    public void modalidadvalueChangeListener() {
        bpresencial = false;
        bvirtual = false;
        bmensaje = false;
        if (smmodalidad.getValue() != null) {
            if (smmodalidad.getValue().toString().equalsIgnoreCase("P")) {
                bpresencial = true;
            } else if (smmodalidad.getValue().toString().equalsIgnoreCase("V")) {
                bvirtual = true;
                itxtlink.setValue(null);

            } else if (smmodalidad.getValue().toString().equalsIgnoreCase("C")) {
                bmensaje = true;
            }
        }

    }

    public void estadoChangeListener() {
        Calendar cal = Calendar.getInstance();

        if (smestado.getValue().toString().equals("A,O")) {
            mostrarTabla = false;
            mostrarTabla2 = true;
            mostrarColumna = false;
            verBoton = false;
        } else if (smestado.getValue().toString().equals("S")) {
            mostrarTabla = true;
            mostrarTabla2 = false;
            mostrarColumna = true;
            verBoton = false;
        } else {
            mostrarTabla = true;
            mostrarTabla2 = false;
            mostrarColumna = false;
            verBoton = false;
            if (smestado.getValue().toString().equals("T")) {
                verBoton = true;
                selectedgrupo.clear();
            }
        }
        try {
            listSolicitud = solicitudFacade.findRequest(areaFacade.areasByUsuario(usr.getUsuCodigo()), cal.get(Calendar.YEAR), smestado.getValue().toString());
            if (listSolicitud.isEmpty()) {
                mostrarcomponente = false;
            } else {
                mostrarcomponente = true;
            }
        } catch (Exception e) {

        }
    }

    public void estado2ChangeListener() {
        if (smestado2.getValue() != null) {
            fecSolicitud = (solicitud.getTstFechaTutoria() == null ? null : new java.sql.Date(solicitud.getTstFechaTutoria().getTime()));
            mostrarcambios2 = false;
            mostrarcambios = true;
            mostrarcambios3 = false;
            mostrarcambios4 = false;
            bvirtual = false;
            bpresencial = false;
            bmensaje = false;
            blink = false;

            if (solicitud.getTstTipoSolicitante().equals("ESTUDIANTE")) {
                itxtlink.setValue(null);
                smedifcio.setValue(null);
                smpiso.setValue(null);
                sminstalacion.setValue(null);
            }
            if (smestado2.getValue().toString().equals("C")) {
                mostrarcambios = false;
                mostrarcambios2 = true;
                mostrarcambios3 = true;
                mostrarcambios4 = true;
                if (fecSolicitud.before(fechaactual)) {
                    setFecSolicitud(null);
                }
                if (smmodalidad.getValue().toString().equals("P")) {
                    bpresencial = true;
                    mostrarcambios3 = true;
                } else if (smmodalidad.getValue().toString().equals("V")) {
                    blink = false;
                    bvirtual = true;
                } else if (smmodalidad.getValue().toString().equals("C")) {
                    bmensaje = true;
                }

                RequestContext.getCurrentInstance().execute("spinnerTimeWidget.enable();");

            } else {
                smmodalidad.setValue(solicitud.getTstModalidad());
                mostrarcambios = true;
                mostrarcambios2 = true;
                mostrarcambios3 = false;

                if (smestado2.getValue().toString().equals("A")) {
                    if (smmodalidad.getValue().toString().equals("V")) {
                        blink = false;
                        bvirtual = true;
                    } else if (smmodalidad.getValue().toString().equals("P")) {
                        bpresencial = true;
                        mostrarcambios3 = true;
                        mostrarcambios4 = false;
                    } else if (smmodalidad.getValue().toString().equals("C")) {
                        bmensaje = true;
                        itxtcorreo.setValue(solicitud.getTstCorreo());
                    }

                } else if (smestado2.getValue().toString().equals("R")) {
                    mostrarcambios2 = true;
                    mostrarcambios3 = false;
                    if (smmodalidad.getValue().toString().equals("C")) {
                        bmensaje = true;
                    } else if (smmodalidad.getValue().toString().equals("P")) {
                        bpresencial = true;
                    } else if (smmodalidad.getValue().toString().equals("C")) {
                        bvirtual = true;
                    }

                }
                RequestContext.getCurrentInstance().execute("spinnerTimeWidget.disable();");
            }

        }
    }

    public void cedulaChangeListener() {

        if (smtipsolicitante.getValue().toString().equals("ESTUDIANTE")) {

            mat = estudianteFacade.findStudent(estudianteFacade.findStudentbyCedula(itxcedula));
            if (mat.getCodEstudiante() == null) {
                JsfUtil.addErrorMessage(null, "Doc. Identidad no existe");
            } else {
                itxnombres = mat.getNomEstudiante() + " " + mat.getApellEstudiante();
                anioAcadEstudiante = mat.getAnio().intValue();
                area = mat.getArea();
                programa = mat.getPrograma();
                codSolicitante = mat.getCodEstudiante();
                cedula = mat.getCedPasEstudiante();
                StringBuilder sql = new StringBuilder();
                sql.append(" EXEC interfaseOcu.GESTIONACADEMICA.sp_certificado_notas  @cedula = ").append(cedula);
                v = solicitudFacade.ejecutaSqlList(sql.toString());
                Object[] object = (Object[]) v.get(0);
                int a = Math.round(Float.parseFloat(object[36].toString()));
                int b = Math.round(Float.parseFloat(object[37].toString()));
                if (a <= b) {
                    fase = "FASE DE INVESTIGACIÓN";
                } else {
                    fase = "FASE DOCENCIA";
                }
            }
        } else {
            docente = personaFacade.findByCedula(itxcedula);
            if (docente == null) {
                JsfUtil.addErrorMessage(null, "Doc. Identidad no existe");
            } else {
                itxnombres = docente.getPerNombres() + " " + docente.getPerPrimerApellido() + " " + docente.getPerSegundoApellido();
                codSolicitante = docente.getPerCodigo().intValue();
            }
        }

    }

    public void cargarTabla() {
        try {
            Calendar cal = Calendar.getInstance();
            listSolicitud.clear();
            listSolicitud = solicitudFacade.findRequest(areaFacade.areasByUsuario(usr.getUsuCodigo()), cal.get(Calendar.YEAR), smestado.getValue().toString());
        } catch (Exception e) {

        }
    }

    public List<String> completeText(String query) {

        List<String> personList = new ArrayList<String>();
        if (smtipsolicitante.getValue() != null) {
            if (smtipsolicitante.getValue().toString().equals("ESTUDIANTE")) {
                if (query != null) {
                    personList = estudianteFacade.findStudentbyNombres(query);
                }
            } else {
                personList = personaFacade.findByNombres(query);
            }
        }
        return personList;
    }

    public void mostrarFiltros() {
        if (smbusqueda.getValue() != null) {
            if (smbusqueda.getValue().toString().equals("C")) {
                verfiltro = true;
                verfiltro2 = false;
            } else {
                verfiltro = false;
                verfiltro2 = true;
            }
        }

    }

    public void limpiarFiltros() {
        verfiltro = false;
        verfiltro2 = false;
        itxcedula = null;
        nombres = null;
        itxnombres = null;
        smbusqueda.setValue(null);

    }

    // </editor-fold>
    public void validateFechas(FacesContext context, UIComponent component, Object value) throws ValidatorException, ParseException {
        String estado = (String) value;
        if (estado.equals("A")) {
            fecSolicitud = (solicitud.getTstFechaTutoria() == null ? null : new java.sql.Date(solicitud.getTstFechaTutoria().getTime()));
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            fechanow = sf.parse(sf.format(fechaactual));
            fechaSolicitud=sf.parse(sf.format(fecSolicitud));          
            if (fechaSolicitud.before(fechanow)) {
                FacesMessage msg = new FacesMessage("Acción no permitida tutoría de fecha pasada, por favor proceda a Cambiar");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

        }
    }
}
