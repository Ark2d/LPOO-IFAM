/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Pessoa implements Serializable{
    protected String nome;
    protected String cpf;
    protected String senha;    
    protected String email;
    protected LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, String senha, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
