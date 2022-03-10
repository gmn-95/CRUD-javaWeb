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
import java.text.SimpleDateFormat;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class ProfissionalBean {
    
    private int codigo;
    private Date datacad;
    private String nome;
    private String sexo;
    private Date datanasc;
    private String telfixo;
    private String telcel;
    private String email;
    private String rg;
    private String cpf;
    private String ctps;
    private int profissao;
    private int documentotipo;
    private String documentonr;
    private Date documentoval;
    private int cargo;
    private double salario;
    private int vinculotipo;
    private String status;
    private String obs;
    
    private Connection conexao;
    
    public ProfissionalBean(){
        
    }

    public ProfissionalBean(int codigo, Date datacad, String nome, String sexo, Date datanasc, String telfixo, String telcel, String email, String rg, String cpf, String ctps, int profissao, int documentotipo, String documentonr, Date documentoval, int cargo, double salario, int vinculotipo, String status, String obs) {
        this.codigo = codigo;
        this.datacad = datacad;
        this.nome = nome;
        this.sexo = sexo;
        this.datanasc = datanasc;
        this.telfixo = telfixo;
        this.telcel = telcel;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.ctps = ctps;
        this.profissao = profissao;
        this.documentotipo = documentotipo;
        this.documentonr = documentonr;
        this.documentoval = documentoval;
        this.cargo = cargo;
        this.salario = salario;
        this.vinculotipo = vinculotipo;
        this.status = status;
        this.obs = obs;
    }
    
    public ProfissionalBean(Date datacad, String nome, String sexo, Date datanasc, String telfixo, String telcel, String email, String rg, String cpf, String ctps, int profissao, int documentotipo, String documentonr, Date documentoval, int cargo, double salario, int vinculotipo, String status, String obs) {
        this.datacad = datacad;
        this.nome = nome;
        this.sexo = sexo;
        this.datanasc = datanasc;
        this.telfixo = telfixo;
        this.telcel = telcel;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.ctps = ctps;
        this.profissao = profissao;
        this.documentotipo = documentotipo;
        this.documentonr = documentonr;
        this.documentoval = documentoval;
        this.cargo = cargo;
        this.salario = salario;
        this.vinculotipo = vinculotipo;
        this.status = status;
        this.obs = obs;
    }
    
    public boolean gravarInformacao() {
        String sql = "INSERT INTO profissional(datacad, nome, sexo, datanasc, "
                + "telfixo, telcel, email, "
                + "rg, cpf, ctps, profissao, documentotipo, documentonr, documentoval, "
                + "cargo, salario, vinculotipo, status, obs) " 
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try{
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setDate(1, new java.sql.Date(this.getDatacad().getTime()));
            instrucao.setString(2, this.getNome());
            instrucao.setString(3, this.getSexo());
            instrucao.setDate(4, new java.sql.Date(this.getDatanasc().getTime()));
            instrucao.setString(5, this.getTelfixo());
            instrucao.setString(6, this.getTelcel());
            instrucao.setString(7, this.getEmail());
            instrucao.setString(8, this.getRg());
            instrucao.setString(9, this.getCpf());
            instrucao.setString(10, this.getCtps());
            instrucao.setInt(11, this.getProfissao());
            instrucao.setInt(12, this.getDocumentotipo());
            instrucao.setString(13, this.getDocumentonr());
            instrucao.setDate(14, new java.sql.Date(this.getDocumentoval().getTime()));
            instrucao.setInt(15, this.getCargo());
            instrucao.setDouble(16, this.getSalario());
            instrucao.setInt(17, this.getVinculotipo());
            instrucao.setString(18, this.getStatus());
            instrucao.setString(19, this.getObs());
           
            instrucao.execute();
            instrucao.close();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean atualizarInformacao(){
        String sql = "UPDATE profissional SET "
                + "datacad = ?, "
                + "nome = ?, sexo = ?, datanasc = ?, "
                + "telfixo = ?, telcel = ?, email = ?, rg = ?, cpf = ?, ctps = ?, "
                + "profissao = ?, documentotipo = ?, documentonr = ?, documentoval = ?,"
                + "cargo = ?, salario = ?, vinculotipo = ?, status = ?, obs = ? "
                + "where codigo = ?";
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setDate(1, new java.sql.Date(this.getDatacad().getTime()));
            instrucao.setString(2, this.getNome());
            instrucao.setString(3, this.getSexo());
            instrucao.setDate(4, new java.sql.Date(this.getDatanasc().getTime()));
            instrucao.setString(5, this.getTelfixo());
            instrucao.setString(6, this.getTelcel());
            instrucao.setString(7, this.getEmail());
            instrucao.setString(8, this.getRg());
            instrucao.setString(9, this.getCpf());
            instrucao.setString(10, this.getCtps());
            instrucao.setInt(11, this.getProfissao());
            instrucao.setInt(12, this.getDocumentotipo());
            instrucao.setString(13, this.getDocumentonr());
            instrucao.setDate(14, new java.sql.Date(this.getDocumentoval().getTime()));
            instrucao.setInt(15, this.getCargo());
            instrucao.setDouble(16, this.getSalario());
            instrucao.setInt(17, this.getVinculotipo());
            instrucao.setString(18, this.getStatus());
            instrucao.setString(19, this.getObs());
            instrucao.setInt(20, this.getCodigo());
            
            System.out.println(this.getDocumentoval());
            
            instrucao.executeUpdate();
            instrucao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluirInformacao(int codigo){
        String sql = "DELETE FROM profissional WHERE codigo = ?";
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, codigo);
            instrucao.executeUpdate();
            instrucao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ProfissionalBean buscarInformacao(int codigo){
        
        String sql = "SELECT * from profissional WHERE codigo = ?";
        ProfissionalBean profissionalBean = new ProfissionalBean();
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, codigo);
            ResultSet resultado = instrucao.executeQuery();
            
            if(resultado.next()){
                profissionalBean.setCodigo(resultado.getInt("codigo"));
                profissionalBean.setDatacad(resultado.getDate("datacad"));
                profissionalBean.setNome(resultado.getString("nome"));
                profissionalBean.setSexo(resultado.getString("sexo"));
                profissionalBean.setDatanasc(resultado.getDate("datanasc"));
                profissionalBean.setTelfixo(resultado.getString("telfixo"));
                profissionalBean.setTelcel(resultado.getString("telcel"));
                profissionalBean.setEmail(resultado.getString("email"));
                profissionalBean.setRg(resultado.getString("rg"));
                profissionalBean.setCpf(resultado.getString("cpf"));
                profissionalBean.setCtps(resultado.getString("ctps"));
                profissionalBean.setProfissao(resultado.getInt("profissao"));
                profissionalBean.setDocumentotipo(resultado.getInt("documentotipo"));
                profissionalBean.setDocumentonr(resultado.getString("documentonr"));
                profissionalBean.setDocumentoval(resultado.getDate("documentoval"));
                profissionalBean.setCargo(resultado.getInt("cargo"));
                profissionalBean.setSalario(resultado.getDouble("salario"));
                profissionalBean.setVinculotipo(resultado.getInt("vinculotipo"));
                profissionalBean.setStatus(resultado.getString("status"));
                profissionalBean.setObs(resultado.getString("obs"));
                
                System.out.println(resultado.getString("documentoval"));
                 System.out.println(resultado.getString("datanasc"));
            }
            else{
                profissionalBean = null;
            }
            
            instrucao.close();
            resultado.close();
            return profissionalBean;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ProfissionalBean> listarInformacoes(String tipoPesquisa, String valor, String ordem){
        List<ProfissionalBean> listaProfissional = new ArrayList<ProfissionalBean>();
        String sql = null;
        
        if(tipoPesquisa.equals("codigo") && valor != null && !valor.isEmpty()){
            sql = "SELECT * FROM profissional WHERE " + tipoPesquisa + " = " + valor + " ORDER BY " + ordem;
        }
        else if(tipoPesquisa.equals("cpf") && valor != null && !valor.isEmpty()){
            sql = "SELECT * FROM profissional WHERE " + tipoPesquisa +  " = '" + valor + "' ORDER BY " + ordem ;
        }
        else if(tipoPesquisa.equals("nome") && valor != null && !valor.isEmpty()){
            sql = "SELECT * FROM profissional WHERE " + tipoPesquisa + " LIKE '%" + valor.toUpperCase() + "%' ORDER BY " + ordem;
        }
        else if(tipoPesquisa.equals("codigo") && valor == null || valor.isEmpty()){
            sql = "SELECT * FROM profissional";
        }
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            while (resultado.next()) {                
                ProfissionalBean profissionalBean = new ProfissionalBean();
                profissionalBean.setCodigo(resultado.getInt("codigo"));
                profissionalBean.setDatacad(resultado.getDate("DATACAD"));
                profissionalBean.setNome(resultado.getString("nome"));
                profissionalBean.setSexo(resultado.getString("sexo"));
                profissionalBean.setDatanasc(resultado.getDate("datanasc"));
                profissionalBean.setTelfixo(resultado.getString("telfixo"));
                profissionalBean.setTelcel(resultado.getString("telcel"));
                profissionalBean.setEmail(resultado.getString("email"));
                profissionalBean.setRg(resultado.getString("rg"));
                profissionalBean.setCpf(resultado.getString("cpf"));
                profissionalBean.setCtps(resultado.getString("ctps"));
                profissionalBean.setProfissao(resultado.getInt("profissao"));
                profissionalBean.setDocumentotipo(resultado.getInt("documentotipo"));
                profissionalBean.setDocumentonr(resultado.getString("documentonr"));
                profissionalBean.setDocumentoval(resultado.getDate("documentoval"));
                profissionalBean.setCargo(resultado.getInt("cargo"));
                profissionalBean.setSalario(resultado.getDouble("salario"));
                profissionalBean.setVinculotipo(resultado.getInt("vinculotipo"));
                profissionalBean.setStatus(resultado.getString("status"));
                profissionalBean.setObs(resultado.getString("obs"));
                
                listaProfissional.add(profissionalBean);
                System.out.println(resultado.getString("documentoval"));
                 System.out.println(resultado.getString("datanasc"));
            }
            instrucao.close();
            resultado.close();
            
            return listaProfissional;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<ProfissionalBean> listarTodos(String ordem){
        List<ProfissionalBean> listaProfissional = new ArrayList<>();
        String sql = "SELECT * FROM profissional ORDER BY " + ordem;
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            while (resultado.next()) {                
                ProfissionalBean profissionalBean = new ProfissionalBean();
                profissionalBean.setCodigo(resultado.getInt("codigo"));
                profissionalBean.setDatacad(resultado.getDate("datacad"));
                profissionalBean.setNome(resultado.getString("nome"));
                profissionalBean.setSexo(resultado.getString("sexo"));
                profissionalBean.setDatanasc(resultado.getDate("datanasc"));
                profissionalBean.setTelfixo(resultado.getString("telfixo"));
                profissionalBean.setTelcel(resultado.getString("telcel"));
                profissionalBean.setEmail(resultado.getString("email"));
                profissionalBean.setRg(resultado.getString("rg"));
                profissionalBean.setCpf(resultado.getString("cpf"));
                profissionalBean.setCtps(resultado.getString("ctps"));
                profissionalBean.setProfissao(resultado.getInt("profissao"));
                profissionalBean.setDocumentotipo(resultado.getInt("documentotipo"));
                profissionalBean.setDocumentonr(resultado.getString("documentonr"));
                profissionalBean.setDocumentoval(resultado.getDate("documentoval"));
                profissionalBean.setCargo(resultado.getInt("cargo"));
                profissionalBean.setSalario(resultado.getDouble("salario"));
                profissionalBean.setVinculotipo(resultado.getInt("vinculotipo"));
                profissionalBean.setStatus(resultado.getString("status"));
                profissionalBean.setObs(resultado.getString("obs"));
                
                listaProfissional.add(profissionalBean);    
                System.out.println(resultado.getString("documentoval"));
                System.out.println(resultado.getString("datanasc"));
                
            }
            
            instrucao.close();
            resultado.close();
            return listaProfissional;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int geraCodigo(){
        String sql = "SELECT MAX(codigo) FROM profissional";
        int codigoNovo;
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            ResultSet resultado = instrucao.executeQuery();
            
            resultado.next();
            
            codigoNovo = 1 + resultado.getInt(1);
            
            instrucao.close();
            resultado.close();
            return codigoNovo;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDatacad() {
        return datacad;
    }

    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getTelfixo() {
        return telfixo;
    }

    public void setTelfixo(String telfixo) {
        this.telfixo = telfixo;
    }

    public String getTelcel() {
        return telcel;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public int getProfissao() {
        return profissao;
    }

    public void setProfissao(int profissao) {
        this.profissao = profissao;
    }

    public int getDocumentotipo() {
        return documentotipo;
    }

    public void setDocumentotipo(int documentotipo) {
        this.documentotipo = documentotipo;
    }

    public String getDocumentonr() {
        return documentonr;
    }

    public void setDocumentonr(String documentonr) {
        this.documentonr = documentonr;
    }

    public Date getDocumentoval() {
        return documentoval;
    }

    public void setDocumentoval(Date documentoval) {
        this.documentoval = documentoval;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getVinculotipo() {
        return vinculotipo;
    }

    public void setVinculotipo(int vinculotipo) {
        this.vinculotipo = vinculotipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    
    
    
}
