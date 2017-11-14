/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table( schema = "",name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIduser", query = "SELECT u FROM User u WHERE u.iduser = :iduser"),
    @NamedQuery(name = "User.findByNome", query = "SELECT u FROM User u WHERE u.nome = :nome"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findBySenha", query = "SELECT u FROM User u WHERE u.senha = :senha"),
    @NamedQuery(name = "User.findByLoginSenha", query = "SELECT u FROM User u WHERE u.email = :email and u.senha = :senha"),
    @NamedQuery(name = "User.findByObjetivo", query = "SELECT u FROM User u WHERE u.objetivo = :objetivo")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iduser;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 95)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String objetivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Historico> historicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ConsumoDiario> consumoDiarioList;

    public User() {
        this(0);
    }

    public User(Integer iduser) {
        this(iduser, "", "", "", "Emagrecer");
    }

    public User(Integer iduser, String nome, String email, String senha, String objetivo) {
        this.iduser = iduser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.objetivo = objetivo;
        historicoList = new ArrayList<>();
        consumoDiarioList = new ArrayList<>();
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
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
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.User[ iduser=" + iduser + " ]";
    }
    
}
