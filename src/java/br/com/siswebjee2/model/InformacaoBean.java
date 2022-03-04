package br.com.siswebjee2.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class InformacaoBean {
    
    private int codigo;
    private String nome;
    private Connection conexao;

    public InformacaoBean() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public boolean gravarInformacao(String tabela){
        String sql = "INSERT INTO " + tabela + " (nome) VALUES (?)";
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, this.getNome());
            instrucao.execute();
            instrucao.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluirInformacao(String tabela){
        String sql = "DEELTE FROM " + tabela + " WHERE codigo = ?";
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, this.getCodigo());
            instrucao.executeUpdate();
            instrucao.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean atualizarInformacao(String tabela){
        String sql = "UPDATE " + tabela + " SET nome = ? WHERE codigo = ?";
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, this.getNome());
            instrucao.setInt(2, this.getCodigo());
            instrucao.executeUpdate();
            instrucao.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public InformacaoBean buscarInformacao(String tabela, int codigo){
        String sql = "SELECT * FROM " + tabela + " WHERE codigo = ?";
        InformacaoBean info = new InformacaoBean();
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, this.getCodigo());
            
            ResultSet resultado = instrucao.executeQuery();
            
            if(resultado.next()){
                info.setCodigo(resultado.getInt("codigo"));
                info.setNome(resultado.getString("nome"));
            }
            else{
                info = null;
            }
            
            resultado.close();
            instrucao.close();
            
            return info;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<InformacaoBean> listarInformacoes(String tabela, String ordem){
        List<InformacaoBean> listaInfo = new ArrayList<InformacaoBean>();
        
        String sql = "SELECT * FROM " + tabela + " ORDER BY " + ordem;
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            while(resultado.next()){
                InformacaoBean info = new InformacaoBean();
                info.setCodigo(resultado.getInt("codigo"));
                info.setNome(resultado.getString("nome"));
                
                listaInfo.add(info);
            }
            resultado.close();
            instrucao.close();
            
            return listaInfo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
