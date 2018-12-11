
package Objetos;
import java.io.File;
import java.util.List;
import java.io.Serializable;

    
public class Mensagens implements Serializable{
    
    private String remetente;
    private String destinatario;
    private String assunto;
    private String texto;
    private boolean lida;

    public Mensagens(String remetente, String destinatario, String assunto, String texto, boolean lida) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.texto = texto;
        this.lida = false;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
  
    public Mensagens(){}
    
    @Override
    public String toString() {
        return "Mensagem{" + "remetente=" + remetente + ", destinatario=" + destinatario + ", assunto=" + assunto + ", texto=" + texto + ", lida" + lida +'}';
    }
    
    public Mensagens procurar(String rementente){
        if(new File("src\\Dados\\mensagens.dat").exists()){
            ObjectDao sv = new ObjectDao();
            List<Mensagens> lista = (List<Mensagens>)(Object)sv.show("mensagens");
            for (Mensagens msg : lista) {
                if(msg.getRemetente().equals(remetente)){
                    return msg;
                }
            }
        }
        return null;
    }
}
