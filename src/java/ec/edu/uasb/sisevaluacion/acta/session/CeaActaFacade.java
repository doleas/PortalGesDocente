/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.sisevaluacion.acta.session;

import ec.edu.uasb.entities.CoordinadorPrograma;
import ec.edu.uasb.sisevaluacion.acta.entities.CeaActa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marjorie.fiallos
 */
@Stateless
public class CeaActaFacade extends AbstractFacade<CeaActa> implements CeaActaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CeaActaFacade() {
        super(CeaActa.class);
    }

    @Override
    public CeaActa findByAreaProgAnio(Long codArea, Long codEsp, Long anio) {
//        codArea = Long.parseLong("206");
//        codEsp = Long.parseLong("111");
//        anio = Long.parseLong("2022");
        CeaActa result = new CeaActa();
        try {
            Query query = em.createNativeQuery(" SELECT c.CEA_COD_ACTA, c.COD_AREA, c.CODIGO_PROG, c.ANIO, c.COD_EJERCICIO, c.CEA_NUMERO_ACTA, c.CEA_FECHA_REUNION, c.CEA_PARTICIPANTES, c.CEA_HORA_INICIO, "
                    + " c.CEA_HORA_FIN, c.CEA_ORDED_ASPECTOS_ACAD, c.CEA_ORDED_SOLICITUDES_EST, c.CEA_ORDED_ASPECTOS_ADM, c.CEA_RESOLUCION_COMITE, c.CEA_FIRMADO, c.CEA_FIRMADOPOR, "
                    + " c.CEA_FECHA_FIRMA, c.CEA_ESTADO FROM interfaseOcu.EVALUACION.CEA_ACTA c "
                    + " WHERE "
                    + " c.COD_AREA = ? "
                    + " AND c.CODIGO_PROG = ? "
                    + " AND c.ANIO = ? ", CeaActa.class)
                    .setParameter(1, codArea)
                    .setParameter(2, codEsp)
                    .setParameter(3, anio);
            result = (CeaActa) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
