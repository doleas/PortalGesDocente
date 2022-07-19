/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portalgesdocente.reportes.bean;

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.config.ConfigurarRepositorio;
import ec.edu.uasb.portalgesdocente.entities.RolDocente;
import ec.edu.uasb.portalgesdocente.session.RolDocenteFacadeLocal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author victor.barba
 */
@ManagedBean(name = "repConsultaContratosBean")
@ViewScoped
public class RepConsultaContratosJSFManagedBean extends BaseJSFManagedBean implements Serializable {

    @EJB
    private RolDocenteFacadeLocal rolDocenteFacade;
    @Resource(lookup = "jdbc/interfaseOCU")
    private DataSource dataSource;
    private static final long serialVersionUID = 20120499L;

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private String formatoReporte = "pdf";
    private boolean repVisible;
    private Date desde;
    private Date hasta;
    private String rol;
    private List<RolDocente> listaRoles = new ArrayList<RolDocente>();

    //<editor-fold defaultstate="collapsed" desc="Atributos">
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

    public boolean isRepVisible() {
        return repVisible;
    }

    public void setRepVisible(boolean repVisible) {
        this.repVisible = repVisible;
    }

    public String getFormatoReporte() {
        return formatoReporte;
    }

    public void setFormatoReporte(String formatoReporte) {
        this.formatoReporte = formatoReporte;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<RolDocente> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<RolDocente> listaRoles) {
        this.listaRoles = listaRoles;
    }
//</editor-fold>

    /**
     * Creates a new instance of ConsultaResidJSFManagedBean
     */
    public RepConsultaContratosJSFManagedBean() {
    }

    @Override
    public void init() {
        listaRoles = rolDocenteFacade.getRolByActivos();
    }

    public void resetFecha(String s) {
        hasta = null;
    }

    public void validateFechas(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //Leave the null handling of startDate to required="true"
        Object startDateValue = component.getAttributes().get("fechaInicio");
        if (startDateValue == null) {
            return;
        }

        Date startDate = (Date) startDateValue;
        Date endDate = (Date) value;
        if (endDate.before(startDate)) {
            FacesMessage msg = new FacesMessage(" La fecha Hasta debe ser mayor a la fecha Desde", " La fecha Final debe ser mayor a la fecha Desde");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public void resetPanelPDF() {
        repVisible = false;
    }

    private StreamedContent contenido;

    public StreamedContent getContenido() {
        return contenido;
    }

    public void setContenido(StreamedContent contenido) {
        this.contenido = contenido;
    }

    @Override
    public void imprimirButton_processAction(ActionEvent ae) {
        repVisible = true;
        String reporte = "repContraDocentes";
        String path = "GestionAdmin";
        if (formatoReporte.equals("pdf")) {
            String urlReporte = "pDesde=" + df.format(desde) + "&pHasta=" + df.format(hasta) + "&pRol=" + rol
                    + "&tipo=" + formatoReporte
                    + "&path=" + path
                    + "&reporte=" + reporte;
        System.out.println(urlReporte);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRep", urlReporte);
        } else {
            try {
                Connection con = dataSource.getConnection();
                RequestContext rc = RequestContext.getCurrentInstance();
                Map<String, Object> params = new HashMap<String, Object>();
                String dirPrincipal = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.principal");
                String dirStorage = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("directorio.storage");
                ConfigurarRepositorio configRep = new ConfigurarRepositorio(dirPrincipal, dirStorage);

                String urlContextoReporte = configRep.getPathReportes(path) + reporte + ".jasper";
                System.out.println("urlContextoReporte "+urlContextoReporte);
                try {
                    params.put("pDesde", df.format(desde));
                    params.put("pHasta", df.format(hasta));
                    params.put("pRol", rol);
                    params.put("REPORT_PATH_IMAGES", configRep.getPathImage());
                    params.put(JRParameter.REPORT_LOCALE, new Locale("es_EC"));

                    JasperPrint jasperPrint = JasperFillManager.fillReport(urlContextoReporte, params, con);

                    SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                    configuration.setOnePagePerSheet(true);
                    configuration.setIgnoreGraphics(false);

                    File outputFile = new File("D:\\optopt\\optoutput.xlsx");
                    SimpleOutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(outputFile);


                    JRXlsxExporter exporter = new JRXlsxExporter();
                    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                    exporter.setExporterOutput(exporterOutput);
                    exporter.setConfiguration(configuration);
                    exporter.exportReport();
                    
                    FileInputStream fileInputStream = new FileInputStream(outputFile);
                    contenido = new DefaultStreamedContent(fileInputStream);
//                   
                    //                    try {
                    //                    File outputFile = new File("output.xlsx");
                    //                        OutputStream fileOutputStream = new FileOutputStream(outputFile);
                    //                         byteArrayOutputStream.writeTo(fileOutputStream);
                    //                    } catch (IOException ex) {
                    //                        Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                    //                    }
                    //contenido = new DefaultStreamedContent(in, "application/vnd.ms-excel", "archivo");
                    //                } catch (FileNotFoundException ex) {
                    //                    super.getNavigationJSFManagedBean().setIconMensaje("error.png");
                    //                    super.getNavigationJSFManagedBean().setMensaje("Contrato no encontrado ! ");
                    //                    rc.update("dialogMessage");
                    //                    rc.execute("mensajeWidget.show();");
                    //                } catch (JRException ex) {
                    //                    Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(RepConsultaContratosJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//public void verContrato_processAction(ActionEvent ae) {
//        RequestContext rc = RequestContext.getCurrentInstance();
//        contratoSelected = (ContratoDocente) ae.getComponent().getAttributes().get("contrato");
//        String pathInicialtemp = this.getPath() + "Contratos" + separadorPath + "Docentes";
//        String archivoFirmado = pathInicialtemp + separadorPath + contratoSelected.getCdoCodigo() + "_" + contratoSelected.getCdoNumero() + ".pdf";
////        System.out.println("verContrato_processAction " + archivoFirmado);
//        try {
//
//            InputStream stream = new FileInputStream(new File(archivoFirmado));
//            contenido = new DefaultStreamedContent(stream, "application/pdf", contratoSelected.getCdoCodigo() + "_" + contratoSelected.getCdoNumero() + ".pdf");
//
//        } catch (FileNotFoundException ex) {
//            super.getNavigationJSFManagedBean().setIconMensaje("error.png");
//            super.getNavigationJSFManagedBean().setMensaje("Contrato no encontrado ! ");
//            rc.update("dialogMessage");
//            rc.execute("mensajeWidget.show();");
//        }
//    <p:fileDownload value="#{firmaContratoBean.contenido}"/>     ajax="false"
//    }
}
