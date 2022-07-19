package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.PrinCiudadPK;
import ec.edu.uasb.tutoria.entities.PrinPais;
import ec.edu.uasb.tutoria.entities.PrinPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(PrinCiudad.class)
public class PrinCiudad_ { 

    public static volatile ListAttribute<PrinCiudad, PrinPersona> prinPersonaList;
    public static volatile SingularAttribute<PrinCiudad, PrinCiudadPK> prinCiudadPK;
    public static volatile SingularAttribute<PrinCiudad, PrinPais> prinPais;
    public static volatile SingularAttribute<PrinCiudad, String> ciuNombre;

}