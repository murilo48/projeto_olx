/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.ListaDesejos;
/**
 *
 * @author murilo
 */
public class ListaDesejosDAO {
    EntityManager em;
    
    public ListaDesejosDAO() throws Exception {
        
        EntityManagerFactory emf;
        
        emf = Conexao.getConexao();
        
        em = emf.createEntityManager();
        
    }
    
    public void incluir(ListaDesejos obj) throws Exception {
        
        try {
            
            em.getTransaction().begin();
            
            em.persist(obj);
            
            em.getTransaction().commit();
            
        } catch (RuntimeException e) {
            
            em.getTransaction().rollback();
            
            throw e;
            
        } finally {
            
            em.close();
            
        }
        
    }
    
    public List<ListaDesejos> listar() throws Exception {
        
        return em.createNamedQuery("Lista.findAll").getResultList();
        
    }
    
    public void alterar(ListaDesejos obj) throws Exception {
        
        try {
            
            em.getTransaction().begin();
            
            em.merge(obj);
            
            em.getTransaction().commit();
            
        } catch (RuntimeException e) {
            
            em.getTransaction().rollback();
            
            throw e;
            
        } finally {
            
            em.close();
            
        }
        
    }
    
    public void excluir(ListaDesejos obj) throws Exception {
        
        try {
            
            em.getTransaction().begin();
            
            em.remove(obj);
            
            em.getTransaction().commit();
            
        } catch (RuntimeException e) {
            
            em.getTransaction().rollback();
            
        } finally {
            
            em.close();
            
        }
        
    }
    
    public void fechaEmf() {
        
        Conexao.closeConexao();
        
    }   
}
