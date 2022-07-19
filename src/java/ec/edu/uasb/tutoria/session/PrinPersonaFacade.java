/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.PrinPersona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marjorie.fiallos
 */
@Stateless
public class PrinPersonaFacade extends AbstractFacade<PrinPersona> implements PrinPersonaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrinPersonaFacade() {
        super(PrinPersona.class);
    }

    @Override
    public PrinPersona findByCedula(String cedPass) {
        PrinPersona p = null;
        Query q = em.createNativeQuery("select prin_persona.* from prin_persona inner join PROFESOR on dbo.PRIN_PERSONA.PER_ID_DOC= dbo.PROFESOR.CED_PAS_PROFESOR where PRIN_PERSONA.PER_ID_DOC = ? ", PrinPersona.class);
        q.setParameter(1, cedPass);
//        Query q = em.createNamedQuery("PrinPersona.findByPerIdDoc").setHint("eclipselink.refresh", true).setParameter("perIdDoc", cedPass);
        try {
            p = (PrinPersona) q.getSingleResult();
        } catch (NoResultException e) {
        }
        return p;
    }

    @Override
    public List<String> findByNombres(String nombres) {

        Query q = em.createNativeQuery("WITH profesores(nombres)  \n"
                + "AS  \n"
                + "( select PROFESOR.NOMBRE_PROFESOR+' '+  PROFESOR.APELLIDO_PROFESOR  from prin_persona inner join PROFESOR on dbo.PRIN_PERSONA.PER_ID_DOC= dbo.PROFESOR.CED_PAS_PROFESOR )\n"
                + "SELECT  nombres  \n"
                + "FROM profesores \n"
                + "where nombres like '%" + nombres + "%'");
//        Query q = em.createNamedQuery("PrinPersona.findByPerIdDoc").setHint("eclipselink.refresh", true).setParameter("perIdDoc", cedPass);
        return q.getResultList();
    }

    @Override
    public PrinPersona findByNombrescod(String nombres) {
        PrinPersona p = null;
        Query q = em.createNativeQuery("WITH profesores (PER_CODIGO, PER_ID_DOC, PER_TIPO_DOC, PER_PRIMER_APELLIDO, PER_SEGUNDO_APELLIDO, PER_NOMBRES, PER_FECHA_NACIMIENTO, NAC_PAI_CODIGO, PER_SEXO, PER_GENERO, PER_ESTADO_CIVIL, PER_TERCERA_EDAD, PER_EMAIL, PER_CELULAR, PAI_CODIGO, CIU_CODIGO, PER_DIREC_DOM, PER_TELEFONO_DOM, DIS_CODIGO, PER_PRC_DISCAP, PER_NRO_CARNET_DISCAP, PER_OCUPACION_ACTUAL, PER_EMAIL_TRABAJO, PER_DIREC_TRABAJO, PER_LUGAR_TRABAJO, PER_TELEFONO_TRAB, BAN_CODIGO, PAI_NACIONALIDAD, PER_CUENTA_BANCO, PER_TIPO_CUENTA, PER_NUMERO_RUC, PER_AUTOIDENTIFICACION, PER_GRUPO_SANGUINEO, PER_SUSCRIPCION, PER_USUARIO, PER_FECHA_CREA, PER_FECHA_ACT, PER_USUARIO_ACT, PER_ENROL_CODIGO, PER_PROFESION, PER_ACEPTACION,nombres)  \n"
                + "AS  \n"
                + "( select prin_persona.*,PROFESOR.NOMBRE_PROFESOR+' '+  PROFESOR.APELLIDO_PROFESOR  from prin_persona inner join PROFESOR on dbo.PRIN_PERSONA.PER_ID_DOC= dbo.PROFESOR.CED_PAS_PROFESOR )\n"
                + "SELECT  PER_CODIGO, PER_ID_DOC, PER_TIPO_DOC, PER_PRIMER_APELLIDO, PER_SEGUNDO_APELLIDO, PER_NOMBRES, PER_FECHA_NACIMIENTO, NAC_PAI_CODIGO, PER_SEXO, PER_GENERO, PER_ESTADO_CIVIL, PER_TERCERA_EDAD, PER_EMAIL, PER_CELULAR, PAI_CODIGO, CIU_CODIGO, PER_DIREC_DOM, PER_TELEFONO_DOM, DIS_CODIGO, PER_PRC_DISCAP, PER_NRO_CARNET_DISCAP, PER_OCUPACION_ACTUAL, PER_EMAIL_TRABAJO, PER_DIREC_TRABAJO, PER_LUGAR_TRABAJO, PER_TELEFONO_TRAB, BAN_CODIGO, PAI_NACIONALIDAD, PER_CUENTA_BANCO, PER_TIPO_CUENTA, PER_NUMERO_RUC, PER_AUTOIDENTIFICACION, PER_GRUPO_SANGUINEO, PER_SUSCRIPCION, PER_USUARIO, PER_FECHA_CREA, PER_FECHA_ACT, PER_USUARIO_ACT, PER_ENROL_CODIGO, PER_PROFESION, PER_ACEPTACION  \n"
                + "FROM profesores \n"
                + "where nombres like '%" + nombres + "%'", PrinPersona.class);
        q.setParameter(1, nombres);
//        Query q = em.createNamedQuery("PrinPersona.findByPerIdDoc").setHint("eclipselink.refresh", true).setParameter("perIdDoc", cedPass);
        try {
            p = (PrinPersona) q.getSingleResult();
        } catch (NoResultException e) {
        }
        return p;
    }
}
