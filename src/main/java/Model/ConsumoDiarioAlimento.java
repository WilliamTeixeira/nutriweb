/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daves
 */
@Entity
@Table(name = "consumodiario_alimento", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoDiarioAlimento.findAll", query = "SELECT c FROM ConsumoDiarioAlimento c"),
    @NamedQuery(name = "ConsumoDiarioAlimento.findByIduser", query = "SELECT c FROM ConsumoDiarioAlimento c WHERE c.consumoDiarioAlimentoPK.iduser = :iduser"),
    @NamedQuery(name = "ConsumoDiarioAlimento.findByIdTipoRefeicao", query = "SELECT c FROM ConsumoDiarioAlimento c WHERE c.consumoDiarioAlimentoPK.idTipoRefeicao = :idTipoRefeicao"),
    @NamedQuery(name = "ConsumoDiarioAlimento.findByData", query = "SELECT c FROM ConsumoDiarioAlimento c WHERE c.consumoDiarioAlimentoPK.data = :data"),
    @NamedQuery(name = "ConsumoDiarioAlimento.findByIdalimento", query = "SELECT c FROM ConsumoDiarioAlimento c WHERE c.consumoDiarioAlimentoPK.idalimento = :idalimento"),
    @NamedQuery(name = "ConsumoDiarioAlimento.findByQtde", query = "SELECT c FROM ConsumoDiarioAlimento c WHERE c.qtde = :qtde")})
public class ConsumoDiarioAlimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsumoDiarioAlimentoPK consumoDiarioAlimentoPK;
    @Basic(optional = false)
    @Column(nullable = false)
    private double qtde;
    @JoinColumns({
        @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "idTipoRefeicao", referencedColumnName = "idTipoRefeicao", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "data", referencedColumnName = "data", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ConsumoDiario consumoDiario;
    @JoinColumn(name = "idalimento", referencedColumnName = "idalimento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alimento alimento;

    public ConsumoDiarioAlimento() {
    }

    public ConsumoDiarioAlimento(ConsumoDiarioAlimentoPK consumoDiarioAlimentoPK) {
        this.consumoDiarioAlimentoPK = consumoDiarioAlimentoPK;
    }

    public ConsumoDiarioAlimento(ConsumoDiarioAlimentoPK consumoDiarioAlimentoPK, double qtde) {
        this.consumoDiarioAlimentoPK = consumoDiarioAlimentoPK;
        this.qtde = qtde;
    }

    public ConsumoDiarioAlimento(int iduser, int idTipoRefeicao, Date data, int idalimento) {
        this.consumoDiarioAlimentoPK = new ConsumoDiarioAlimentoPK(iduser, idTipoRefeicao, data, idalimento);
    }

    public ConsumoDiarioAlimentoPK getConsumoDiarioAlimentoPK() {
        return consumoDiarioAlimentoPK;
    }

    public void setConsumoDiarioAlimentoPK(ConsumoDiarioAlimentoPK consumoDiarioAlimentoPK) {
        this.consumoDiarioAlimentoPK = consumoDiarioAlimentoPK;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public ConsumoDiario getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(ConsumoDiario consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumoDiarioAlimentoPK != null ? consumoDiarioAlimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoDiarioAlimento)) {
            return false;
        }
        ConsumoDiarioAlimento other = (ConsumoDiarioAlimento) object;
        if ((this.consumoDiarioAlimentoPK == null && other.consumoDiarioAlimentoPK != null) || (this.consumoDiarioAlimentoPK != null && !this.consumoDiarioAlimentoPK.equals(other.consumoDiarioAlimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ConsumoDiarioAlimento[ consumoDiarioAlimentoPK=" + consumoDiarioAlimentoPK + " ]";
    }
    
}
