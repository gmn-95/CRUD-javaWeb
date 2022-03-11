<%-- 
    Document   : pesquisa.jsp
    Created on : 2 de mar de 2022, 18:34:52
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css"><%@include file="/util/style.css" %></style>

<%@page import="br.com.siswebjee2.model.ProfissionalBean, java.util.List, java.util.ArrayList" %>
<%
    String extra = request.getParameter("extra");
%>

<form class=".formulario-2" method="post" action="ProfissionalServletPesquisar?extra=<%= extra%>" onsubmit="return validaForm(this);">
    
    <div class="campo-tabela">
        <fildset>
            <strong><%= extra%></strong><br>
            Pesqusiar por:
            <input type="radio" name="tipoPesquisa" id="tipoPesquisa" value="codigo" checked="checked"> Código 
            <input type="radio" name="tipoPesquisa" id="tipoPesquisa" value="nome"> Nome 
            <input type="radio" name="tipoPesquisa" id="tipoPesquisa" value="cpf"> CPF <br>
            Digite o valor a ser pesquisado:
            <input type="text" name="valorProcurado" size="40" maxlength="40"> <br>
        </fildset>
        <table class="tabela">
            <thead>
               <tr>
                    <th>Código</th><th>Nome</th><th>CPF</th><th><%= extra%></th>
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
                <td><a href="ProfissionalServletPesquisar?valorProcurado=<%= pro_novo.getCodigo()%>&extra=<%= extra%>"><%= extra%></td>
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
            <button class="botao" type="submit" name="btPesquisar" value="Pesquisar"> Pesquisar </button>
        </div>
    </div>
    
</form>
