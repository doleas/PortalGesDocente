/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.session;

import ec.edu.uasb.seg.entities.Usuario;
import ec.edu.uasb.vinculacion.external.entities.AreaAcademica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author xavier.duque
 */
@Stateless
public class AreaAcademicaFacade extends AbstractFacade<AreaAcademica> implements AreaAcademicaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaAcademicaFacade() {
        super(AreaAcademica.class);
    }

    @Override
    public String getNombreArea(Short codArea) {
        Query q = em.createNativeQuery("select NOMBRE_AREA FROM (SELECT  ARE_CODIGO CODIGO,NOMBRE_AREA FROM interfaseOcu.dbo.AREA  "
                + "UNION SELECT  DEP_CODIGO,DEP_NOMBRE  FROM interfaseOcu..DEPARTAMENTO_ADMI ) AREA where CODIGO = ? ").setParameter(1, codArea);
        return (String) q.getSingleResult();
    }

    @Override
    public List<AreaAcademica> getListaAreasInteres() {
        Query q = em.createNativeQuery("SELECT ARE_CODIGO,NOMBRE_AREA FROM interfaseOcu.dbo.AREA ORDER BY 2", AreaAcademica.class);
        return q.getResultList();
    }

    @Override
    public List<AreaAcademica> getListaAreasDepartamentos() {
        Query q = em.createNativeQuery("SELECT ARE_CODIGO,NOMBRE_AREA FROM interfaseOcu.dbo.AREA "
                + "UNION SELECT DEP_CODIGO, DEP_NOMBRE  FROM interfaseOcu..DEPARTAMENTO_ADMI ORDER BY 2", AreaAcademica.class);
        return q.getResultList();
    }

    @Override
    public Long areasByUsuario(Long codUsr) {
        Query q = em.createNativeQuery("SELECT  distinct TIN_CODIGO FROM V_USUARIO1 inner join interfaseOcu.GESTIONACADEMICA.TUT_INSTANCIA on dbo.V_USUARIO1.DEP_CODIGO = interfaseOcu.GESTIONACADEMICA.TUT_INSTANCIA.DEP_CODIGO\n"
                + " where dbo.V_USUARIO1.CODIGO = ?").setParameter(1, codUsr);
        return  Long.parseLong(q.getSingleResult().toString());
    }

}
