/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRIVE;

import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class GAE {
    private final ConexaoSQLite CONEXAO_BANCO = new ConexaoSQLite();
    public void GRAVAR(String coluna[],String valor[],String tabela,String Mensagem){
        CONEXAO_BANCO.conectar();
        String COLUNA = "", VALUE = "", VIRG = "";
        
        for(String col:coluna){
            COLUNA = COLUNA + VIRG + col;
            if(VIRG.equals("")) 
                VIRG = ",";
        }
        VIRG = "";
        
        for(String val:valor){
            VALUE = VALUE + VIRG +"'"+ val+"'";
            if(VIRG.equals("")) 
                VIRG = ",";
        }
        
        try {
            CONEXAO_BANCO.executaSQL("select * from "+ tabela + " ");
            String SQL = "insert into "+ tabela + " "
                    + "("+COLUNA+ ") VALUES "
                    + "("+VALUE + ")";
            CONEXAO_BANCO.statement.executeUpdate(SQL);
            Icon figura = (new ImageIcon(getClass().getResource("/IMAGE/ICON_save_compledet_64.png")));
            JOptionPane.showMessageDialog(null,Mensagem, "Concluido", JOptionPane.PLAIN_MESSAGE,figura);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            CONEXAO_BANCO.desconectar();
        }   
    }
    public void ALTERAR(String coluna[],String valor[],String tabela,String condicao,String Mensagem){
        CONEXAO_BANCO.conectar();
        String VALORES = "", VIRG = "";
        
        for(int i = 0; i<coluna.length; i++){
            VALORES = VALORES + VIRG + coluna[i] + " = '" + valor [i] + "'"; 
            if(VIRG.equals("")) 
                VIRG = ",";
        }
        try {
            CONEXAO_BANCO.executaSQL("select * from "+ tabela + " ");
            String SQL = "UPDATE "+tabela+" SET "+VALORES+" "+condicao ; //where nome = 'Jose'
            //System.out.println(SQL);
            CONEXAO_BANCO.statement.executeUpdate(SQL);
            Icon figura = (new ImageIcon(getClass().getResource("/IMAGE/ICON_save_compledet_64.png")));
            JOptionPane.showMessageDialog(null,Mensagem, "Concluido", JOptionPane.PLAIN_MESSAGE,figura);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            CONEXAO_BANCO.desconectar();
        }
        
    }
    
    public void EXCLUIR(String tabela,String condicao,String Mensagem){
        CONEXAO_BANCO.conectar();
        try {
            CONEXAO_BANCO.executaSQL("select * from "+ tabela + " ");
            String SQL = "DELETE FROM "+ tabela + " "+ condicao; // where nome = 'Vanessa'
            CONEXAO_BANCO.statement.executeUpdate(SQL);
            Icon figura = (new ImageIcon(getClass().getResource("/IMAGE/ICON_save_compledet_64.png")));
            JOptionPane.showMessageDialog(null,Mensagem, "Concluido", JOptionPane.PLAIN_MESSAGE,figura);
            System.out.println("deletou");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            CONEXAO_BANCO.desconectar();
        }
    }
}
