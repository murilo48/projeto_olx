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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author murilo
 */
@Entity
@Table(name = "lista_desejos")
@NamedQueries({
    @NamedQuery(name = "ListaDesejos.findAll", query = "SELECT l FROM ListaDesejos l")})
public class ListaDesejos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numero_total_de_itens")
    private long numeroTotalDeItens;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Long idLista;
    @ManyToMany(mappedBy = "listaDesejosList")
    private List<Jogo> jogoList;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne
    private Usuario id;

    public ListaDesejos() {
    }

    public ListaDesejos(Long idLista) {
        this.idLista = idLista;
    }

    public ListaDesejos(Long idLista, long numeroTotalDeItens) {
        this.idLista = idLista;
        this.numeroTotalDeItens = numeroTotalDeItens;
    }

    public long getNumeroTotalDeItens() {
        return numeroTotalDeItens;
    }

    public void setNumeroTotalDeItens(long numeroTotalDeItens) {
        this.numeroTotalDeItens = numeroTotalDeItens;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public List<Jogo> getJogoList() {
        return jogoList;
    }

    public void setJogoList(List<Jogo> jogoList) {
        this.jogoList = jogoList;
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
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaDesejos)) {
            return false;
        }
        ListaDesejos other = (ListaDesejos) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ListaDesejos[ idLista=" + idLista + " ]";
    }
    
}
