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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daves
 */
@Embeddable
public class ConsumoDiarioPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private int iduser;
    @Basic(optional = false)
    @Column(nullable = false)
    private int idTipoRefeicao;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    public ConsumoDiarioPK() {
    }

    public ConsumoDiarioPK(int iduser, int idTipoRefeicao, Date data) {
        this.iduser = iduser;
        this.idTipoRefeicao = idTipoRefeicao;
        this.data = data;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdTipoRefeicao() {
        return idTipoRefeicao;
    }

    public void setIdTipoRefeicao(int idTipoRefeicao) {
        this.idTipoRefeicao = idTipoRefeicao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iduser;
        hash += (int) idTipoRefeicao;
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoDiarioPK)) {
            return false;
        }
        ConsumoDiarioPK other = (ConsumoDiarioPK) object;
        if (this.iduser != other.iduser) {
            return false;
        }
        if (this.idTipoRefeicao != other.idTipoRefeicao) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ConsumoDiarioPK[ iduser=" + iduser + ", idTipoRefeicao=" + idTipoRefeicao + ", data=" + data + " ]";
    }
    
}
