 <%-- 
    Document   : index
    Created on : 22 de fev de 2022, 15:13:28
    Author     : gustavo
--%>


  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!

    String acao;
    String opcao;
    String extra;
    String erro;
%>

<!DOCTYPE html>

<%
    
    acao = request.getParameter("acao");
    //erro = request.getParameter("erro");
    
    if(acao != null){
        
        if(acao.equals("novo")){
            opcao = "base/novo.jsp";
        }
        else if(acao.equals("Editar")){
            opcao = "base/editar.jsp";
        }
        else if(acao.equals("Excluir")){
            opcao = "base/excluir.jsp";
        }
        else if(acao.equals("listar")){
            opcao = "base/listar.jsp";
        }
        else if(acao.equals("home")){
            opcao = "base/home.jsp";
        }
        else if(acao.equals("confirma")){
            opcao = "base/confirma.jsp?tipo="
                    + request.getParameter("tipo")
                    + "&ok=" + request.getParameter("ok");
        }
        else if(acao.equals("pesquisar")){
            extra = request.getParameter("extra");
            opcao = "base/pesquisa.jsp?extra=" + extra;
        }
        else if(acao.equals("erro")){
            opcao = "base/novo.jsp?erro=false";
        }
    }
    else{
        opcao = "base/home.jsp";
    }

%>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="UTF-8">
        
        <title>Cadastro de Profissionais</title>
        <link rel="stylesheet" type="text/css" href="util/style.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script language="javascript" src="util/funcoes.js"></script>
        
    </head>
    <body>
        
        <div id="tudo">
            <nav>
                <input type="checkbox" id="check">
                <label for="check" class="checkbtn">
                    <i class="fas fa-bars"></i>
                </label>
                <label class="logo">SisWebJee</label>
                
                <ul>
                    <li><a class="active" href="index.jsp?acao=home">Home</a></li>
                </ul>
            </nav>
            
            <div id="cabecalho">
                <nav>
                    <ul>
                        <li><a href="index.jsp?acao=novo">Novo</a></li>
                        <li><a href="index.jsp?acao=pesquisar&extra=Editar">Editar</a></li>
                        <li><a href="index.jsp?acao=pesquisar&extra=Excluir">Excluir</a></li>
                        <li><a href="index.jsp?acao=listar">Listar</a></li>
                    </ul>
                </nav>
            </div>
       
            <main id="principal">
                <jsp:include page="<%= opcao%>"/> 
            </main>
           
            
             <!--<div id="teste">
                asdasdsasd
            </div>*-->
      
            <footer id="rodape">
                    <p>Desenvolvedor: Gustavo Macedo <br>Copyright &copy; SisWebJee &reg;</p>
            </footer>
        
        </div>

    </body>
</html>
