/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.vinculacion.external.entities.Instalacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface InstalacionFacadeLocal {

    void create(Instalacion instalacion);

    void edit(Instalacion instalacion);

    void remove(Instalacion instalacion);

    Instalacion find(Object id);

    List<Instalacion> findAll();

    List<Instalacion> findRange(int[] range);

    int count();

    public List<Instalacion> getListaEdificios();    
    
}
