/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Autor;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 2017122760293
 */
public class AutorDAO extends GenericDAO{

    public AutorDAO() {
        dao.ConexaoHibernate.getSessionFactory();
    }
    
    
    public List<Autor> pesquisarAutor(Class classe, int id, String nome, int anoNasc) throws SQLException {
        
        List lista = null;
        Session sessao = null;
        
        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(classe);
            
            
            if(id > 0){
                consulta.add(Restrictions.eq("idAutor", id));
            }
            if(!nome.isEmpty()){
                consulta.add(Restrictions.like("nome", "%" + nome + "%"));
            }if(anoNasc > 0){
                consulta.add(Restrictions.eq("anoNascimento", anoNasc));
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
