/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Produto implements Serializable{
    private String codigo;
    private String nome;
    private double valor;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }   

    public Produto(String codigo, String nome, double valor, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Produto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", categoria=" + categoria + '}';
    }
    
    public Produto procurar(String nome, String codigo){
        if(new File("src\\Dados\\produto.dat").exists()){
            ObjectDao sv = new ObjectDao();
            List<Produto> lista = (List<Produto>)(Object)sv.show("produto");
            for (Produto produto : lista) {
                if(produto.getNome().equalsIgnoreCase(nome) || produto.getCodigo().equalsIgnoreCase(codigo)){
                    return produto;
                }
            }
        }
        return null;
    }
    
    
}
