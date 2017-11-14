/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table( schema = "",name = "alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a order by a.descricao"),
    @NamedQuery(name = "Alimento.findByIdalimento", query = "SELECT a FROM Alimento a WHERE a.idalimento = :idalimento"),
    @NamedQuery(name = "Alimento.findByDescricao", query = "SELECT a FROM Alimento a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Alimento.findByCal", query = "SELECT a FROM Alimento a WHERE a.cal = :cal"),
    @NamedQuery(name = "Alimento.findByUnidade", query = "SELECT a FROM Alimento a WHERE a.unidade = :unidade")})
public class Alimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idalimento;
    @Basic(optional = false)
    @Column(nullable = false, length = 95)
    private String descricao;
    @Basic(optional = false)
    @Column(nullable = false)
    private int cal;
    @Basic(optional = false)
    @Column(nullable = false, length = 8)
    private String unidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimento")
    private List<ConsumoDiarioAlimento> consumoDiarioAlimentoList;

    public Alimento() {
    }

    public Alimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Alimento(Integer idalimento, String descricao, int cal, String unidade) {
        this.idalimento = idalimento;
        this.descricao = descricao;
        this.cal = cal;
        this.unidade = unidade;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @XmlTransient
    public List<ConsumoDiarioAlimento> getConsumoDiarioAlimentoList() {
        return consumoDiarioAlimentoList;
    }

    public void setConsumoDiarioAlimentoList(List<ConsumoDiarioAlimento> consumoDiarioAlimentoList) {
        this.consumoDiarioAlimentoList = consumoDiarioAlimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Alimento[ idalimento=" + idalimento + " ]";
    }
    
}
