<%-- 
    Document   : confirma
    Created on : 1 de mar de 2022, 21:20:00
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String tipo = request.getParameter("tipo");
    String ok = request.getParameter("ok");
%>

<h1 id="confirmar"> O processo de <%= tipo %>, <%= ok%> foi concluído com sucesso! </h1>
