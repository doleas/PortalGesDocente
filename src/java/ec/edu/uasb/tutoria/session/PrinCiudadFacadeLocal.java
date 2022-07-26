/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.PrinCiudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface PrinCiudadFacadeLocal {

    void create(PrinCiudad prinCiudad);

    void edit(PrinCiudad prinCiudad);

    void remove(PrinCiudad prinCiudad);

    PrinCiudad find(Object id);

    List<PrinCiudad> findAll();

    List<PrinCiudad> findRange(int[] range);

    int count();
    
}
