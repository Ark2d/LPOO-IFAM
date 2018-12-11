/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Categoria implements Serializable{
    private int codigo;
    private String nome;

    public Categoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Categoria() {
    }
    

    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }    

    @Override
    public String toString() {
        return "Categoria{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    public Categoria procurar(String nome){
        if(new File("src\\Dados\\categoria.dat").exists()){
            ObjectDao sv = new ObjectDao();
            List<Categoria> listaCliente = (List<Categoria>)(Object)sv.show("categoria");
            for (Categoria categoria : listaCliente) {
                if(categoria.getNome().equalsIgnoreCase(nome)){
                    return categoria;
                }
            }
        }
        return null;
    }
}
