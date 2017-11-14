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
@Table( schema = "",name="horrariorefeicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorrarioRefeicao.findAll", query = "SELECT h FROM HorrarioRefeicao h"),
    @NamedQuery(name = "HorrarioRefeicao.findByIdhorrarioRefeicao", query = "SELECT h FROM HorrarioRefeicao h WHERE h.idhorrarioRefeicao = :idhorrarioRefeicao"),
    @NamedQuery(name = "HorrarioRefeicao.findByDescricao", query = "SELECT h FROM HorrarioRefeicao h WHERE h.descricao = :descricao")})
public class HorrarioRefeicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idhorrarioRefeicao;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horrarioRefeicao")
    private List<ConsumoDiario> consumoDiarioList;

    public HorrarioRefeicao() {
    }

    public HorrarioRefeicao(Integer idhorrarioRefeicao) {
        this.idhorrarioRefeicao = idhorrarioRefeicao;
    }

    public HorrarioRefeicao(Integer idhorrarioRefeicao, String descricao) {
        this.idhorrarioRefeicao = idhorrarioRefeicao;
        this.descricao = descricao;
    }

    public Integer getIdhorrarioRefeicao() {
        return idhorrarioRefeicao;
    }

    public void setIdhorrarioRefeicao(Integer idhorrarioRefeicao) {
        this.idhorrarioRefeicao = idhorrarioRefeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<ConsumoDiario> getConsumoDiarioList() {
        return consumoDiarioList;
    }

    public void setConsumoDiarioList(List<ConsumoDiario> consumoDiarioList) {
        this.consumoDiarioList = consumoDiarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorrarioRefeicao != null ? idhorrarioRefeicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorrarioRefeicao)) {
            return false;
        }
        HorrarioRefeicao other = (HorrarioRefeicao) object;
        if ((this.idhorrarioRefeicao == null && other.idhorrarioRefeicao != null) || (this.idhorrarioRefeicao != null && !this.idhorrarioRefeicao.equals(other.idhorrarioRefeicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HorrarioRefeicao[ idhorrarioRefeicao=" + idhorrarioRefeicao + " ]";
    }
    
}
