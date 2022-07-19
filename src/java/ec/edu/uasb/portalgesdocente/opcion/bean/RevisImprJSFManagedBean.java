/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portalgesdocente.opcion.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.config.ConfigurarRepositorio;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import ec.edu.uasb.portalgesdocente.entities.EstadoSolicContrato;
import ec.edu.uasb.portalgesdocente.entities.EstadoSolicContratoPK;
import ec.edu.uasb.portalgesdocente.session.ContratoDocenteFacadeLocal;
import ec.edu.uasb.portalgesdocente.session.EstadoSolicContratoFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.seg.session.UsuarioFacadeLocal;
import ec.edu.uasb.utils.JsfUtil;
import java.io.File;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "revisImprBean")
@ViewScoped
public class RevisImprJSFManagedBean extends BaseJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120444L;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private ContratoDocenteFacadeLocal contratoDocenteFacade;

    @EJB
    private EstadoSolicContratoFacadeLocal estadoSolicContratoFacade;

    private final Usuario usr;
    private ContratoDocente contratoSelected;
    private ContratoDocente contratoEdit;

    private final List<ContratoArea> contratosDocentes = new ArrayList<ContratoArea>();
    private final List<EstadoSolicContrato> historiaEstados = new ArrayList<EstadoSolicContrato>();
    private Date desde;
    private Date hasta;
    private boolean disabledBuscar = true;
    private String estado = "T";
    private final String estadoPerfil;
    private final String estadoAprob;
    private final String displayReporte = null;
    private Long nroContrato;
    private boolean anularContrato;
    private EstadoSolicContrato esc;
    private Long nroSolic;
    private String tipoListado = "O";
    private final String subsistema;
    private final ConfigurarRepositorio configRep;

    public class ContratoArea {

        private final String area;
        private final List<ContratoDocente> listaContratos = new ArrayList<ContratoDocente>();

        public ContratoArea(String area) {
            this.area = area;
        }

        public String getArea() {
            return area;
        }

        public List<ContratoDocente> getListaContratos() {
            return listaContratos;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + (this.area != null ? this.area.hashCode() : 0);
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
            final ContratoArea other = (ContratoArea) obj;
            return !((this.area == null) ? (other.area != null) : !this.area.equals(other.area));
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    public String getTipoListado() {
        return tipoListado;
    }

    public void setTipoListado(String tipoListado) {
        this.tipoListado = tipoListado;
    }

    public Long getNroSolic() {
        return nroSolic;
    }

    public void setNroSolic(Long nroSolic) {
        this.nroSolic = nroSolic;
    }

    public List<EstadoSolicContrato> getHistoriaEstados() {
        return historiaEstados;
    }

    public EstadoSolicContrato getEsc() {
        return esc;
    }

    public void setEsc(EstadoSolicContrato esc) {
        this.esc = esc;
    }

    public boolean isAnularContrato() {
        return anularContrato;
    }

    public void setAnularContrato(boolean anularContrato) {
        this.anularContrato = anularContrato;
    }

    public boolean isDisabledBuscar() {
        return disabledBuscar;
    }

    public List<ContratoArea> getContratosDocentes() {
        return contratosDocentes;
    }

    public ContratoDocente getContratoSelected() {
        return contratoSelected;
    }

    public void setContratoSelected(ContratoDocente contratoSelected) {
        this.contratoSelected = contratoSelected;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoPerfil() {
        return estadoPerfil;
    }

    public String getEstadoAprob() {
        return estadoAprob;
    }

    public ContratoDocente getContratoEdit() {
        return contratoEdit;
    }

    public void setContratoEdit(ContratoDocente contratoEdit) {
        this.contratoEdit = contratoEdit;
    }

    public String getDisplayReporte() {
        return displayReporte;
    }

    public Long getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(Long nroContrato) {
        this.nroContrato = nroContrato;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="validaciones ">
    public void validateFechas(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        disabledBuscar = false;
        if (value == null) {
            disabledBuscar = true;
            return;
        }

        //Leave the null handling of startDate to required="true"
        Object startDateValue = component.getAttributes().get("fechaInicio");
        if (startDateValue == null) {
            disabledBuscar = true;
            return;
        }

        Date startDate = (Date) startDateValue;
        Date endDate = (Date) value;
        if (endDate.before(startDate)) {
            disabledBuscar = true;
            FacesMessage msg = new FacesMessage(" La fecha Hasta debe ser mayor a la fecha Desde", " La fecha Final debe ser mayor a la fecha Desde");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public void validateNroContrato(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        if (contratoDocenteFacade.getOkNroContrato(value.toString())) {
            FacesMessage msg = new FacesMessage("Este N° de Contrato ya ha sido utilizado, cambielo", "Este N° de Contrato ya ha sido utilizado, cambielo");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public void validateFechaContrato() {
        if (contratoEdit.getRolDocente().getRdoCodigo().equals("D")) {
            if (contratoEdit.getCdoFechaGenContr().compareTo(contratoEdit.getCdoFecfin()) > 0) {
                JsfUtil.addWarnMessage(null, "Este Contrato será una constancia");
            }
        }
    }

//</editor-fold>    
    /**
     * Creates a new instance of AprobContrJSFManagedBean
     */
    public RevisImprJSFManagedBean() {
        super.setPosicionYMant("top");
        this.usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        subsistema = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("subsist").toString();
        estadoPerfil = "R"; // autorizadas por rectorado
        estadoAprob = "P";
        tipoListado = "O";
        estado = estadoPerfil;
        String dirPrincipal = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.principal");
        String dirStorage = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.storage");
        configRep = new ConfigurarRepositorio(dirPrincipal, dirStorage);
    }

    public void resetCampo(String s) {
        if (s.equals("fecha")) {
            hasta = null;
        } else if (contratoEdit.getEstadoContrato().equals("R")) {
            nroContrato = null;
            contratoEdit.setCdoRevisadoPor(null);
            contratoEdit.setCdoFechaGenContr(null);
        }
    }

    public void buscarButton_processAction() {
        int index = 0;
        if (estado == null) {
            return;
        }
        if (desde == null || hasta == null) {
            return;
        }
        contratosDocentes.clear();
        List<ContratoDocente> temp = contratoDocenteFacade.findByEstado(estado, estadoPerfil, estadoAprob, desde, hasta, nroSolic, tipoListado);
        for (ContratoDocente ctr : temp) {
            ContratoArea ca = new ContratoArea(ctr.getAreaContrato());
            if (contratosDocentes.contains(ca)) {
                contratosDocentes.get(contratosDocentes.lastIndexOf(ca)).getListaContratos().add(ctr);
            } else {
                ca.getListaContratos().add(ctr);
                contratosDocentes.add(ca);
            }
        }
        for (ContratoArea ctr : contratosDocentes) {
            index++;
            for (ContratoDocente ctr1 : ctr.getListaContratos()) {
                ctr1.setFila(new Long(index));
                index++;
            }
        }
        nroSolic = null;
    }

    private String reporte;

    private void verContratoSp() {
        String urlReporte = "path=GestionAdmin&nroSolic=" + contratoSelected.getCdoCodigo().toString();
        if (contratoSelected.getRolDocente().getRdoCodigo().equals("I")) {
            reporte = "contratoBecaInvest";
        } else if (contratoSelected.getRolDocente().getRdoCodigo().equals("D")) {
            reporte = "contrato";
        } else {
            reporte = "contratoTesis";
        }
        urlReporte = urlReporte + "&reporte=" + reporte;
//        System.out.println(urlReporte);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", urlReporte);
    }

    private void recuperarContrato() {
        try {
            contratoEdit = contratoSelected.clone();
            nroContrato = (contratoEdit.getCdoNumero() != null ? new Long(contratoEdit.getCdoNumero()) : null);
            anularContrato = (contratoEdit.getEstadoContrato().equals("X"));
            esc = estadoSolicContratoFacade.find(new EstadoSolicContratoPK(contratoEdit.getCdoCodigo(), new Short("1"), "P"));
            if (esc == null) {
                esc = new EstadoSolicContrato(new EstadoSolicContratoPK());
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SolicContratoJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarButton_processAction() {
        this.setPaginaMant("/pages/opcion/regImprContrato");
        super.editarButton_processAction(null);
        recuperarContrato();
        verContratoSp();
        RequestContext.getCurrentInstance().execute("widgetContrato.selectRow(" + (contratoSelected.getFila()) + ");");
        RequestContext.getCurrentInstance().update("formMant:panelMant");
        RequestContext.getCurrentInstance().update("formMant:pnlPdfDialog");
    }

    //<editor-fold defaultstate="collapsed" desc="FIRMAR CONTRATOS Y NOTIFICAR">
    public void firmarButton_processAction(ActionEvent ae) {
        if (contratoEdit.getCdoNumero() != null) {
            if (contratoDocenteFacade.getContratoParaFirmar(contratoEdit.getCdoCodigo()) == null) {
                try {
                    generarContratoParaFirmaElectronica();
//                    if (contratoEdit.getContratado().getTipoDoc().equals("C")) {
//                        // Si se trata de un docente local,  se genera el documento al Sr. Rector - se valida si el documento es una cédula(C)
                        notificarRectorado();
//                    } else {
//                        // Si se trata del exterior,  se genera el documento al Docente - se valida si el documento es una cédula(P)
//                        notificarDocente();
//                    }
                    super.getNavigationJSFManagedBean().setIconMensaje("visto.jpg");
                    super.getNavigationJSFManagedBean().setMensaje("El contrato para la solocitud: " + contratoEdit.getCdoCodigo() + " ha sido creado y enviado ");
                    buscarButton_processAction();
                    RequestContext.getCurrentInstance().update("formSolic:dataContrato");
                    RequestContext.getCurrentInstance().execute("mantWidget.hide();");
                } catch (Exception ex) {
                    super.getNavigationJSFManagedBean().setIconMensaje("error.png");
                    super.getNavigationJSFManagedBean().setMensaje("ERROR: " + ex.getMessage() + ".</br></br> Por favor comuniquese con la Unidad de Sitemas de Información. Gracias ");
                } finally {
                    RequestContext.getCurrentInstance().update("dialogMessage");
                    RequestContext.getCurrentInstance().execute("mensajeWidget.show();");
                }
            }
        }
    }

    private void generarContratoParaFirmaElectronica() throws Exception, SQLException {
        Map<String, Object> params = new HashMap<String, Object>();

        String rep = configRep.getPathReportes("GestionAdmin") + reporte + "_temp.jasper";
        String[] pathRepositorio = {"Contratos", "Docentes"};
        String docuXfirmar = configRep.getPathDoc(pathRepositorio) + contratoEdit.getCdoCodigo() + "_" + contratoEdit.getCdoNumero() + "_temp.pdf";

        try {
            params.put("REPORT_PATH_IMAGES", configRep.getPathImage());
            params.put("nroSolic", contratoEdit.getCdoCodigo().toString());
            contratoDocenteFacade.genDocuParaFirma(rep, docuXfirmar, params, contratoEdit);
            File files = new File(docuXfirmar);
            if (files.exists()) {
                contratoEdit.setCdoListoFirmaElectronica("S");
                contratoEdit.setCdoFechaListoFirma(new Date());
                contratoDocenteFacade.edit(contratoEdit);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private void notificarRectorado() {
        StringBuilder mensaje;
        // notificar al Rectorado
        try {
            mensaje = new StringBuilder("<span style=\"color:blue;font-weight:bold;\">Solicitud de firma en contrato ");
            if (contratoEdit.getRolDocente().getRdoCodigo().equals("D")) {
                mensaje.append("para: </span>");
            } else {
                mensaje.append("para '").append(contratoEdit.getRolDocente().getRdoDescripcion()).append("' a:</span> ");
            }
            mensaje.append("</br></br>");
            mensaje.append("<span style=\"color:blue;font-weight:bold;\">").append(contratoEdit.getContratado().getNombresApellidos()).append("</span>").append("</br></br>");
            mensaje.append(contratoDocenteFacade.getMensaje(contratoEdit)).append("</br></br>")
                    .append("Por favor, le solicitamos firmar el contrato de manera electrónica. ").append("</br></br>");
            mensaje.append("Recuerde que para hacerlo debe:").append("</br></br>")
                    .append("<ul>")
                    .append("<li>Ingresar al 'Portal Gestión Administrativa' </li>")
                    .append("<li>En el Menú Principal escoger 'Opciones / Firma de contratos'</li>")
                    .append("<li>Ubicar el contrato a firmar, a través del número de solicitud en la columna 'Nro.'</li>")
                    .append("<li>Proceder a firmar, haciendo clic en el icono 'verde' de la columna 'Firma Rector'</li>")
                    .append("</ul> ");
//             
            mensaje.append("</br></br>").append("Si tiene alguna pregunta comuníquese con Procuraduría de la Universidad Andina Simón Bolívar").append("</br></br>");
//            contratoDocenteFacade.enviaCorreo("Soporte Servicios", "victor.barba@uasb.edu.ec", "juancarlos.lozada@uasb.edu.ec;", null, "Solicitud de Firma en contrato", mensaje.toString(), "HTML");
            contratoDocenteFacade.enviaCorreo("Soporte Servicios", "cesar.montano@uasb.edu.ec", "german.granda@uasb.edu.ec;mariaelena.izurieta@uasb.edu.ec;jessica.jacome@uasb.edu.ec;juancarlos.lozada@uasb.edu.ec", "victor.barba@uasb.edu.ec", "Solicitud de Firma en contrato", mensaje.toString(), "HTML");

        } catch (SQLException ex) {
            Logger.getLogger(RevisImprJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            super.getNavigationJSFManagedBean().setIconMensaje("error.png");
            super.getNavigationJSFManagedBean().setMensaje(ex.getMessage() + "</br></br> Por favor comuniquese con la Unidad de Sitemas de Información. Gracias ");
        }
    }

//    private void notificarDocente() {
//        // notificar al Docente
//        String emailSecre = contratoDocenteFacade.getEmailUsuario(contratoSelected.getCdoUsuCrea());
//        String emailProfe = contratoSelected.getContratado().getEmailContratado();
//        StringBuilder notifDocente = new StringBuilder("<span style=\"color:blue;font-weight:bold;\">Solicitud de firma en contrato </span></br></br>");
//        notifDocente.append("Estimado <span style=\"color:blue;font-weight:bold;\">").append(contratoSelected.getContratado().getNombresApellidos()).append("</span>").append("</br></br>")
//                .append("Su contrato se encuentra listo para su firma. ").append("</br></br>")
//                .append(contratoDocenteFacade.getMensaje(contratoSelected)).append("</br></br>")
//                .append("Por favor, le solicitamos que para legalizar su contrato proceda a firmarlo y luego reenviarlo a la Secretaria del Área correspondiente. ").append(emailSecre).append("</br></br>")
//                .append("Recuerde que para firmar su contrato debe:").append("</br></br>")
//                .append("<ul>")
//                .append("<li>Ingresar al Portal Docente (Evaluaciones - Sílabo)</li>")
//                .append("<li>En el Menú Principal escoger la opción 'Contratos / contratos del docente'</li>")
//                .append("<li>Ubicar el contrato a firmar</li>")
//                .append("<li>Descargarlo, firmarlo y enviarlo adjunto al correo, indicando que ya lo ha firmado.</li>")
//                .append("</ul> ")
//                .append("</br></br>").append("Si tiene alguna pregunta comuníquese con la Procuraduría de la Universidad Andina Simón Bolívar");
//        try {
////            contratoDocenteFacade.enviaCorreo("Soporte Servicios", emailProfe, emailSecre + ";paulina.sarmiento@uasb.edu.ec;juancarlos.lozada@uasb.edu.ec;", "victor.barba@uasb.edu.ec", "Solicitud de Firma en contrato", notifDocente.toString(), "HTML");
//        contratoDocenteFacade.enviaCorreo("Soporte Servicios", "victor.barba@uasb.edu.ec", "juancarlos.lozada@uasb.edu.ec;", "", "Solicitud de Firma en contrato", notifDocente.toString(), "HTML");
//        } catch (SQLException ex) {
//            Logger.getLogger(RevisImprJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//            super.getNavigationJSFManagedBean().setIconMensaje("error.png");
//            super.getNavigationJSFManagedBean().setMensaje(ex.getMessage() + "</br></br> Por favor comuniquese con la Unidad de Sitemas de Información. Gracias ");
//        }
//    }

//</editor-fold>
    @Override
    public void guardarButton_processAction(ActionEvent ae) {
        StringBuilder mensaje;
        try {
            contratoEdit.setCdoUsuModif(usr.getUsuCodigo());
            contratoEdit.setCdoFechaModif(new Date());
            if (!anularContrato) {
                contratoEdit.setCdoNumero(nroContrato.toString());
                esc.setEscCodigoUsr(contratoEdit.getCdoUsuModif());
                esc.setEscFecha(contratoEdit.getCdoFechaModif());
                esc.setEstadoSolicContratoPK(new EstadoSolicContratoPK(contratoEdit.getCdoCodigo(), null, "P"));
            } else {
                esc.setEstadoSolicContratoPK(new EstadoSolicContratoPK(contratoEdit.getCdoCodigo(), null, "X"));
                esc.setEscFecha(contratoEdit.getCdoFechaModif());
            }
            esc.setContratoDocente(contratoEdit);
            estadoSolicContratoFacade.create(esc);
            buscarButton_processAction();
            RequestContext.getCurrentInstance().update("formSolic:dataContrato");
            super.getNavigationJSFManagedBean().setIconMensaje("visto.jpg");
            super.getNavigationJSFManagedBean().setMensaje((!anularContrato ? "Contrato generado con exito. " : "Contrato Anulado !"));
            if (anularContrato) {
                super.guardarButton_processAction(ae);
                try {
                    Usuario usrOrigen = usuarioFacade.getUsuarioByCodigo(contratoEdit.getCdoUsuCrea());
                    if (usrOrigen != null) {
                        String eMailSigPerfil = usrOrigen.getUsuEmail();
                        if (eMailSigPerfil != null) {
                            mensaje = new StringBuilder("Solicitud de Contratación Anulada de Docente:</br></br>").append(eMailSigPerfil).append("</br></br>");
                            mensaje.append(contratoEdit.getContratado().getNombresApellidos()).append("</br></br>");
                            mensaje.append("Ha sido ANULADA por procuraduría. El motivo es:").append("</br></br>");
                            mensaje.append("<span style=\"color:blue;font-weight:bold;\">").append(esc.getEscObservacion().toUpperCase()).append("</span>").append("</br></br>");
                            mensaje.append("Si tiene alguna pregunta comuniquese con Procuraduría.").append("</br></br>");
//                            contratoDocenteFacade.enviaCorreo("Soporte Servicios", "victor.barba@uasb.edu.ec", "", "juancarlos.lozada@uasb.edu.ec;", "Solicitud de Contratación Anulada de Docente", mensaje.toString(), "HTML");
                            contratoDocenteFacade.enviaCorreo("Soporte Servicios", eMailSigPerfil, "", "", "Solicitud de Contratación Anulada de Docente", mensaje.toString(), "HTML");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RevisImprJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                    super.getNavigationJSFManagedBean().setIconMensaje("error.png");
                    super.getNavigationJSFManagedBean().setMensaje(ex.getMessage() + "</br></br> Por favor comuniquese con la Unidad de Sitemas de Información. Gracias ");
                }
            } else {
                recuperarContrato();
                verContratoSp();
                RequestContext.getCurrentInstance().reset("formMant:panelMant");
                RequestContext.getCurrentInstance().update("formMant:pnlPdfDialog");
                if (contratoEdit.getCdoNumero() != null) {
                    // ya tiene numero de contrato
//                    if (contratoEdit.getContratado().getTipoDoc().equals("C")) {
                        // Solo si se trata de un docente local,  se genera el documento al Sr. Rector - se valida si el documento es una cédula(C)
                        if (contratoDocenteFacade.getContratoParaFirmar(contratoEdit.getCdoCodigo()) == null) {
                            // no se ha generado el pdf para firma, entonces lo genera
                            generarContratoParaFirmaElectronica();
                            notificarRectorado();
                        }
//                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RevisImprJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            super.getNavigationJSFManagedBean().setIconMensaje("error.png");
            super.getNavigationJSFManagedBean().setMensaje(ex.getMessage() + "</br></br> Por favor comuniquese con la Unidad de Sitemas de Información. Gracias ");
        } finally {
            RequestContext.getCurrentInstance().update("dialogMessage");
            RequestContext.getCurrentInstance().execute("mensajeWidget.show();");
        }
    }

    public void verDocumentoButton_processAction() {
        super.setPaginaMant("/pages/opcion/verDocumento");
        super.setPosicionYMant("top");
        super.getNavigationJSFManagedBean().setBaseJSFManagedBean(this);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        session.setAttribute("contrato", contratoSelected);
        String[] pathRepositorio = {"Contratos", "Docentes"};
        session.setAttribute("pathRepositorio", pathRepositorio);

        session.setAttribute("paramDocumento", contratoSelected.getCdoCodigo() + "_" + contratoSelected.getCdoNumero() + ".pdf");
        RequestContext.getCurrentInstance().execute("mantWidget.show();");
        RequestContext.getCurrentInstance().update("formMant");

    }

}
