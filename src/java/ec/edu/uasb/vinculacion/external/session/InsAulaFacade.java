/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.vinculacion.external.entities.InsAula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class InsAulaFacade extends AbstractFacade<InsAula> implements InsAulaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsAulaFacade() {
        super(InsAula.class);
    }
    
    @Override
    public List<String[]> getListaPisobyEdificio(String codEdificio) {       
        Query q = em.createNativeQuery("select DISTINCT EDIF_CODIGO,substring(TIPPLANTA_DESC,0,charindex('-',TIPPLANTA_DESC,1)-1 ) as piso"
                + " from gestionaulasSIU.dbo.VSIU_CLASIFICACION_INSTALACIONES"
                + " WHERE TIPINST_CODIGO NOT IN(13,4,12,14) "
                + " AND EDIF_DESC LIKE ? AND CLASINST_ESTADO='A' AND  substring(TIPPLANTA_DESC,0,charindex('-',TIPPLANTA_DESC,1)-1 ) NOT LIKE 'PLANTA BAJ' ");          
        q.setParameter(1, codEdificio);        
        return q.getResultList();
    }

    @Override
    public List<String[]> getListaInstalcionbyPiso(String piso,String codEdificio) {
       Query q = em.createNativeQuery("select DISTINCT INST_CODIGO,INST_DESC from gestionaulasSIU.dbo.VSIU_CLASIFICACION_INSTALACIONES"
                + " WHERE TIPINST_CODIGO NOT IN(13,4,12,14) "
                + " AND substring(TIPPLANTA_DESC,0,charindex('-',TIPPLANTA_DESC,1)-1 ) LIKE  ? AND CLASINST_ESTADO='A' AND EDIF_DESC LIKE ? ");          
        q.setParameter(1, piso); 
        q.setParameter(2, codEdificio); 
        return q.getResultList();
    }
    
}
