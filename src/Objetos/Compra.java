/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Compra implements Serializable{
    private final int id;
    private List<Item> itens;
    private double valorTotal;
    private String Status;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Compra(int id) {
        this.id = id;
        this.itens = new ArrayList<Item>();
        this.valorTotal = 0;
    }
    
    public void adicionarItem(Item item){
        this.itens.add(item);
        this.valorTotal+=item.getValor();
    }

    public List<Item> getItens() {
        return itens;
    }

    public int getId() {
        return id;
    }


    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", itens=" + itens + ", valorTotal=" + valorTotal + ", Status=" + Status + ", cliente=" + cliente + '}';
    }
    
}
