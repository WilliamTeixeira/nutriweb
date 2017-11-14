/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Daves
 */
@Embeddable
public class HistoricoPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private int idhistorico;
    @Basic(optional = false)
    @Column(nullable = false)
    private int iduser;

    public HistoricoPK() {
    }

    public HistoricoPK(int idhistorico, int iduser) {
        this.idhistorico = idhistorico;
        this.iduser = iduser;
    }

    public int getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(int idhistorico) {
        this.idhistorico = idhistorico;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idhistorico;
        hash += (int) iduser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPK)) {
            return false;
        }
        HistoricoPK other = (HistoricoPK) object;
        if (this.idhistorico != other.idhistorico) {
            return false;
        }
        if (this.iduser != other.iduser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HistoricoPK[ idhistorico=" + idhistorico + ", iduser=" + iduser + " ]";
    }
    
}
