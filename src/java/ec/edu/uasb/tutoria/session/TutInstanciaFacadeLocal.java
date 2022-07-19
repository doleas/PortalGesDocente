/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutInstancia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marjorie.fiallos
 */
@Local
public interface TutInstanciaFacadeLocal {

    void create(TutInstancia tutInstancia);

    void edit(TutInstancia tutInstancia);

    void remove(TutInstancia tutInstancia);

    TutInstancia find(Object id);

    List<TutInstancia> findAll();

    List<TutInstancia> findRange(int[] range);

    int count();

    public List<TutInstancia> buscarCodigobyTipo(String tipo);

    public List<TutInstancia> mostrarInstancias();
}
