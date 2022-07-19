/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.vinculacion.external.entities.AreaAcademica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier.duque
 */
@Local
public interface AreaAcademicaFacadeLocal {

    void create(AreaAcademica areaAcademica);

    void edit(AreaAcademica areaAcademica);

    void remove(AreaAcademica areaAcademica);

    AreaAcademica find(Object id);

    List<AreaAcademica> findAll();

    List<AreaAcademica> findRange(int[] range);

    int count();

    public List<AreaAcademica> getListaAreasInteres();

    public List<AreaAcademica> getListaAreasDepartamentos();

    public Long areasByUsuario(Long codUsr);

    public String getNombreArea(Short codArea);

}
