/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TesisMonografia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marjorie.fiallos
 */
@Stateless
public class TesisMonografiaFacade extends AbstractFacade<TesisMonografia> implements TesisMonografiaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TesisMonografiaFacade() {
        super(TesisMonografia.class);
    }

    @Override
    public List<String[]> obtenerListaTutores(Integer codEst, Integer anio, String codPrograma) {
         Query q = em.createNativeQuery("SELECT DISTINCT COD_PROFESOR, NOMBRES_PROFESOR"
                + " FROM interfaseOcu.GESTIONACADEMICA.TESIS_MONOGRAFIA"
                + " where cod_Estudiante = ?"
                + " and CODIGO_ESP = ? and  "+anio+" between anio_Inicio and anio_Fin")
                .setParameter(1, codEst).setParameter(2, codPrograma);
        return q.getResultList();
    }

}
