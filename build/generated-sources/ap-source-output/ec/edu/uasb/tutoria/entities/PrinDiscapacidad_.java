package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.PrinPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(PrinDiscapacidad.class)
public class PrinDiscapacidad_ { 

    public static volatile SingularAttribute<PrinDiscapacidad, Short> disCodigo;
    public static volatile ListAttribute<PrinDiscapacidad, PrinPersona> prinPersonaList;
    public static volatile SingularAttribute<PrinDiscapacidad, String> disNombre;

}