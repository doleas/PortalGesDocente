/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portalgesdocente.opcion.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.config.ConfigurarRepositorio;
import ec.edu.uasb.firma.FirmaElectronica;
import ec.edu.uasb.firma.FirmarPDF;
import ec.edu.uasb.firma.exception.FirmaException;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import ec.edu.uasb.portalgesdocente.entities.EstadoSolicContrato;
import ec.edu.uasb.portalgesdocente.session.ContratoDocenteFacadeLocal;
import ec.edu.uasb.seg.entities.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "firmaContratoBean")
@ViewScoped
public class FirmaContratoJSFManagedBean extends BaseJSFManagedBean implements Serializable {

    private static final long serialVersionUID = 20120444L;

    @EJB
    private ContratoDocenteFacadeLocal contratoDocenteFacade;

    private final Usuario usr;
    private ContratoDocente contratoSelected;

    private final List<ContratoArea> contratosDocentes = new ArrayList<ContratoArea>();
    private Date desde;
    private Date hasta;
    private boolean disabledBuscar = true;
    private String estado = "P";
    private final String displayReporte = null;
    private EstadoSolicContrato esc;
    private UploadedFile fileFirma;
    private String clavefirma = null;
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
    public EstadoSolicContrato getEsc() {
        return esc;
    }

    public void setEsc(EstadoSolicContrato esc) {
        this.esc = esc;
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

    public String getDisplayReporte() {
        return displayReporte;
    }

    public String getClavefirma() {
        return clavefirma;
    }

    public void setClavefirma(String clavefirma) {
        this.clavefirma = clavefirma;
    }

    public UploadedFile getFileFirma() {
        return fileFirma;
    }

    public void setFileFirma(UploadedFile fileFirma) {
        this.fileFirma = fileFirma;
    }
    //</editor-fold>

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

    /**
     * Creates a new instance of AprobContrJSFManagedBean
     */
    public FirmaContratoJSFManagedBean() {
        super.setPosicionYMant("top");
        this.usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        String dirPrincipal = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.principal");
        String dirStorage = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.storage");
        configRep = new ConfigurarRepositorio(dirPrincipal, dirStorage);
    }

    @Override
    public void init() {
        fileFirma = null;
        clavefirma = null;
        contratoSelected = null;
    }

    public void resetCampo(String s) {
        if (s.equals("fecha")) {
            hasta = null;
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
        List<ContratoDocente> temp = contratoDocenteFacade.findByFirmaElectronica(estado, desde, hasta);
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

    @Override
    public void editarButton_processAction(ActionEvent ae) {
        this.setPaginaMant("/pages/opcion/firmarContrato/passFirma");
        this.setClavefirma(null);
        contratoSelected = (ContratoDocente) ae.getComponent().getAttributes().get("contrato");
        RequestContext.getCurrentInstance().execute("widgetContrato.selectRow(" + contratoSelected.getFila() + ");");
        RequestContext.getCurrentInstance().update("formMant:panelMant");
        super.editarButton_processAction(ae);

    }

    //  <editor-fold defaultstate="collapsed" desc="FIRMAR CONTRATO">
    public void subirAchivo(FileUploadEvent event) {
        fileFirma = event.getFile();
    }

    private void notificarContratoFirmado() throws SQLException {

        String emailSecre = contratoDocenteFacade.getEmailUsuario(contratoSelected.getCdoUsuCrea());
        String emailProfe = contratoSelected.getContratado().getEmailContratado();

        StringBuilder notifDocente = new StringBuilder("<span style=\"color:blue;font-weight:bold;\">Solicitud de firma en contrato </span></br></br>");
        notifDocente.append("Estimado <span style=\"color:blue;font-weight:bold;\">").append(contratoSelected.getContratado().getNombresApellidos()).append("</span>").append("</br></br>")
                .append("Su contrato se encuentra firmado de manera electrónica por el Sr. Rector. ").append("</br></br>")
                .append(contratoDocenteFacade.getMensaje(contratoSelected)).append("</br></br>")
                .append("Por favor, le solicitamos que para legalizar su contrato proceda a firmarlo electrónicamente. ").append("</br></br>")
                .append("Recuerde que para firmar su contrato debe:").append("</br></br>")
                .append("<ul>")
                .append("<li>Ingresar al Portal Docente (Evaluaciones - Sílabo)</li>")
                .append("<li>En el Menú Principal escoger la opción 'Contratos / contratos del docente'</li>")
                .append("<li>Ubicar el contrato a firmar</li>")
                .append("<li>Firmar con su firma electrónica</li>")
                .append("</ul> ")
                .append("</br></br>").append("Si tiene alguna pregunta comuníquese con la Procuraduría de la Universidad Andina Simón Bolívar");
        contratoDocenteFacade.enviaCorreo("Soporte Servicios", emailProfe, emailSecre + ";paulina.sarmiento@uasb.edu.ec;juancarlos.lozada@uasb.edu.ec;", "victor.barba@uasb.edu.ec", "Solicitud de Firma en contrato", notifDocente.toString(), "HTML");
//        contratoDocenteFacade.enviaCorreo("Soporte Servicios", "victor.barba@uasb.edu.ec", "juancarlos.lozada@uasb.edu.ec;", "", "Solicitud de Firma en contrato", notifDocente.toString(), "HTML");
    }

    public void firmar() throws FirmaException, IOException {
        String[] pathRepositorio = {"Contratos", "Docentes"};

        String docAFirmar = configRep.getPathDoc(pathRepositorio) + contratoSelected.getCdoCodigo() + "_" + contratoSelected.getCdoNumero() + "_temp.pdf";
        String docFirmado = configRep.getPathDoc(pathRepositorio) + contratoSelected.getCdoCodigo() + "_" + contratoSelected.getCdoNumero() + "_tempD.pdf";

        try {
            if (contratoSelected.getCdoFechaCrea().compareTo((new SimpleDateFormat("dd/MM/yyyy")).parse("12/01/2022")) >= 0) {
                FirmarPDF.firmarDocumentoByArchivo(
                        new FirmaElectronica(fileFirma.getInputstream(), clavefirma),
                        docAFirmar, "SIGNED_BY_RECTOR", docFirmado, "Contratacion Docente");
            } else {
                // ********* ELIMINAR ESTA instruccion*********** es para contratos creados antes del 12/01/2022
                FirmarPDF.firmarDocumentoByArchivoContrato(
                        new FirmaElectronica(fileFirma.getInputstream(), clavefirma),
                        docAFirmar, "RECTOR", docFirmado, "Contratacion Docente", null);
                // * ***************************
            }
            notificarContratoFirmado();
            File file = new File(docFirmado);
            if (file.exists()) {
                // Eliminar el contrato plantilla
                File fileAfirmar = new File(docAFirmar);
                fileAfirmar.delete();
                //Actualizo los campos para indicar que el contrato ya esta firmado por Rector
                contratoSelected.setCdoFechaFirmaRector(new Date());
                contratoDocenteFacade.edit(contratoSelected);
            }
        } catch (FirmaException fe) {
            throw new FirmaException(FirmaContratoJSFManagedBean.class.getSimpleName() + "</br></br> " + fe.getMessage());
        } catch (IOException ex) {
            throw new FirmaException(FirmaContratoJSFManagedBean.class.getSimpleName() + "</br></br> " + ex.getMessage());
        } catch (SQLException ex) {
            throw new FirmaException(FirmaContratoJSFManagedBean.class.getSimpleName() + "</br></br> " + ex.getMessage());
        } catch (ParseException ex) {
            throw new FirmaException(FirmaContratoJSFManagedBean.class.getSimpleName() + "</br></br> " + ex.getMessage());
        }

    }

    @Override
    public void guardarButton_processAction(ActionEvent ae) {
        String msgError = null;
        RequestContext rc = RequestContext.getCurrentInstance();
        try {
            firmar();
            init();
            buscarButton_processAction();
            rc.update(":formSolic:dataContrato");
            super.getNavigationJSFManagedBean().setIconMensaje("visto.jpg");
            super.getNavigationJSFManagedBean().setMensaje("Contrato(s) Firmado(s) Electronicamente");
        } catch (FirmaException fe) {
            msgError = fe.getMessage();
        } catch (IOException ex) {
            msgError = ex.getMessage();
        } finally {
            if (msgError != null) {
                init();
                super.getNavigationJSFManagedBean().setIconMensaje("error.png");
                super.getNavigationJSFManagedBean().setMensaje(msgError);
            }
            rc.reset(":formMant:panelMant");
            rc.update("dialogMessage");
            rc.execute("mensajeWidget.show();");
            rc.execute("mantWidget.hide();");
            rc.execute("widgetContrato.unselectAllRows();");
        }

    }

//</editor-fold>
}
