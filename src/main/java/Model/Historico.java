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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daves
 */
@Entity
@Table( schema = "",name = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h"),
    @NamedQuery(name = "Historico.findByIdhistorico", query = "SELECT h FROM Historico h WHERE h.historicoPK.idhistorico = :idhistorico"),
    @NamedQuery(name = "Historico.findByIduser", query = "SELECT h FROM Historico h WHERE h.historicoPK.iduser = :iduser"),
    @NamedQuery(name = "Historico.findByPeso", query = "SELECT h FROM Historico h WHERE h.peso = :peso"),
    @NamedQuery(name = "Historico.findByAltura", query = "SELECT h FROM Historico h WHERE h.altura = :altura"),
    @NamedQuery(name = "Historico.findByDataMedida", query = "SELECT h FROM Historico h WHERE h.dataMedida = :dataMedida")})
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoricoPK historicoPK;
    @Basic(optional = false)
    @Column(nullable = false)
    private double peso;
    @Basic(optional = false)
    @Column(nullable = false)
    private double altura;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataMedida;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public double imc(){
        return peso/(altura*altura);
    }
    
    public Historico() {
    }

    public Historico(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public Historico(HistoricoPK historicoPK, double peso, double altura, Date dataMedida) {
        this.historicoPK = historicoPK;
        this.peso = peso;
        this.altura = altura;
        this.dataMedida = dataMedida;
    }

    public Historico(int idhistorico, int iduser) {
        this.historicoPK = new HistoricoPK(idhistorico, iduser);
    }

    public HistoricoPK getHistoricoPK() {
        return historicoPK;
    }

    public void setHistoricoPK(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Date getDataMedida() {
        return dataMedida;
    }

    public void setDataMedida(Date dataMedida) {
        this.dataMedida = dataMedida;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historicoPK != null ? historicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.historicoPK == null && other.historicoPK != null) || (this.historicoPK != null && !this.historicoPK.equals(other.historicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Historico[ historicoPK=" + historicoPK + " ]";
    }
    
}
