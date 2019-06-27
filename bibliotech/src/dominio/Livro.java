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
@Table (name = "livro")
public class Livro implements Serializable{
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int idLivro;
    
    private String titulo;
    private int anoLancamento;
    private String editora;

    
    @OneToMany ( mappedBy = "livro", fetch = FetchType.LAZY )
    private List<Reserva> reservasLivro;
    
    
    @ManyToOne (fetch = FetchType.EAGER )
    @JoinColumn (name = "idAutor")
    private Autor autor;
    
    public Livro() {
    }

    
    
    
    public Livro(String titulo, int anoLancamento, String editora, Autor idAutor) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.editora = editora;
        this.autor = idAutor;
    }
    
 

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public List<Reserva> getReservasLivro() {
        return reservasLivro;
    }

    public void setReservasLivro(List<Reserva> reservasLivro) {
        this.reservasLivro = reservasLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Autor getCodigoAutor() {
        return autor;
    }

    public void setCodigoAutor(Autor codigoAutor) {
        this.autor = codigoAutor;
    }
    
    
    public Object[] toArray() {
        return new Object[] {idLivro, this, anoLancamento, editora, autor};
    }
    
    @Override
    public String toString() {
        return titulo;
    }
    
    
}
