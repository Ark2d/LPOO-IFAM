/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRIVE;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class CriarBancoSQLite {
    private final ConexaoSQLite conexaoSQLite;

    public CriarBancoSQLite(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
        
    }
    public void criarTudo(){
        criarTabelaAgenda();
        criarTabelaAtendimentoFinalizado();
        criarTabelaCliente();
        criarTabelaPagamento();
    }    
    
    public void criarTabelaAgenda(){
        String sql ="CREATE TABLE IF NOT EXISTS `Agenda` (\n" +
                    "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "	`nome`	VARCHAR ( 50 ) NOT NULL," +
                    "	`servico`	TEXT," +
                    "	`valorservico`	REAL," +
                    "	`dia`	INTEGER NOT NULL," +
                    "	`mes`	INTEGER NOT NULL," +
                    "	`ano`	INTEGER NOT NULL," +
                    "	`hora`	TEXT NOT NULL," +
                    "	`descricao`	TEXT)";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("criou");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
    
        
    public void criarTabelaPagamento(){
        String sql ="CREATE TABLE IF NOT EXISTS `Pagamento` (" +
                    "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "	`id_AgendaFinalizada`	INTEGER NOT NULL," +
                    "	`nome_cliente`	TEXT," +
                    "	`valor`	REAL NOT NULL," +
                    "	`forma`	TEXT NOT NULL," +
                    "	FOREIGN KEY(`id_AgendaFinalizada`) REFERENCES `AgendaFinalizada`(`id`) ON DELETE CASCADE," +
                    "	FOREIGN KEY(`nome_cliente`) REFERENCES `Cliente`(`nome`)" +
                    ")";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("criou");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
        
    public void criarTabelaCliente(){
        String sql ="CREATE TABLE IF NOT EXISTS `Cliente` (" +
                    "`nome`	TEXT NOT NULL,\n" +
                    "`endereco`	TEXT,\n" +
                    "`telefone`	TEXT,\n" +
                    "`celular`	TEXT,\n" +
                    "`whatsapp`	TEXT,\n" +
                    "PRIMARY KEY(`Nome`)" +
                    ")";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("criou");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
    
    public void criarTabelaAtendimentoFinalizado(){
        String sql ="CREATE TABLE IF NOT EXISTS `AgendaFinalizada` (" +
                    "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "	`id_Agenda`	INTEGER," +
                    "	`nome`	TEXT," +
                    "	`dia`	INTEGER," +
                    "	`mes`	INTEGER," +
                    "	`ano`	INTEGER," +
                    "	`hora`	TEXT," +
                    "	FOREIGN KEY(`id_Agenda`) REFERENCES `AgendaFinalizada`(`id`)," +
                    "	FOREIGN KEY(`nome`) REFERENCES `Cliente`(`nome`)" +
                    ")";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("criou");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
    
}
