package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.ContratoDocente;
import ec.edu.uasb.portalgesdocente.entities.HonorariosPK;
import ec.edu.uasb.portalgesdocente.entities.Rubros;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:04")
@StaticMetamodel(Honorarios.class)
public class Honorarios_ { 

    public static volatile SingularAttribute<Honorarios, BigDecimal> honCantidad;
    public static volatile SingularAttribute<Honorarios, HonorariosPK> honorariosPK;
    public static volatile SingularAttribute<Honorarios, Rubros> rubros;
    public static volatile SingularAttribute<Honorarios, ContratoDocente> contratoDocente;
    public static volatile SingularAttribute<Honorarios, BigDecimal> honValor;

}