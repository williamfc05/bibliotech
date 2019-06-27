/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 2017122760293
 */

@Entity
@Table (name = "autor")
public class Autor implements Serializable{
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int idAutor;
    
    
    private String nome;
    private int anoNascimento;
    private String notaBio;

    
//    @ManyToOne ( fetch = FetchType.EAGER )
//    @JoinColumn ( name = "idLivro")
//    private Livro cliente;
    
    @OneToMany ( mappedBy = "autor", fetch = FetchType.LAZY )
    private List<Livro> livrosAutor;
    
    
    public Autor() {
    }

    public Autor(String nome, int anoNascimento, String notaBio) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.notaBio = notaBio;
    }
    
    

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public List<Livro> getLivrosAutor() {
        return livrosAutor;
    }

//    public Autor(String nome, int anoNascimento, String notaBio) {
//        this.nome = nome;
//        this.anoNascimento = anoNascimento;
//        this.notaBio = notaBio;
//    }
    public void setLivrosAutor(List<Livro> livrosAutor) {
        this.livrosAutor = livrosAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNotaBio() {
        return notaBio;
    }

    public void setNotaBio(String notaBio) {
        this.notaBio = notaBio;
    }
    
    
    public Object[] toArray() {
        return new Object[] {idAutor, this, anoNascimento, notaBio};
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
