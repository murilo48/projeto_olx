/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author murilo
 */
@Entity
@Table(name = "jogo")
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j")})
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "console")
    private String console;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jogo")
    private Long idJogo;
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario id;

    public Jogo() {
    }

    public Jogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Jogo(Long idJogo, String nome, double valor, String console) {
        this.idJogo = idJogo;
        this.nome = nome;
        this.valor = valor;
        this.console = console;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario getId() {
        return id;
    }

    public void setId(Usuario id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogo != null ? idJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.idJogo == null && other.idJogo != null) || (this.idJogo != null && !this.idJogo.equals(other.idJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Jogo[ idJogo=" + idJogo + " ]";
    }
    
}
