package ec.edu.uasb.tutoria.entities;

import ec.edu.uasb.tutoria.entities.PrinCiudad;
import ec.edu.uasb.tutoria.entities.PrinPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:04")
@StaticMetamodel(PrinPais.class)
public class PrinPais_ { 

    public static volatile SingularAttribute<PrinPais, Short> paiCodigoSniese;
    public static volatile ListAttribute<PrinPais, PrinPersona> prinPersonaList;
    public static volatile SingularAttribute<PrinPais, String> paiNombre;
    public static volatile SingularAttribute<PrinPais, Short> paiCodigo;
    public static volatile SingularAttribute<PrinPais, String> paiCodInter;
    public static volatile SingularAttribute<PrinPais, String> paiVocNacionalidad;
    public static volatile ListAttribute<PrinPais, PrinCiudad> prinCiudadList;
    public static volatile ListAttribute<PrinPais, PrinPersona> prinPersonaList1;
    public static volatile SingularAttribute<PrinPais, String> paiAbrev;

}