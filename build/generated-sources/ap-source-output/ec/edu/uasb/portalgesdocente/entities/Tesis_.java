package ec.edu.uasb.portalgesdocente.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Tesis.class)
public class Tesis_ { 

    public static volatile SingularAttribute<Tesis, Long> codNum;
    public static volatile SingularAttribute<Tesis, String> aluDnialu;
    public static volatile SingularAttribute<Tesis, String> nombres;
    public static volatile SingularAttribute<Tesis, Short> codNivelAcad;
    public static volatile SingularAttribute<Tesis, Long> plaCodalf;
    public static volatile SingularAttribute<Tesis, String> tema;
    public static volatile SingularAttribute<Tesis, Date> fechaIni;
    public static volatile SingularAttribute<Tesis, Date> fechaFin;
    public static volatile SingularAttribute<Tesis, Long> docente;
    public static volatile SingularAttribute<Tesis, Long> expNumord;

}