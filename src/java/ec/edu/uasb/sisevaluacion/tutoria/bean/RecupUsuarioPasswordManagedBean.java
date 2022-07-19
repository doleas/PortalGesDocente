/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ec.edu.uasb.bean.BaseJSFManagedBean;
import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.sisevaluacion.tutoria.session.ConsultaFacadeLocal;

import ec.edu.uasb.utils.JsfUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author johana.orozco
 */
@ManagedBean(name = "recusuEst")
@ViewScoped
public class RecupUsuarioPasswordManagedBean extends BaseJSFManagedBean implements Serializable {

    private String smnombre = null;
    private String smapellido = null;
    private String cedula;

    private List<String[]> listDatEst = new ArrayList<String[]>();
    private final Usuario usr;

    private String[] selectedDatEst;
    private String buscarPor = "C";

    /**
     * Creates a new instance of InfAnualDatDocManagedBean
     */
    @EJB
    private ConsultaFacadeLocal consultaFacade;

// <editor-fold defaultstate="collapsed" desc="DECLARACION VARIABLES">
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getBuscarPor() {
        return buscarPor;
    }

    public void setBuscarPor(String buscarPor) {
        this.buscarPor = buscarPor;
    }

    public String getSmnombre() {
        return smnombre;
    }

    public void setSmnombre(String smnombre) {
        this.smnombre = smnombre;
    }

    public String getSmapellido() {
        return smapellido;
    }

    public void setSmapellido(String smapellido) {
        this.smapellido = smapellido;
    }

    public List<String[]> getListDatEst() {
        return listDatEst;
    }

    public void setListDatEst(List<String[]> listDatEst) {
        this.listDatEst = listDatEst;
    }

    public String[] getSelectedDatEst() {
        return selectedDatEst;
    }

    public void setSelectedDatEst(String[] selectedDatEst) {
        this.selectedDatEst = selectedDatEst;
    }
    // </editor-fold>

    public RecupUsuarioPasswordManagedBean() {
        this.usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }

    public void resetValores() {
        if (buscarPor.equals("C")) {
            smapellido = null;
            smnombre = null;
        } else {
            cedula = null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="CARGAR TABLA ">    
    private void recuperaInfo() {
        Vector v = new Vector();
        listDatEst.clear();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT  * FROM (")
                .append("select ced_pas_estudiante cedula,UPPER( APELL_ESTUDIANTE) apellidos, UPPER(NOM_ESTUDIANTE) nombres,EMAIL, USUARIO, CLAVE, 'ESTUDIANTE' CONDICION from ESTUDIANTE ")
                //                .append(" UNION ")
                //                .append(" select CED_PAS_PROFESOR,UPPER( APELLIDO_PROFESOR), UPPER(NOMBRE_PROFESOR),EMAIL_PROFESOR, CED_PAS_PROFESOR,NR_MEMO, 'DOCENTE' from PROFESOR ")
                .append(") DATOS WHERE ");

        if (buscarPor.equals("C")) {
            sql.append(" cedula = '").append(cedula).append("'");
        } else {
            sql.append(" apellidos LIKE '").append(smapellido).append("%'");
            if (smnombre != null && smnombre.trim().length() != 0) {
                sql.append(" and nombres LIKE '").append(smnombre).append("%' ");
            }
        }
        v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());

        if (v.size() > 0) {
            for (int i = 0; i < v.size(); i++) {
                Object[] object = (Object[]) v.get(i);
                String[] asign;
                asign = new String[7];
                asign[0] = (object[0] == null ? null : object[0].toString());
                asign[1] = (object[1] == null ? null : object[1].toString());
                asign[2] = (object[2] == null ? null : object[2].toString());
                asign[3] = (object[3] == null ? null : object[3].toString());
                asign[4] = (object[4] == null ? null : object[4].toString());
                asign[5] = (object[5] == null ? null : object[5].toString());
                asign[6] = object[6].toString();
                listDatEst.add(i, asign);
            }
        }
    }

    public void profesorvalueChangeListener() {
        recuperaInfo();
    }

    public void enviarButton_processAction(ActionEvent ae) {
        StringBuilder mensaje = new StringBuilder();
        StringBuilder sql = new StringBuilder();
        Vector v = new Vector();
        String eMailSigPerfil = null;
        String msgAsunto = null;
        String emailCopia = null;
        String smtiper = null;
        if (selectedDatEst != null) {
            sql.append("SELECT dbo.F_CLASE_PERSONA('").append(selectedDatEst[0]).append("'), 1");
            v = (Vector) consultaFacade.ejecutaSqlList(sql.toString());
            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    Object[] object = (Object[]) v.get(i);
                    String[] asign;
                    asign = new String[2];
                    asign[0] = (object[0] == null ? null : object[0].toString());
                    asign[1] = (object[1] == null ? null : object[1].toString());
                    smtiper = (object[0] == null ? null : object[0].toString());
                }
            }
            try {
                //EMAIL PARA EL USUARIO QUE SOLICITA LA CONTRASEÑA
                eMailSigPerfil = selectedDatEst[2]; // email del usuario                  
                mensaje.append("Estimado(a):</br>").append("<b>").append(selectedDatEst[1]).append("</b>").append("</br></br>");
                if ("E".equals(smtiper)) {
                    mensaje.append("Su solicitud de Usuario-Clave fue procesada satisfactoriamente, con la siguiente información: ").append("</br></br>");
                    mensaje.append("<b>Usuario:</b> 	  	").append(selectedDatEst[3]).append("</br>");
                    mensaje.append("<b>Clave:</b> 	").append(selectedDatEst[4]).append("</br></br>");
                } else {
                    mensaje.append("En su calidad de funcionario de la Universidad las credenciales para ingresar a los sistemas son las mismas que usa para ingresar en el equipo de la universidad ").append("</br></br>");
                    mensaje.append("<b>Usuario:</b> 	  	Usuario del equipo</br>");
                    mensaje.append("<b>Clave:</b>          Clave del equipo</br></br>");
                }
                mensaje.append("<b>IMPORTANTE:</b> Las credenciales de USUARIO arriba detalladas, serán necesarias para su acceso a los Portales de la Universidad, <b>RECUÉRDELO.</b> ").append("</br></br>");
                mensaje.append("Este correo no requiere respuesta. ").append("</br></br>");
                mensaje.append("Saludos cordiales, ").append("</br>");
                mensaje.append("Universidad Andina Simón Bolívar- Sede Ecuador ").append("</br>");
////                System.out.println("Solicitud de Usuario-Clave "+mensaje);
                msgAsunto = "Solicitud de Usuario-Clave";
                consultaFacade.enviaCorreo("Soporte Servicios", eMailSigPerfil, emailCopia, "", msgAsunto, mensaje.toString(), "HTML");
//                //EMAIL DE VERIFICACION PARA LA PERSONA QUE REALIZO EL ENVIO
//                //EMAIL PARA EL USUARIO QUE SOLICITA LA CONTRASEÑA
                mensaje = new StringBuilder();
                eMailSigPerfil = usr.getUsuEmail();
                emailCopia = "victor.barba@uasb.edu.ec";
                mensaje.append("Estimado(a):</br> ").append(usr.getUsuApellUsuario()).append(" ").append(usr.getUsuNombreUsuario()).append(" ").append("</br></br>");
                mensaje.append("La solicitud de Usuario-Clave de ").append("<b>").append(selectedDatEst[1]).append("</b>").append(" fue procesada satisfactoriamente ").append("</br></br>");
                mensaje.append("Este correo no requiere respuesta. ").append("</br></br>");
                mensaje.append("Saludos cordiales, ").append("</br>");
                mensaje.append("Universidad Andina Simón Bolívar- Sede Ecuador ").append("</br>");
////                System.out.println("Procesamiento Solicitud de Usuario-Clave UASB "+mensaje);
                msgAsunto = "Procesamiento Solicitud de Usuario-Clave UASB";
                consultaFacade.enviaCorreo("Soporte Servicios", eMailSigPerfil, emailCopia, "", msgAsunto, mensaje.toString(), "HTML");
                RequestContext.getCurrentInstance().update("frecusuPass:tdatosDoc");
                RequestContext.getCurrentInstance().execute("mantWidget.hide();");
                JsfUtil.addSuccessMessage(null, "Datos Enviados");
            } catch (SQLException ex) {
                Logger.getLogger(RecupUsuarioPasswordManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
