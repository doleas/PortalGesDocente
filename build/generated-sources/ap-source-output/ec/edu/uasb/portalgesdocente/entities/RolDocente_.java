package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import ec.edu.uasb.portalgesdocente.entities.Rubros;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(RolDocente.class)
public class RolDocente_ { 

    public static volatile SingularAttribute<RolDocente, String> rdoCodigo;
    public static volatile CollectionAttribute<RolDocente, ContratoDocente> contratoDocenteCollection;
    public static volatile SingularAttribute<RolDocente, String> rdoDescripcion;
    public static volatile SingularAttribute<RolDocente, Short> codNivelAcad;
    public static volatile SingularAttribute<RolDocente, String> rdoEstado;
    public static volatile SingularAttribute<RolDocente, Rubros> rubros;

}