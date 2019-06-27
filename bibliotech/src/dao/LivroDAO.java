/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Livro;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 2017122760293
 */
public class LivroDAO extends GenericDAO{

    public LivroDAO() {
        dao.ConexaoHibernate.getSessionFactory();
    }
    
    
    public List<Livro> pesquisarLivro(Class classe, String titulo, int cod) throws SQLException {
        
        List lista = null;
        Session sessao = null;
        
        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(classe);
            
            
            
            if(!titulo.isEmpty()){
                consulta.add(Restrictions.like("titulo", "%" + titulo + "%"));
            }if(cod > 0){
                consulta.add(Restrictions.eq("idLivro", cod));
            }
            
            
            
            
            lista = consulta.list();

            sessao.getTransaction().commit(); 
            sessao.close();
        } catch ( HibernateException ex ) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            
            throw new HibernateException(ex);
        }
        return lista;  
    }
    
    
    
}
