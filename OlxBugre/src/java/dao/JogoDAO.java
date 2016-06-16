/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Jogo;

/**
 *
 * @author murilo
 */
public class JogoDAO {
    EntityManager em;
    
    public JogoDAO() throws Exception {
        
        EntityManagerFactory emf;
        
        emf = Conexao.getConexao();
        
        em = emf.createEntityManager();
        
    }
    
    public void incluir(Jogo obj) throws Exception {
        
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
    
    public List<Jogo> listar() throws Exception {
        
        return em.createNamedQuery("Jogo.findAll").getResultList();
        
    }
    
    public void alterar(Jogo obj) throws Exception {
        
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
    
    public void excluir(Jogo obj) throws Exception {
        
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
