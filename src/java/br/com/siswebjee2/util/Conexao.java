/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siswebjee2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class Conexao {
    
    private String banco = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String usuario = "gustavo";
    private String senha = "123";

    private Connection conexao;

    public Conexao() { // quando houver uma instância, vai conectar
  
    }

    public Conexao(String driver, String banco, String usuario, String senha){
        this.driver = driver;
        this.banco = banco;
        this.usuario = usuario;
        this.senha = senha;
        
        this.conectar();
    }

    public boolean conectar() {
        try {
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(banco, usuario, senha);
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
            return this.conexao;
    }
    
    public void desconectar(){
        try {
            if(this.conexao != null){
                this.conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
