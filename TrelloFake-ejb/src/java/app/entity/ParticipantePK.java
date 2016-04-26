/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author elmen
 */
@Embeddable
public class ParticipantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigInteger idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROYECTO")
    private BigInteger idproyecto;

    public ParticipantePK() {
    }

    public ParticipantePK(BigInteger idusuario, BigInteger idproyecto) {
        this.idusuario = idusuario;
        this.idproyecto = idproyecto;
    }

    public BigInteger getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigInteger idusuario) {
        this.idusuario = idusuario;
    }

    public BigInteger getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(BigInteger idproyecto) {
        this.idproyecto = idproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantePK)) {
            return false;
        }
        ParticipantePK other = (ParticipantePK) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.ParticipantePK[ idusuario=" + idusuario + ", idproyecto=" + idproyecto + " ]";
    }
    
}
