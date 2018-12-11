/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Item implements Serializable{
    private int qtd;
    private Produto produto;
    private double valor;

    @Override
    public String toString() {
        return "Item{" + "qtd=" + qtd + ", produto=" + produto + ", valor=" + valor + '}';
    }  
    
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
