/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siswebjee2.controller;

import br.com.siswebjee2.model.EnderecoBean;
import br.com.siswebjee2.model.ProfissionalBean;
import br.com.siswebjee2.util.Conexao;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "ProfissionalServletEditar", urlPatterns = {"/ProfissionalServletEditar"})
public class ProfissionalServletEditar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Conexao jdbc = new Conexao();
        String resultado = null;
        
        //preparando as informações recebidas para datas
        String data1 = String.format("%s", request.getParameter("datacad"));
        String data2 = String.format("%s", request.getParameter("datanasc"));
        String data3 = String.format("%s", request.getParameter("documentoval"));
        
        //preparando as informações recebidas por valores
        String valor = request.getParameter("salario").replace(',', '.');
        
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Date datacad = formato.parse(data1);
            String nome = request.getParameter("nome").toUpperCase();
            String sexo = request.getParameter("sexo").toUpperCase();
            Date datanasc = formato.parse(data2);
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep");
            String telfixo = request.getParameter("telfixo");
            String telcel = request.getParameter("telcel");
            String email = request.getParameter("email");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String ctps = request.getParameter("ctps");
            int profissao = Integer.parseInt(request.getParameter("profissao"));
            int documentotipo = Integer.parseInt(request.getParameter("documentotipo"));
            String documentonr = request.getParameter("documentonr");
            Date documentoval = formato.parse(data3);
            int cargo = Integer.parseInt(request.getParameter("cargo"));
            double salario = Double.parseDouble(valor);
            int vinculotipo = Integer.parseInt(request.getParameter("vinculotipo"));
            String status = request.getParameter("status");
            String obs = request.getParameter("obs");
            
            ProfissionalBean profissionalBean = new ProfissionalBean(codigo, datacad, 
                    nome, sexo, datanasc, telfixo, telcel, email, rg, cpf, ctps, 
                    profissao, documentotipo, documentonr, documentoval, cargo, 
                    salario, vinculotipo, status, obs);
        
            EnderecoBean enderecoBean = new EnderecoBean(bairro, cidade, logradouro, cep, estado, numero, complemento);
            
            if(jdbc.conectar()){
                profissionalBean.setConexao(jdbc.getConnection());
                enderecoBean.setConexao(jdbc.getConnection());
                
                if(profissionalBean.atualizarInformacao() && enderecoBean.atualizarInformacao(codigo)){
                    resultado = "index.jsp?acao=confirma&tipo=edicao&ok=sim";
                }
                else{
                    resultado = "index.jsp?acao=confirma&tipo=edicao&ok=nao";
                }
            }
            
        } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
        }
        
        jdbc.desconectar();
        
        //RETORNA DE VOLTA PARA A VIEW
        RequestDispatcher view = request.getRequestDispatcher(resultado);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
