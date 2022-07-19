/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.tutoria.session;

import ec.edu.uasb.tutoria.entities.TutSolicitudTutoria;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marjorie.fiallos
 */
@Stateless
public class TutSolicitudTutoriaFacade extends AbstractFacade<TutSolicitudTutoria> implements TutSolicitudTutoriaFacadeLocal {

    @PersistenceContext(unitName = "interfaseOCU_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutSolicitudTutoriaFacade() {
        super(TutSolicitudTutoria.class);
    }

    @Override
    public List<String[]> findRequest(long codInstancia, int anio, String estado) {
        Query q;
        if (estado.equals("A,O")) {
            q = em.createNativeQuery("select  TST_CODIGO, TST_TEMA,E.NOM_ESTUDIANTE +' '+E.APELL_ESTUDIANTE AS NOMBRE, CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'  WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END),TST_ASISTIO\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA AS S INNER JOIN interfaseOcu.dbo.ESTUDIANTE AS E\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = E.COD_ESTUDIANTE where S.TST_TIPO_SOLICITANTE='ESTUDIANTE'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO  IN ('A','O')  \n"
                    + " UNION \n"
                    + " select  TST_CODIGO, TST_TEMA, P.PER_NOMBRES +' '+P.PER_PRIMER_APELLIDO+' '+ P.PER_SEGUNDO_APELLIDO AS NOMBRE,CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'  WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END),TST_ASISTIO\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA AS S INNER JOIN interfaseOcu..PRIN_PERSONA AS P\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = P.PER_CODIGO  where S.TST_TIPO_SOLICITANTE='PROFESOR'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO IN ('A','O') \n"
                    + "ORDER BY TST_FECHA_CREA DESC")
                    .setParameter(1, codInstancia).setParameter(2, anio).setParameter(3, codInstancia).setParameter(4, anio);

        }
        else if (estado.equals("R,F")) {
            q = em.createNativeQuery("select  TST_CODIGO, TST_TEMA,E.NOM_ESTUDIANTE +' '+E.APELL_ESTUDIANTE AS NOMBRE, CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'  WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado por solicitante' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END),TST_ASISTIO\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA AS S INNER JOIN interfaseOcu.dbo.ESTUDIANTE AS E\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = E.COD_ESTUDIANTE where S.TST_TIPO_SOLICITANTE='ESTUDIANTE'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO  IN ('F','R')  \n"
                    + " UNION \n"
                    + " select  TST_CODIGO, TST_TEMA, P.PER_NOMBRES +' '+P.PER_PRIMER_APELLIDO+' '+ P.PER_SEGUNDO_APELLIDO AS NOMBRE,CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'   WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END,TST_ASISTIO)\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA AS S INNER JOIN interfaseOcu..PRIN_PERSONA AS P\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = P.PER_CODIGO  where S.TST_TIPO_SOLICITANTE='PROFESOR'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO IN ('F','R') \n"
                    + "ORDER BY TST_FECHA_CREA DESC")
                    .setParameter(1, codInstancia).setParameter(2, anio).setParameter(3, codInstancia).setParameter(4, anio);

        } else {
            q = em.createNativeQuery("select  TST_CODIGO, TST_TEMA,E.NOM_ESTUDIANTE +' '+E.APELL_ESTUDIANTE AS NOMBRE, CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'  WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END),TST_ASISTIO\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA AS S INNER JOIN interfaseOcu.dbo.ESTUDIANTE AS E\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = E.COD_ESTUDIANTE where S.TST_TIPO_SOLICITANTE='ESTUDIANTE'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO  IN (?)  \n"
                    + " UNION \n"
                    + " select  TST_CODIGO, TST_TEMA, P.PER_NOMBRES +' '+P.PER_PRIMER_APELLIDO+' '+ P.PER_SEGUNDO_APELLIDO AS NOMBRE,CONVERT(NVARCHAR, TST_FECHA_TUTORIA, 103) as fecha, (CASE TST_ESTADO_SOLICITADO WHEN 'C' THEN 'Cambio' WHEN 'S' THEN 'Solicitado' WHEN 'A' THEN 'Aprobado'  WHEN 'R' THEN 'Rechazado'  WHEN 'O' THEN 'Aprobado por solicitante'  WHEN 'F' THEN 'Rechazado' WHEN 'T' THEN 'Concluido' WHEN 'N' THEN 'Anulado' ELSE'' END ) as estado,TST_ASISTIO,TST_TIPO_TUTORIA, TST_FECHA_CREA, TST_HORA,(case WHEN TST_FECHA_TUTORIA  > CONVERT(varchar,getdate(),5) THEN 1 ELSE 0 END),TST_ASISTIO\n"
                    + " from interfaseOcu.GESTIONACADEMICA.TUT_SOLICITUD_TUTORIA as S INNER JOIN interfaseOcu..PRIN_PERSONA as P\n"
                    + " ON S.TST_CODIGO_SOLICITANTE = P.PER_CODIGO  where S.TST_TIPO_SOLICITANTE='PROFESOR'\n"
                    + " and S.TST_COD_INSTANCIA =  ? AND S.TST_ANIO_SOLICITUD = ? AND S.TST_ESTADO_SOLICITADO IN (?) \n"
                    + "ORDER BY TST_FECHA_CREA DESC")
                    .setParameter(1, codInstancia).setParameter(2, anio).setParameter(3, estado).setParameter(4, codInstancia).setParameter(5, anio).setParameter(6, estado);
        }
        return q.getResultList();
    }

    @Override
    public List ejecutaSqlList(String sql) {
        return em.createNativeQuery(sql).setParameter(1, sql).getResultList();
    }

     @Override
    public void solicitudTutoriaCalendarizacion(Long codigoSolicitud) {
        Query query = em.createNativeQuery("{call interfaseOcu.EVALUACION.sp_calendarizacion_encuesta_tutAcad(?)}");
        query.setParameter(1, codigoSolicitud); // codigoSolicitud
        query.executeUpdate();
    }

}
