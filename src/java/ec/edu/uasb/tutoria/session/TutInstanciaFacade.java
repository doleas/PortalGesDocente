/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutInstancia;
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
public class TutInstanciaFacade extends AbstractFacade<TutInstancia> implements TutInstanciaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutInstanciaFacade() {
        super(TutInstancia.class);
    }

    @Override
    public List<TutInstancia> buscarCodigobyTipo(String tipo) {
        Query q = em.createQuery("select i.tinCodigo,i.tinNombre from TutInstancia i where i.tinTipo = :tinTipo").setParameter("tinTipo", tipo);
        return q.getResultList();
    }
    @Override
    public List<TutInstancia> mostrarInstancias() {
        Query q = em.createQuery("select i.tinCodigo,i.tinNombre from TutInstancia i");
        return q.getResultList();
    }

}
