/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutParametroMensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface TutParametroMensajeFacadeLocal {

    void create(TutParametroMensaje tutParametroMensaje);

    void edit(TutParametroMensaje tutParametroMensaje);

    void remove(TutParametroMensaje tutParametroMensaje);

    TutParametroMensaje find(Object id);

    List<TutParametroMensaje> findAll();

    List<TutParametroMensaje> findRange(int[] range);

    int count();
    
}
