/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author murilo
 */
@Entity
@Table(name = "consoles")
@NamedQueries({
    @NamedQuery(name = "Consoles.findAll", query = "SELECT c FROM Consoles c")})
public class Consoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "id_console")
    private Long idConsole;
    @Basic(optional = false)
    @Column(name = "especificacoes")
    private String especificacoes;
    @JoinTable(name = "console_jogo", joinColumns = {
        @JoinColumn(name = "id_console", referencedColumnName = "id_console")}, inverseJoinColumns = {
        @JoinColumn(name = "id_jogo", referencedColumnName = "id_jogo")})
    @ManyToMany
    private List<Jogo> jogoList;

    public Consoles() {
    }

    public Consoles(Long idConsole) {
        this.idConsole = idConsole;
    }

    public Consoles(Long idConsole, String nome, String especificacoes) {
        this.idConsole = idConsole;
        this.nome = nome;
        this.especificacoes = especificacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdConsole() {
        return idConsole;
    }

    public void setIdConsole(Long idConsole) {
        this.idConsole = idConsole;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public List<Jogo> getJogoList() {
        return jogoList;
    }

    public void setJogoList(List<Jogo> jogoList) {
        this.jogoList = jogoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsole != null ? idConsole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consoles)) {
            return false;
        }
        Consoles other = (Consoles) object;
        if ((this.idConsole == null && other.idConsole != null) || (this.idConsole != null && !this.idConsole.equals(other.idConsole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Consoles[ idConsole=" + idConsole + " ]";
    }
    
}
