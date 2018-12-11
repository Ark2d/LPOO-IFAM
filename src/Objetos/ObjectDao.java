
package Objetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectDao implements Serializable{
     
    
    
    public void save(String file, Object obj){
        try {
            FileOutputStream fos = new FileOutputStream("src\\Dados\\" + file + ".dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public List<Object> show(String file){
            
        try {
            FileInputStream fis = new FileInputStream("src\\Dados\\" + file + ".dat");  
            List<Object> listaClientes = new ArrayList<>();
            Object t;
            while(fis.available()>0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                    t = ois.readObject();
                    listaClientes.add(t);
                System.out.println("--->"+t);
            }            
            fis.close();
            return listaClientes;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        }            
        
        return null;
    }
}
