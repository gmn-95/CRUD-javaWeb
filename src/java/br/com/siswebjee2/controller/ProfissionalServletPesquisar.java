/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siswebjee2.controller;

import br.com.siswebjee2.model.EnderecoBean;
import br.com.siswebjee2.util.Conexao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.siswebjee2.model.ProfissionalBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author gustavo
 */
@WebServlet(name = "ProfissionalServletPesquisar", urlPatterns = {"/ProfissionalServletPesquisar"})
public class ProfissionalServletPesquisar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //RECEBA DA VIEW
       
        Conexao jdbc = new Conexao();
        String valorProcurado = request.getParameter("valorProcurado");
        String tipoPesquisa = request.getParameter("tipoPesquisa");
        String extra = request.getParameter("extra");
        String resposta = null;
        List<ProfissionalBean> listaProfissional = null;
        List<EnderecoBean> listaEndereco = null;
        
        ProfissionalBean profissionao_um = null;
        EnderecoBean endereco_um = new EnderecoBean();
        
        //comunicação direta com o BEAN
        ProfissionalBean profissionalBean = new ProfissionalBean();
        EnderecoBean enderecoBean = new EnderecoBean();
        
        if(jdbc.conectar()){
            profissionalBean.setConexao(jdbc.getConnection());
            enderecoBean.setConexao(jdbc.getConnection());
            
            if(tipoPesquisa != null){
                listaProfissional = profissionalBean.listarInformacoes(tipoPesquisa, valorProcurado, "codigo");
                listaEndereco = enderecoBean.listarInformacoes(tipoPesquisa, valorProcurado, "codigo");
                
                resposta = "index.jsp?acao=pesquisa&extra=" + extra;
                request.removeAttribute("profissional");
                request.setAttribute("endereco", listaEndereco);
                request.setAttribute("profissional", listaProfissional);
                
            }
            else{
                profissionao_um = profissionalBean.buscarInformacao(Integer.parseInt(valorProcurado));
                endereco_um = enderecoBean.buscaInformacao(profissionao_um);
                //System.out.println("valor =" + endereco_um.getBairro());
                resposta = "index.jsp?acao=" + extra;
                request.removeAttribute("profissional");
                request.setAttribute("endereco", endereco_um);
                request.setAttribute("profissional", profissionao_um);
                
            }
        }
        jdbc.desconectar();
        
        //retorna de volta à view
        RequestDispatcher view = request.getRequestDispatcher(resposta);
        view.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
