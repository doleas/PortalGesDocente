/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.tutoria.session;

import ec.edu.uasb.sisevaluacion.tutoria.entities.Encuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> implements EncuestaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }

    @Override
    public List<Encuesta> findAllActivo(char tipEncuesta) {
        return em.createNativeQuery("Select * "
                + " from  EVALUACION.encuesta p "
                + " where p.ESTADO = 'A'"
                + " AND p.TIPO =  '" + tipEncuesta + "'", Encuesta.class).getResultList();
    }

    @Override
    public List<Encuesta> findAllActivoSubTipo(char tipEncuesta, String subTipo) {
        StringBuilder sb = new StringBuilder("Select CODIGO_ENCUESTA, TITULO, REFERENCIA, DESCRIPCION, USO, ESTADO,  TIPO,SUBTIPO from  EVALUACION.encuesta p where p.ESTADO = 'A' ");
        sb.append(" AND p.TIPO =  '").append(tipEncuesta).append("'");
        if (subTipo == null) {
            sb.append(" AND p.SUBTIPO IS null");
        } else {
            sb.append(" AND p.SUBTIPO = '").append(subTipo).append("'");
        }
        return em.createNativeQuery(sb.toString(), Encuesta.class).getResultList();
    }
}
