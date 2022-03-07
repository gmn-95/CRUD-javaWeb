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
@WebServlet(name = "ProfissionalServletExcluir", urlPatterns = {"/ProfissionalServletExcluir"})
public class ProfissionalServletExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Conexao jdbc = new Conexao();
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String resultado = null;
        
        ProfissionalBean profissionalBean = new ProfissionalBean();
        EnderecoBean enderecoBean = new EnderecoBean();
        
        if(jdbc.conectar()){
            profissionalBean.setConexao(jdbc.getConnection());
            enderecoBean.setConexao(jdbc.getConnection());
            
            if(enderecoBean.excluirInformacao(codigo) && profissionalBean.excluirInformacao(codigo)){
                resultado = "index.jsp?acao=confirma&tipo=exclusao&ok=sim";
            }
            else{
                resultado = "index.jsp?acao=confirma&tipo=exclusao&ok=nao";
            }
        }
        jdbc.desconectar();
        
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
