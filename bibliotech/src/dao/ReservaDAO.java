/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Cliente;
import dominio.Livro;
import dominio.Reserva;
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
public class ReservaDAO extends GenericDAO{

    public ReservaDAO() {
        dao.ConexaoHibernate.getSessionFactory();
    }
    
    
    public List<Reserva> pesquisarReserva(Class classe, Cliente cliente, Livro livro, String dtRes, String dtDevo) throws SQLException {
        List lista = null;
        Session sessao = null;
        
        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(classe);
            
            
            consulta.setFetchMode("cliente", FetchMode.JOIN);
            consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            
            consulta.setFetchMode("livro", FetchMode.JOIN);
            consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            
            
            
            if(cliente != null){
                consulta.add(Restrictions.eq("cliente.idCliente", cliente.getIdCliente()));
            }if(livro != null){
                consulta.add(Restrictions.eq("livro.idLivro",  livro.getIdLivro()));
            }if(!dtRes.isEmpty()){
                consulta.add(Restrictions.like("dtReserva", "%" + dtRes + "%"));
            }if(!dtDevo.isEmpty()){
                consulta.add(Restrictions.like("dtDevolucao", "%" + dtDevo + "%"));
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
