/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author 2017122760293
 */
@Entity
@Table (name = "cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int idCliente;
    
    private String nome;
    private String cpf;
    private String dtNasc;
    private String endereco;
    private String email;
    private String telefone;
    private char sexo;
    
    
    @OneToMany ( mappedBy = "cliente", fetch = FetchType.LAZY )
    private List<Reserva> reservasCliente;

    
    public Cliente(String nome, String cpf, String dtNasc, String endereco, String email, String telefone, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Reserva> getReservasCliente() {
        return reservasCliente;
    }

    public void setReservasCliente(List<Reserva> reservasCliente) {
        this.reservasCliente = reservasCliente;
    }
    
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Object[] toArray() {
        return new Object[] {this, cpf ,dtNasc, endereco, email, telefone, sexo };
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}
