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
import java.util.List;
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
@WebServlet(name = "ProfissionalServletListar", urlPatterns = {"/ProfissionalServletListar"})
public class ProfissionalServletListar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Conexao jdbc = new Conexao();
        String ordem = request.getParameter("ordem");
        String resposta = null;
        
        ProfissionalBean profissionalBean = new ProfissionalBean();
        EnderecoBean enderecoBean = new EnderecoBean();
        
        if(jdbc.conectar()){
            profissionalBean.setConexao(jdbc.getConnection());
            enderecoBean.setConexao(jdbc.getConnection());
            
            List<ProfissionalBean> listaProfissional = profissionalBean.listarTodos(ordem);
            resposta = "index.jsp?acao=listar";
            request.removeAttribute("profissional");
            request.setAttribute("profissional", listaProfissional);
        }
        
        jdbc.desconectar();
        
        RequestDispatcher view = request.getRequestDispatcher(resposta);
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
