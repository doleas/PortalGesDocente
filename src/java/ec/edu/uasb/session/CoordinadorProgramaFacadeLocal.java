/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.CoordinadorPrograma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface CoordinadorProgramaFacadeLocal {

    void create(CoordinadorPrograma coordinadorPrograma);

    void edit(CoordinadorPrograma coordinadorPrograma);

    void remove(CoordinadorPrograma coordinadorPrograma);

    CoordinadorPrograma find(Object id);

    List<CoordinadorPrograma> findAll();

    List<CoordinadorPrograma> findRange(int[] range);

    int count();

    public List<CoordinadorPrograma> getProgramasByCoordAnio(Long codArea, Long anio);

}
