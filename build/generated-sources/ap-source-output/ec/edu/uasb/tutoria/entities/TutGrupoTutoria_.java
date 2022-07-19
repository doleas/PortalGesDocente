package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.TutSolicitudTutoria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(TutGrupoTutoria.class)
public class TutGrupoTutoria_ { 

    public static volatile SingularAttribute<TutGrupoTutoria, Date> tgtFechaCrea;
    public static volatile SingularAttribute<TutGrupoTutoria, String> tgtUsuarioModifica;
    public static volatile SingularAttribute<TutGrupoTutoria, Long> tgtCodigo;
    public static volatile SingularAttribute<TutGrupoTutoria, String> tgtUsuarioCrea;
    public static volatile SingularAttribute<TutGrupoTutoria, Date> tgtFechaModifica;
    public static volatile SingularAttribute<TutGrupoTutoria, TutSolicitudTutoria> tstCodigoSolicitud;
    public static volatile SingularAttribute<TutGrupoTutoria, Long> tgtCodigoEstudiante;

}