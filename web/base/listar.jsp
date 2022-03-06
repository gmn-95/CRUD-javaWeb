<%-- 
    Document   : pesquisa.jsp
    Created on : 2 de mar de 2022, 18:34:52
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.siswebjee2.model.ProfissionalBean, java.util.List, java.util.ArrayList" %>

<form style="background-color: gray;" method="post" action="ProfissionalServletListar" onsubmit="return validaForm(this);">
    
    <div class="pesquisar">
        <p>
            <strong>Litar</strong><br>
            Ordem de pesquisa:
            <input type="radio" name="ordem" id="tipoPesquisa" value="codigo" checked="checked"> Código |
            <input type="radio" name="ordem" id="tipoPesquisa" value="nome"> Nome |
            <input type="radio" name="ordem" id="tipoPesquisa" value="cpf"> CPF <br>
        </p>
        <table cellpadding="1" cellpadding="1">
            <tr>
                <td>Código</td><td>Nome</td><td>CPF</td><td>Editar</td><td>Excluir</td>
            </tr>
               
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
                <td><a href="ProfissionalServletPesquisar?valorProcurado=<%= pro_novo.getCodigo()%>&extra=editar">Clique aqui para Editar</td>
                <td><a href="ProfissionalServletPesquisar?valorProcurado=<%= pro_novo.getCodigo()%>&extra=excluir">Clique aqui para Excluir</td>
            </tr>

            
            <%
                    cont++;
                    }
                }
            %>
            
            <tr>
                <td colspan="3">Foram encontrados <%= cont%> números de registos</td>
            </tr>
        </table>

        <div class="campo">
            <button class="botao" type="submit" name="btListar" value="Listar"> Listar </button>
        </div>
    </div>
    
</form>
