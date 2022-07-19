/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TesisMonografia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface TesisMonografiaFacadeLocal {

    void create(TesisMonografia tesisMonografia);

    void edit(TesisMonografia tesisMonografia);

    void remove(TesisMonografia tesisMonografia);

    TesisMonografia find(Object id);

    List<TesisMonografia> findAll();

    List<TesisMonografia> findRange(int[] range);

    int count();

    public List<String[]> obtenerListaTutores(Integer codEst, Integer anio, String codPrograma);

}
