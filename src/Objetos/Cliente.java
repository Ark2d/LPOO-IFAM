/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Cliente extends Pessoa{
    private String endereco;
    private List<Integer> IdCompras;

    public Cliente(String nome, String cpf, String senha, String email, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, senha, email, dataNascimento);
        this.endereco = endereco;
        this.IdCompras = new ArrayList<Integer>();
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "endereco=" + endereco + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", email=" + email + ", dataNascimento=" + dataNascimento + ", compras=" + IdCompras +'}';
    }
    
    
    public void addIdCompra(int compra){
        IdCompras.add(compra);
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    

    public String getEndereco() {
        return endereco;
    }

    public List<Integer> getIdCompras() {
        return IdCompras;
    }  
    
    public Cliente procurarCliente(String cpf){
        if(new File("src\\Dados\\cliente.dat").exists()){
            ObjectDao sv = new ObjectDao();
            List<Cliente> listaCliente = (List<Cliente>)(Object)sv.show("cliente");
            for (Cliente cliente : listaCliente) {
                if(cliente.getCpf().equals(cpf)){
                    return cliente;
                }
            }
        }
        return null;
    }
    /*
    public void save(String file){
        try {
            FileOutputStream fos = new FileOutputStream("src\\Dados\\cliente.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public List<Cliente> show(String file){
            
        try {
            FileInputStream fis = new FileInputStream("src\\Dados\\cliente.dat");  
            List<Cliente> listaClientes = new ArrayList<Cliente>();
            Cliente t;
            while(fis.available()>0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                    t=(Cliente) ois.readObject();
                    listaClientes.add(t);
                System.out.println("--->"+t);
            }            
            
            return listaClientes;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }            
        
        return null;
    }*/
}
