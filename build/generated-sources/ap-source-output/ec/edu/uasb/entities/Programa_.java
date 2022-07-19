package ec.edu.uasb.entities;

import ec.edu.uasb.entities.ProgramaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Programa.class)
public class Programa_ { 

    public static volatile SingularAttribute<Programa, ProgramaPK> programaPK;
    public static volatile SingularAttribute<Programa, Short> codNivelAcad;
    public static volatile SingularAttribute<Programa, String> nivelAcademico;
    public static volatile SingularAttribute<Programa, String> nombrePrograma;

}