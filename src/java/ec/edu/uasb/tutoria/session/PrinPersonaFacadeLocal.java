/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.PrinPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface PrinPersonaFacadeLocal {

    void create(PrinPersona prinPersona);

    void edit(PrinPersona prinPersona);

    void remove(PrinPersona prinPersona);

    PrinPersona find(Object id);

    List<PrinPersona> findAll();

    List<PrinPersona> findRange(int[] range);

    int count();

    public PrinPersona findByCedula(String cedPass);

    public PrinPersona findByNombrescod(String nombres);

    public List<String> findByNombres(String nombres);

}
