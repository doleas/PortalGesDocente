/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutGrupoTutoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface TutGrupoTutoriaFacadeLocal {

    void create(TutGrupoTutoria tutGrupoTutoria);

    void edit(TutGrupoTutoria tutGrupoTutoria);

    void remove(TutGrupoTutoria tutGrupoTutoria);

    TutGrupoTutoria find(Object id);

    List<TutGrupoTutoria> findAll();

    List<TutGrupoTutoria> findRange(int[] range);

    int count();
    
}
