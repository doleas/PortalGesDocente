/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.vinculacion.external.entities.Instalacion;
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
public class InstalacionFacade extends AbstractFacade<Instalacion> implements InstalacionFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstalacionFacade() {
        super(Instalacion.class);
    }
    
    @Override 
    public List<Instalacion> getListaEdificios() {
        Query q = em.createNativeQuery("select DISTINCT EDIF_CODIGO, EDIF_DESC from gestionaulasSIU.dbo.VSIU_CLASIFICACION_INSTALACIONES",Instalacion.class);
        return q.getResultList();
    }
    
    
}
