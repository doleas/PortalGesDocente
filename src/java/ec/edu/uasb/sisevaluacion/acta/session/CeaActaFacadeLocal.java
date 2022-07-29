/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.acta.session;

import ec.edu.uasb.entities.CoordinadorPrograma;
import ec.edu.uasb.sisevaluacion.acta.entities.CeaActa;
import ec.edu.uasb.tutoria.entities.TutParametroMensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface CeaActaFacadeLocal {

    void create(CeaActa ceaActa);

    void edit(CeaActa ceaActa);

    void remove(CeaActa ceaActa);

    CeaActa find(Object id);

    List<CeaActa> findAll();

    List<CeaActa> findRange(int[] range);

    int count();
    
    public CeaActa findByAreaProgAnio(Long codArea, Long codEsp, Long anio);
    
}
