/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRIVE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author salao
 */
public class ConexaoSQLite{
    private Connection conexao;
    final private String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";
    final private String driver = "com.mysql.jdbc.Driver";
    public Statement statement;
    public ResultSet resultset;
    
    public boolean conectar(){
        try {
            this.conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean desconectar(){
        
        try {
            if(this.conexao.isClosed() == false){
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public Statement criarStatement(){
         try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void executaSQL(String sql){
        try {
           statement = conexao.createStatement();
           resultset = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
    
}
