package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.PrinPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(PrinBanco.class)
public class PrinBanco_ { 

    public static volatile ListAttribute<PrinBanco, PrinPersona> prinPersonaList;
    public static volatile SingularAttribute<PrinBanco, Short> banCodigo;
    public static volatile SingularAttribute<PrinBanco, String> banNombre;

}