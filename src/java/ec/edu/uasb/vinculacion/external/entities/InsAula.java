/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.vinculacion.external.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author johana.orozco
 */
@Entity
public class InsAula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "INST_CODIGO")
    private Long instCodigo;

    @Column(name = "INST_DESC")
    private String instDesc;

    @Column(name = "TIPPLANTA_DESC")
    private String tipplantaDesc;
     
    @JoinColumn(name = "EDIF_CODIGO", referencedColumnName = "EDIF_CODIGO")
    @ManyToOne
    private Instalacion edifCodigo;

    public InsAula() {
    }

    public Long getInstCodigo() {
        return instCodigo;
    }

    public void setInstCodigo(Long instCodigo) {
        this.instCodigo = instCodigo;
    }

    public String getInstDesc() {
        return instDesc;
    }

    public void setInstDesc(String instDesc) {
        this.instDesc = instDesc;
    }

    public String getTipplantaDesc() {
        return tipplantaDesc;
    }

    public void setTipplantaDesc(String tipplantaDesc) {
        this.tipplantaDesc = tipplantaDesc;
    }

    public Instalacion getEdifCodigo() {
        return edifCodigo;
    }

    public void setEdifCodigo(Instalacion edifCodigo) {
        this.edifCodigo = edifCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.instCodigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InsAula other = (InsAula) obj;
        if (!Objects.equals(this.instCodigo, other.instCodigo)) {
            return false;
        }
        return true;
    }

    public InsAula(Long instCodigo) {
        this.instCodigo = instCodigo;
    }

    @Override
    public String toString() {
        return "InsAula{" + "instCodigo=" + instCodigo + ", instDesc=" + instDesc + ", tipplantaDesc=" + tipplantaDesc + ", edifCodigo=" + edifCodigo + '}';
    }
    
    
}
