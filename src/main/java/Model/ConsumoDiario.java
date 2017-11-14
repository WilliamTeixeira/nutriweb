/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daves
 */
@Entity
@Table( schema = "",name = "consumodiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoDiario.findAll", query = "SELECT c FROM ConsumoDiario c"),
    @NamedQuery(name = "ConsumoDiario.findByIduser", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser"),
    @NamedQuery(name = "ConsumoDiario.findByIdTipoRefeicao", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.idTipoRefeicao = :idTipoRefeicao"),
    @NamedQuery(name = "ConsumoDiario.findByData", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.data = :data"),
    @NamedQuery(name = "ConsumoDiario.findByHorario", query = "SELECT c FROM ConsumoDiario c WHERE c.horario = :horario"),
    @NamedQuery(name = "ConsumoDiario.findByIduserAndIdTipoRefeicaoMaxDate", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser "
            + "and c.consumoDiarioPK.idTipoRefeicao = :idTipoRefeicao "
            + "and c.consumoDiarioPK.data = (select max(c1.consumoDiarioPK.data) FROM ConsumoDiario c1 WHERE c1.consumoDiarioPK.iduser = :iduser ) "
            + "order by c.consumoDiarioPK.idTipoRefeicao,c.consumoDiarioPK.data "),
    @NamedQuery(name = "ConsumoDiario.findByIduserAndIdTipoRefeicaoByDate", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser "
            + "and c.consumoDiarioPK.idTipoRefeicao = :idTipoRefeicao "
            + "and c.consumoDiarioPK.data = :iddate "
            + "order by c.consumoDiarioPK.idTipoRefeicao,c.consumoDiarioPK.data "),
    @NamedQuery(name = "ConsumoDiario.findByIduserMaxDate", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser "
            + "and c.consumoDiarioPK.data = (select max(c1.consumoDiarioPK.data) FROM ConsumoDiario c1 WHERE c1.consumoDiarioPK.iduser = :iduser ) "
            + "order by c.consumoDiarioPK.idTipoRefeicao,c.consumoDiarioPK.data "),
    @NamedQuery(name = "ConsumoDiario.findByIduserByDate", query = "SELECT c FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser "
            + "and c.consumoDiarioPK.data = :iddate "
            + "order by c.consumoDiarioPK.idTipoRefeicao,c.consumoDiarioPK.data "),
    @NamedQuery(name = "ConsumoDiario.findDatasByUser", query = "SELECT distinct c.consumoDiarioPK.data FROM ConsumoDiario c WHERE c.consumoDiarioPK.iduser = :iduser "
            + " order by c.consumoDiarioPK.data desc "),
    @NamedQuery(name = "ConsumoDiario.findByCalMax", query = "SELECT c FROM ConsumoDiario c WHERE c.calMax = :calMax")})
public class ConsumoDiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsumoDiarioPK consumoDiarioPK;
    private Integer horario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double calMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consumoDiario")
    private List<ConsumoDiarioAlimento> consumoDiarioAlimentoList;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "idTipoRefeicao", referencedColumnName = "idhorrarioRefeicao", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HorrarioRefeicao horrarioRefeicao;

    public ConsumoDiario() {
        consumoDiarioAlimentoList = new ArrayList<>();
    }

    public ConsumoDiario(ConsumoDiarioPK consumoDiarioPK) {
        this.consumoDiarioPK = consumoDiarioPK;
        consumoDiarioAlimentoList = new ArrayList<>();
    }

    public ConsumoDiario(int iduser, int idTipoRefeicao, Date data) {
        this.consumoDiarioPK = new ConsumoDiarioPK(iduser, idTipoRefeicao, data);
        consumoDiarioAlimentoList = new ArrayList<>();
    }

    public ConsumoDiarioPK getConsumoDiarioPK() {
        return consumoDiarioPK;
    }

    public void setConsumoDiarioPK(ConsumoDiarioPK consumoDiarioPK) {
        this.consumoDiarioPK = consumoDiarioPK;
    }

    public Integer getHorario() {
        return horario;
    }

    public void setHorario(Integer horario) {
        this.horario = horario;
    }

    public Double getCalMax() {
        return calMax;
    }

    public void setCalMax(Double calMax) {
        this.calMax = calMax;
    }

    @XmlTransient
    public List<ConsumoDiarioAlimento> getConsumoDiarioAlimentoList() {
        return consumoDiarioAlimentoList;
    }

    public void setConsumoDiarioAlimentoList(List<ConsumoDiarioAlimento> consumoDiarioAlimentoList) {
        this.consumoDiarioAlimentoList = consumoDiarioAlimentoList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HorrarioRefeicao getHorrarioRefeicao() {
        return horrarioRefeicao;
    }

    public void setHorrarioRefeicao(HorrarioRefeicao horrarioRefeicao) {
        this.horrarioRefeicao = horrarioRefeicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumoDiarioPK != null ? consumoDiarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoDiario)) {
            return false;
        }
        ConsumoDiario other = (ConsumoDiario) object;
        if ((this.consumoDiarioPK == null && other.consumoDiarioPK != null) || (this.consumoDiarioPK != null && !this.consumoDiarioPK.equals(other.consumoDiarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ConsumoDiario[ consumoDiarioPK=" + consumoDiarioPK + " ]";
    }
    
}
