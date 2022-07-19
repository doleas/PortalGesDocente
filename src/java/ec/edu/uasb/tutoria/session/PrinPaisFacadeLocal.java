/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.PrinPais;
import ec.edu.uasb.tutoria.entities.PrinPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface PrinPaisFacadeLocal {

    void create(PrinPais prinPais);

    void edit(PrinPais prinPais);

    void remove(PrinPais prinPais);

    PrinPais find(Object id);

    List<PrinPais> findAll();

    List<PrinPais> findRange(int[] range);

    int count();

  
}
