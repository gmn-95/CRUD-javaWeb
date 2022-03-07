<%-- 
    Document   : pesquisa.jsp
    Created on : 2 de mar de 2022, 18:34:52
    Author     : gustavo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css"><%@include file="/util/style.css" %></style>

<%@page import="br.com.siswebjee2.model.ProfissionalBean, java.util.List, java.util.ArrayList" %>


<form method="post" action="ProfissionalServletListar" onsubmit="return validaForm(this);">
    
    <div class="campo-tabela">
        <p>
            <strong>Listar</strong><br>
            Listar por :
            <input type="radio" name="ordem" id="tipoPesquisa" value="codigo" checked="checked"> Código |
            <input type="radio" name="ordem" id="tipoPesquisa" value="nome"> Nome |
            <input type="radio" name="ordem" id="tipoPesquisa" value="cpf"> CPF <br>
        </p>
        <table class="tabela">
            <thead>
               <tr>
                    <th>Código</th><th>Nome</th><th>CPF</th><th>Editar</th><th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                
            
               
            <%
                List<ProfissionalBean> listaProfissional = (List) request.getAttribute("profissional");
                
                int cont = 0;
                if(listaProfissional != null){
                    for(int i = 0; i < listaProfissional.size(); i++){
                        ProfissionalBean pro_novo = listaProfissional.get(i);
            %>
                <tr>
                    <td><%= pro_novo.getCodigo()%></td>
                    <td><%= pro_novo.getNome()%></td>
                    <td><%= pro_novo.getCpf()%></td>
                    <td><a href="ProfissionalServletPesquisar?valorProcurado=<%= pro_novo.getCodigo()%>&extra=editar">Editar</td>
                    <td><a href="ProfissionalServletPesquisar?valorProcurado=<%= pro_novo.getCodigo()%>&extra=excluir">Excluir</td>
                </tr>

            </tbody>
            <%
                    cont++;
                    }
                }
            %>
            
            
        </table>
            <tr>
                <td colspan="3">Foram encontrados <%= cont%> números de registos</td>
            </tr>
        <div class="campo">
            <button class="botao" type="submit" name="btListar" value="Listar"> Listar </button>
        </div>
    </div>
            
</form>


