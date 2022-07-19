/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutSolicitudTutoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface TutSolicitudTutoriaFacadeLocal {

    void create(TutSolicitudTutoria tutSolicitudTutoria);

    void edit(TutSolicitudTutoria tutSolicitudTutoria);

    void remove(TutSolicitudTutoria tutSolicitudTutoria);

    TutSolicitudTutoria find(Object id);

    List<TutSolicitudTutoria> findAll();

    List<TutSolicitudTutoria> findRange(int[] range);

    int count();

    public List<String[]> findRequest(long codInstancia, int anio, String estado);

    public java.util.List ejecutaSqlList(java.lang.String sql);

    public void solicitudTutoriaCalendarizacion(Long codigoSolicitud);

}
