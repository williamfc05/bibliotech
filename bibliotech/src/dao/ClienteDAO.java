/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author 2017122760293
 */
public class ClienteDAO extends GenericDAO{

    public ClienteDAO() {
        dao.ConexaoHibernate.getSessionFactory();
    }
    
    
    public List<Cliente> pesquisarCliente(Class classe, String nome, String cpf) throws SQLException {
        List lista = null;
        Session sessao = null;
        
        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(classe);
            
           
            
            if(!nome.isEmpty()){
                consulta.add(Restrictions.like("nome", "%" + nome + "%"));
            }if(!cpf.equals("   .   .   -  ")){
                consulta.add(Restrictions.like("cpf", "%" + cpf + "%"));
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
