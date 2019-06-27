/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AutorDAO;
import dao.ClienteDAO;
import dao.GenericDAO;
import dao.LivroDAO;
import dao.ReservaDAO;
import dominio.Autor;
import dominio.Cliente;
import dominio.Livro;
import dominio.Reserva;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import visao.DlgPesqCliente;

/**
 *
 * @author 2017122760293
 */
public class ControladorDominio {
    
    ClienteDAO cliDao;
    ReservaDAO resDao;
    AutorDAO autDao;
    LivroDAO livDao;
    GenericDAO genDao;

    public ControladorDominio() {
        cliDao = new ClienteDAO();
        resDao = new ReservaDAO();
        autDao = new AutorDAO();
        livDao = new LivroDAO();
        genDao = new GenericDAO();
    }
    
    
    
    public void excluirObj(Object obj) throws SQLException {
        genDao.excluir(obj);
    }
    
    
    public int inserirCliente(String cpf, String dtNasc, String email, String endereco, String nome, char sexo, String telefone) throws SQLException, ClassNotFoundException {

        Cliente cli = new Cliente(nome, cpf, dtNasc, endereco, email, telefone, sexo);

        // ClienteDAO
        cliDao.inserir(cli);
        return cli.getIdCliente();
    }
    
    
    public void alterarCliente(int idCliente, String cpf, String dtNasc, String email, String endereco, String nome, char sexo, String telefone) throws SQLException, ClassNotFoundException {

        Cliente cli = new Cliente(nome, cpf, dtNasc, endereco, email, telefone, sexo);

        cli.setIdCliente(idCliente);

        // ClienteDAO
        cliDao.alterar(cli);
    }
    
    
    
    
    public void pesquisarCliente(String nome, String cpf, JTable tabela) throws SQLException {
        List<Cliente> lista = null;

       lista = cliDao.pesquisarCliente(Cliente.class, nome, cpf); 
        
        for ( Cliente cli : lista) {
            ((DefaultTableModel) tabela.getModel()).addRow( cli.toArray() );
        }

    }
    
    
    
    
    public int inserirAutor(String nome, int anoNascimento, String notaBio) throws SQLException, ClassNotFoundException {

        Autor aut = new Autor(nome, anoNascimento, notaBio);

        // ClienteDAO
        autDao.inserir(aut);
        return aut.getIdAutor();
    }
    
    
     public void alterarAutor(int idAutor, String nome, int anoNascimento, String notaBio) throws SQLException, ClassNotFoundException {

        Autor aut = new Autor(nome, anoNascimento, notaBio);

        aut.setIdAutor(idAutor);

        // AutorDAO
        autDao.alterar(aut);
    }
    
    
    
    public void pesquisarAutor(int id, String nome, int anoNascimento, JTable tabela) throws SQLException {
        List<Autor> lista = null;

       lista = autDao.pesquisarAutor(Autor.class, id, nome, anoNascimento);
        
        for ( Autor aut : lista) {
            ((DefaultTableModel) tabela.getModel()).addRow( aut.toArray() );
        }

    }
    

    
    public int inserirLivro(String titulo, int anoLancamento, String editora, Autor idAutor) throws SQLException, ClassNotFoundException {

        Livro liv = new Livro(titulo, anoLancamento, editora, idAutor);

        // ClienteDAO
        livDao.inserir(liv);
        return liv.getIdLivro();
    }
    
    
     public void alterarLivro(int idLivro, String titulo, int anoLancamento, String editora, Autor idAutor) throws SQLException, ClassNotFoundException {

        Livro liv = new Livro(titulo, anoLancamento, editora, idAutor);

        liv.setIdLivro(idLivro);

        // ClienteDAO
        livDao.alterar(liv);
    }
    
    
    public void pesquisarLivro(String titulo, int cod, JTable tabela) throws SQLException {
        List<Livro> lista = null;

       lista = livDao.pesquisarLivro(Livro.class, titulo, cod);
        
        for ( Livro liv : lista) {
            ((DefaultTableModel) tabela.getModel()).addRow( liv.toArray() );
        }

    }
    
    
    public int inserirReserva(Cliente cliente, Livro livro, String dtReserva, String dtDevolucao) throws SQLException, ClassNotFoundException {

        Reserva res = new Reserva(cliente, livro, dtReserva, dtDevolucao);

        // ClienteDAO
        resDao.inserir(res);
        return res.getIdReserva();
    }
    
    
     public void alterarReserva(int idReserva, Cliente cliente, Livro livro, String dtReserva, String dtDevolucao) throws SQLException, ClassNotFoundException {

        Reserva res = new Reserva(cliente, livro, dtReserva, dtDevolucao);

        res.setIdReserva(idReserva);

        // ClienteDAO
        resDao.alterar(res);
    }
    
    
    
    public void pesquisarReserva(Cliente cliente, Livro livro, String dtRes, String dtDevo, JTable tabela) throws SQLException {
        List<Reserva> lista = null;

       lista = resDao.pesquisarReserva(Reserva.class, cliente, livro, dtRes, dtDevo);
        
        for ( Reserva res : lista) {
            ((DefaultTableModel) tabela.getModel()).addRow( res.toArray() );
        }

    }
    
    
    
    

    public void preencherTabela(JTable tblAutores) {
        List<Autor> lista = null;

       lista = autDao.listar(Autor.class);
        
        for ( Autor aut : lista) {
            ((DefaultTableModel) tblAutores.getModel()).addRow( aut.toArray() );
        }
    }

    
    
   public List<Cliente> listarCliente(){
       return cliDao.listar(Cliente.class);
   
   }
   
   
   public List<Livro> listarLivro(){
       return livDao.listar(Livro.class);
   
   } 
    
    
}
