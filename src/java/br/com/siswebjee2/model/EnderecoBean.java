/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siswebjee2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gustavo
 */
public class EnderecoBean {
    
    private int codigo;
    private int id_profissional;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String cep;
    private String estado;
    private String numero;
    private String complemento;
    
    private Connection conexao; 
    
    public EnderecoBean() {
    }

    public EnderecoBean(int id_profissional, String bairro, String cidade, String logradouro, String cep, String estado, String numero, String complemento) {
        this.id_profissional = id_profissional;
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    public EnderecoBean(int id_profissional) {
        this.id_profissional = id_profissional;
    }

    public EnderecoBean(String bairro, String cidade, String logradouro, String cep, String estado, String numero, String complemento) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    public boolean gravarInformacao(ProfissionalBean profissionalBean){
        String sql = "SELECT profissional.codigo from profissional where profissional.cpf = '" + profissionalBean.getCpf() + "'";
        System.out.println(sql);
        try {
            
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            if(resultado.next()){
                
                this.id_profissional = resultado.getInt("codigo");
                System.out.println(this.id_profissional);
                resultado.close();
                
                String sql2 = "INSERT INTO endereco (id_profissional, bairro, cidade, logradouro, cep, estado, numero, complemento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                
                instrucao = conexao.prepareStatement(sql2);
            
                instrucao.setInt(1, this.getId_profissional());
                instrucao.setString(2, this.getBairro());
                instrucao.setString(3, this.getCidade());
                instrucao.setString(4, this.getLogradouro());
                instrucao.setString(5, this.getCep());
                instrucao.setString(6, this.getEstado());
                instrucao.setString(7, this.getNumero());
                instrucao.setString(8, this.getComplemento());

                instrucao.execute();
                instrucao.close();

                return true;
            }
            else{
                return false;
            }
        
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean atualizarInformacao(ProfissionalBean profissionalBean){
        
        String sql = "UPDATE endereco SET bairro = ?, cidade = ?, logradouro = ?, "
                + "cep = ?, estado = ?, numero = ?, complemento = ? WHERE id_profissional = ?";
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, this.getBairro());
            instrucao.setString(2, this.getCidade());
            instrucao.setString(3, this.getLogradouro());
            instrucao.setString(4, this.getCep());
            instrucao.setString(5, this.getEstado());
            instrucao.setString(6, this.getNumero());
            instrucao.setString(7, this.getComplemento());
            instrucao.setInt(8, profissionalBean.getCodigo());
            
            instrucao.executeQuery();
            instrucao.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean excluirInformacao(ProfissionalBean profissionalBean){
        String sql = "DELETE FROM endereco WHERE id_profissional = ?";
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, profissionalBean.getCodigo());
            instrucao.executeUpdate();
            instrucao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public EnderecoBean buscaInformacao(ProfissionalBean profissionalBean){
        
        String sql = "select * from endereco WHERE id_profissional = " + profissionalBean.getCodigo();
        EnderecoBean enderecoBean = new EnderecoBean();
        
        try {
            
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            
            ResultSet resultado = instrucao.executeQuery();
            
            if(resultado.next()){
                enderecoBean.setBairro(resultado.getString("bairro"));
                enderecoBean.setCidade(resultado.getString("cidade"));
                enderecoBean.setLogradouro(resultado.getString("logradouro"));
                enderecoBean.setCep(resultado.getString("cep"));
                enderecoBean.setEstado(resultado.getString("estado"));
                enderecoBean.setNumero(resultado.getString("numero"));
                enderecoBean.setComplemento(resultado.getString("complemento"));
                        
            }
            else{
                return null;
            }
            
            instrucao.close();
            resultado.close();
            
            return enderecoBean;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<EnderecoBean> listarInformacoes(String tipoPesquisa, String valor, String ordem){
        List<EnderecoBean> lsitaEnderecoBeans = new ArrayList<EnderecoBean>();
        
        String sql = null;
        
        if(tipoPesquisa.equals("codigo") && valor != null && !valor.isEmpty()){
            sql = "SELECT endereco.bairro, endereco.cidade, endereco.logradouro, endereco.cep, endereco.estado, endereco.numero, endereco.complemento, profissional.codigo FROM endereco, profissional WHERE endereco.id_profissional = " + valor + " AND endereco.id_profissional = profissional.codigo ORDER BY endereco.id_profissional";
        }
        else if(tipoPesquisa.equals("cpf") && valor != null && !valor.isEmpty()){
            sql = "SELECT endereco.bairro, endereco.cidade, endereco.logradouro, endereco.cep, " +
            "endereco.estado, endereco.numero, endereco.complemento, profissional.codigo FROM endereco, "
            + "profissional WHERE profissional.cpf = '" + valor + "' AND endereco.id_profissional = profissional.codigo ORDER BY " + ordem;
        }
        else if(tipoPesquisa.equals("nome") && valor != null && !valor.isEmpty()){
            sql = "SELECT endereco.bairro, endereco.cidade, endereco.logradouro, endereco.cep, endereco.estado, endereco.numero, endereco.complemento, profissional.codigo FROM endereco, profissional WHERE profissional.nome LIKE UPPER('" + valor + "') AND endereco.id_profissional = profissional.codigo ORDER BY " + ordem;
        }
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            while (resultado.next()) {                
                EnderecoBean enderecoBean = new EnderecoBean();
                enderecoBean.setBairro(resultado.getString("bairro"));
                enderecoBean.setCidade(resultado.getString("cidade"));
                enderecoBean.setLogradouro(resultado.getString("logradouro"));
                enderecoBean.setCep(resultado.getString("cep"));
                enderecoBean.setEstado(resultado.getString("estado"));
                enderecoBean.setNumero(resultado.getString("numero"));
                enderecoBean.setComplemento(resultado.getString("complemento"));
                
                lsitaEnderecoBeans.add(enderecoBean);
            }
            instrucao.close();
            resultado.close();
            
            return lsitaEnderecoBeans;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(int id_profissional) {
        this.id_profissional = id_profissional;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    

    
    
    
}
