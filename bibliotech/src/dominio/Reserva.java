/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 2017122760293
 */

@Entity
@Table (name = "reserva")
public class Reserva implements Serializable{
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int idReserva;

    
    private String dtReserva;
    private String dtDevolucao;
    
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idCliente")
    private Cliente cliente;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idLivro")
    private Livro livro;
    

    public Reserva() {
    }
    
    

    public Reserva(Cliente cliente, Livro livro, String dtReserva, String dtDevolucao) {
        this.cliente = cliente;
        this.livro = livro;
        this.dtReserva = dtReserva;
        this.dtDevolucao = dtDevolucao;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(String dtReserva) {
        this.dtReserva = dtReserva;
    }

    public String getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(String dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }
    
    public Object[] toArray() {
        return new Object[] {this, cliente, livro, dtReserva, dtDevolucao};
    }
    
    @Override
    public String toString() {
        return String.valueOf(idReserva);
    }
    
    
}
