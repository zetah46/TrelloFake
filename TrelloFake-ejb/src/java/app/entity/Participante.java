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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elmen
 */
@Entity
@Table(name = "PARTICIPANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p"),
    @NamedQuery(name = "Participante.findByIdusuario", query = "SELECT p FROM Participante p WHERE p.participantePK.idusuario = :idusuario"),
    @NamedQuery(name = "Participante.findByIdproyecto", query = "SELECT p FROM Participante p WHERE p.participantePK.idproyecto = :idproyecto"),
    @NamedQuery(name = "Participante.findByRol", query = "SELECT p FROM Participante p WHERE p.rol = :rol")})
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipantePK participantePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ROL")
    private String rol;
    @JoinColumn(name = "IDPROYECTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Participante() {
    }

    public Participante(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public Participante(ParticipantePK participantePK, String rol) {
        this.participantePK = participantePK;
        this.rol = rol;
    }

    public Participante(BigInteger idusuario, BigInteger idproyecto) {
        this.participantePK = new ParticipantePK(idusuario, idproyecto);
    }

    public ParticipantePK getParticipantePK() {
        return participantePK;
    }

    public void setParticipantePK(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantePK != null ? participantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.participantePK == null && other.participantePK != null) || (this.participantePK != null && !this.participantePK.equals(other.participantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Participante[ participantePK=" + participantePK + " ]";
    }
    
}
