/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.vinculacion.external.entities.InsAula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface InsAulaFacadeLocal {

    void create(InsAula insAula);

    void edit(InsAula insAula);

    void remove(InsAula insAula);

    InsAula find(Object id);

    List<InsAula> findAll();

    List<InsAula> findRange(int[] range);

    int count();

    public List<String[]> getListaPisobyEdificio(String codEdificio);
    
    public List<String[]> getListaInstalcionbyPiso(String piso,String codEdificio);
    
}
