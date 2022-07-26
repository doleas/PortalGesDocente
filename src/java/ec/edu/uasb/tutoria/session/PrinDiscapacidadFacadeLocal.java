/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.PrinDiscapacidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface PrinDiscapacidadFacadeLocal {

    void create(PrinDiscapacidad prinDiscapacidad);

    void edit(PrinDiscapacidad prinDiscapacidad);

    void remove(PrinDiscapacidad prinDiscapacidad);

    PrinDiscapacidad find(Object id);

    List<PrinDiscapacidad> findAll();

    List<PrinDiscapacidad> findRange(int[] range);

    int count();
    
}
