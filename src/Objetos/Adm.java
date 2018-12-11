
package Objetos;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Adm extends Pessoa
{
    
    public Adm(String nome, String cpf, String senha, String email, LocalDate dataNascimento) {
        super(nome, cpf, senha, email, dataNascimento);
    }
    
    public Adm(){}
    
    public Adm procurar(String cpf){
        if(new File("src\\Dados\\adm.dat").exists()){
            ObjectDao sv = new ObjectDao();
            List<Adm> lista = (List<Adm>)(Object)sv.show("adm");
            for (Adm adm : lista) {
                if(adm.getCpf().equals(cpf)){
                    return adm;
                }
            }
        }
        return null;
    }
       
}
