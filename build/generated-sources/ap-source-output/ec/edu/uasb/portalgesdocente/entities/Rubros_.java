package ec.edu.uasb.portalgesdocente.entities;

import ec.edu.uasb.portalgesdocente.entities.DatosViajero;
import ec.edu.uasb.portalgesdocente.entities.Honorarios;
import ec.edu.uasb.portalgesdocente.entities.RolDocente;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20170112-rNA", date="2022-07-19T11:03:05")
@StaticMetamodel(Rubros.class)
public class Rubros_ { 

    public static volatile SingularAttribute<Rubros, String> rubDescripcion;
    public static volatile SingularAttribute<Rubros, BigDecimal> rubValorDocto;
    public static volatile SingularAttribute<Rubros, String> rubCategoria;
    public static volatile SingularAttribute<Rubros, String> rubUnimedida;
    public static volatile CollectionAttribute<Rubros, DatosViajero> datosViajeroCollection;
    public static volatile SingularAttribute<Rubros, Long> rubCodigo;
    public static volatile CollectionAttribute<Rubros, RolDocente> rolDocenteCollection;
    public static volatile SingularAttribute<Rubros, String> rubEstado;
    public static volatile SingularAttribute<Rubros, BigDecimal> rubValorMaes;
    public static volatile SingularAttribute<Rubros, BigDecimal> rubValorEspe;
    public static volatile CollectionAttribute<Rubros, Honorarios> honorariosCollection;

}