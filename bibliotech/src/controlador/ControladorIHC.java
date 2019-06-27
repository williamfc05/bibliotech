/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Autor;
import dominio.Cliente;
import dominio.Livro;
import dominio.Reserva;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import visao.DlgCadastrarLivros;
import visao.DlgPesqAutor;
import visao.DlgPesqLivro;
import visao.FrmPrincipal;
import visao.DlgCadastrarAutor;
import visao.DlgCadastrarCliente;
import visao.DlgPesqCliente;
import visao.DlgPesqReserva;
import visao.DlgReserva;

/**
 *
 * @author willi
 */
public class ControladorIHC {
    
    private FrmPrincipal janPrincipal = null;
    
    private ControladorDominio controlDominio;
    
    private static ControladorIHC instanciaUnica;

    public ControladorIHC() {
        controlDominio = new ControladorDominio();
    }
    
    public ControladorDominio getControlDominio() {
        return controlDominio;
    }
    
    
    
    public static synchronized ControladorIHC getInstance(){
        if(instanciaUnica == null){
            instanciaUnica = new ControladorIHC();
        }
        return instanciaUnica;
    }
    
    public void janelaPrincipal() {
        janPrincipal = new FrmPrincipal(this);
        janPrincipal.setVisible(true);
    }
    
    public void janelaCadastrarLivros() {
        DlgCadastrarLivros janLivros = new DlgCadastrarLivros(janPrincipal, true, this);
        janLivros.setVisible(true);
    }
    
    public Livro janelaPesqLivros() {
        DlgPesqLivro janPesqLivro = new DlgPesqLivro(janPrincipal, true, this);
        janPesqLivro.setVisible(true);
        return janPesqLivro.getLivSelecionado();
    }
    
    public void janelaCadastrarAutor() {
        DlgCadastrarAutor janCadastrarAutor = new DlgCadastrarAutor(janPrincipal, true, this);
        janCadastrarAutor.setVisible(true);
    }
    
    public Autor janelaPesqAutor() {
        DlgPesqAutor janPesqAutor = new DlgPesqAutor(janPrincipal, true, this);
        janPesqAutor.setVisible(true);
        return janPesqAutor.getAutSelecionado();
    }
    
    
    public void janelaCadastrarCliente() {
        DlgCadastrarCliente janCadastrarCliente = new DlgCadastrarCliente(janPrincipal, true, this);
        janCadastrarCliente.setVisible(true);
    }
    
    public Cliente janelaPesqCliente() {
        DlgPesqCliente janPesqCliente = new DlgPesqCliente(janPrincipal, true, this);
        janPesqCliente.setVisible(true);
        return janPesqCliente.getCliSelecionado();
    }
    
    public void janelaReserva() {
        DlgReserva janReserva = new DlgReserva(janPrincipal, true, this);
        janReserva.setVisible(true);
    }
    
    public Reserva janelaPesqReserva() {
        DlgPesqReserva janPesqReserva = new DlgPesqReserva(janPrincipal, true, this);
        janPesqReserva.setVisible(true);
        return janPesqReserva.getResSelecionado();
    }
    
    
    
    
    public void preencherCombo(JComboBox combo, Class classe) {
        
        
        
        if(classe.equals(Cliente.class)){
            List<Cliente> cliLista;
            cliLista = controlDominio.listarCliente();
            combo.setModel( new DefaultComboBoxModel(cliLista.toArray()));
        
        }else{
            List<Livro> livLista;
            livLista = controlDominio.listarLivro();
            combo.setModel( new DefaultComboBoxModel(livLista.toArray()));
        }
        
        
    }
    
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        ControladorIHC controlIHC = ControladorIHC.getInstance();
        controlIHC.janelaPrincipal();
    }

    

    
    
    
    
}
