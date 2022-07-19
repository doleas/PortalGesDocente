/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.EstudianteUltimamatricula;
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
public class EstudianteUltimamatriculaFacade extends AbstractFacade<EstudianteUltimamatricula> implements EstudianteUltimamatriculaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteUltimamatriculaFacade() {
        super(EstudianteUltimamatricula.class);
    }


    @Override
    public EstudianteUltimamatricula findStudent(Long cod) {
        EstudianteUltimamatricula estudiante = new EstudianteUltimamatricula();
        try {
            Query q = em.createNativeQuery("select DISTINCT TOP(1) COD_ESTUDIANTE, CED_PAS_ESTUDIANTE, NOM_ESTUDIANTE, APELL_ESTUDIANTE, MATRICULA, ANIO, CICLO, CODIGO_ESP, PROGRAMA, INICIO, FIN, CODIGO_FACULTAD, CODIGO_NIVEACAD, AREA, EJERCICIO, ANIO_INICIAL "
                    + " from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA WITH (NOLOCK)"
                    + " where COD_ESTUDIANTE = ? ORDER BY ANIO DESC", EstudianteUltimamatricula.class).setParameter(1, cod);
            estudiante = (EstudianteUltimamatricula) q.getSingleResult();
        } catch (NoResultException e) {
        }
        return estudiante;
    }

    @Override
    public List<String[]> obtenerListaCompañeros(int ejercicio, String codPrograma, Integer codEst) {
        Query q = em.createNativeQuery("select e.cod_Estudiante, UPPER(e.apell_Estudiante +' '+ e.nom_Estudiante) from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e where e.ejercicio  = ? and e.codigo_Esp  = ? and e.cod_Estudiante <> ? ORDER BY e.apell_Estudiante ASC ").setParameter(1, ejercicio).setParameter(2, codPrograma).setParameter(3, codEst);
        return q.getResultList();
    }

    @Override
    public List<String[]> obtenerListaCompañerosbycod(Integer codEst) {
        Query q = em.createNativeQuery("select distinct e.cod_Estudiante,UPPER(e.apell_Estudiante +' '+ e.nom_Estudiante) from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e where e.cod_Estudiante = ? ORDER BY e.apell_Estudiante ASC").setParameter(1, codEst);
        return q.getResultList();
    }

    @Override
    public Long findStudentbyCedula(String cedula) {
        Long c = 0L;
        try {
            Query q = em.createNativeQuery("select distinct e.cod_Estudiante from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e where e.ced_pas_estudiante  = ? ").setParameter(1, cedula);
            c = Long.parseLong(q.getSingleResult().toString());
        } catch (NoResultException e) {
        }
        return c;

    }

    @Override
    public List<String> findStudentbyNombres(String nombres) {
        Query q = em.createNativeQuery("WITH estudiantes (cod_Estudiante,nombres)  \n"
                + "AS  \n"
                + "(select distinct e.cod_Estudiante,upper(e.nom_Estudiante) +' '+ upper(e.apell_Estudiante) as estudiante from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e )\n"
                + "SELECT  nombres \n"
                + "FROM estudiantes  \n"
                + "where nombres like '%" + nombres + "%'");
        return q.getResultList();
    }

    @Override
    public Long findStudentbyNombrescod(String nombres) {
        Query q = em.createNativeQuery("WITH estudiantes (cod_Estudiante,nombres)  \n"
                + "AS  \n"
                + "(select distinct e.cod_Estudiante,upper(e.nom_Estudiante) +' '+ upper(e.apell_Estudiante) as estudiante from GESTIONACADEMICA.ESTUDIANTE_ULTIMAMATRICULA as e )\n"
                + "SELECT  cod_Estudiante \n"
                + "FROM estudiantes  \n"
                + "where nombres like '%" + nombres + "%'");
        return Long.parseLong(q.getSingleResult().toString());
    }

}
