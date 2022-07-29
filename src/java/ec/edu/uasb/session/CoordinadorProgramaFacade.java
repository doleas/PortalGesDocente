/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.CoordinadorPrograma;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victor.barba
 */
@Stateless
public class CoordinadorProgramaFacade extends AbstractFacade<CoordinadorPrograma> implements CoordinadorProgramaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoordinadorProgramaFacade() {
        super(CoordinadorPrograma.class);
    }

    @Override
    public List<CoordinadorPrograma> getProgramasByCoordAnio(Long areCodigo, Long anio) {
        List<CoordinadorPrograma> result = new ArrayList<CoordinadorPrograma>();
        try {
            Query query = em.createNativeQuery(" SELECT cp.CODIGO_ESP, cp.ARE_CODIGO, cp.ARE_NOMBRE, cp.COD_EJERCICIO, cp.ANIO, cp.NOMBRE_PROGRAMA, cp.NUM_PARALELOS, cp.APELLIDO_COORDINADOR, cp.NOMBRE_COORDINADOR "
                    + " FROM interfaseOcu.dbo.COORDINADOR_PROGRAMA cp "
                    + " WHERE "
                    + " cp.ARE_CODIGO = ? "
                    + " AND cp.ANIO = ? ", CoordinadorPrograma.class)
                    .setParameter(1, areCodigo)
                    .setParameter(2, anio);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
