<%-- 
    Document   : funcoes
    Created on : 1 de mar de 2022, 16:43:00
    Author     : gustavo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.siswebjee2.model.ProfissionalBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.siswebjee2.util.Conexao"%>
<%@page import="br.com.siswebjee2.model.InformacaoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    public String gerarCaixaSelecao(String tabela, String ordem, int valor, boolean ativa){
        String caixaSelecao = "<select name='" + tabela + "'>\n";
        if(ativa == false){
            caixaSelecao = "<select name'" + tabela + "' disable='true' >\n" ;
        }
        
        InformacaoBean infoCs = new InformacaoBean();
        Conexao jdbc = new Conexao();

        if(jdbc.conectar()){
            infoCs.setConexao(jdbc.getConnection());
            List infoLista = infoCs.listarInformacoes(tabela, ordem);
            
            if(infoLista != null){
                InformacaoBean info_um;

                for(int i = 0; i < infoLista.size(); i++){

                    info_um = (InformacaoBean) infoLista.get(i);
                    caixaSelecao += "<option value='" + info_um.getCodigo() + "'";
                    
                    if(valor > 0){
                        if(info_um.getCodigo() == valor){
                            caixaSelecao += " selected='selected' ";
                        } 
                    }
                    caixaSelecao += " >" + info_um.getNome() + "</option>\n";
                }
            }
            else{
                caixaSelecao += "<option> Tabela Vazia! </option>\n";
            }
        }
        else{
            caixaSelecao += "<option>Erro ao conectar com o BD!</option>\n";
        }
        jdbc.desconectar();
        caixaSelecao += "</select>";
        return caixaSelecao;
    }   
    
    public String gerarDataHoje(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date dataHoje = new Date();

        return formato.format(dataHoje);
    }

    public int novoCodigo(){
        ProfissionalBean pb = new ProfissionalBean();
        Conexao jdbc = new Conexao();
        int codigoNovo;

        if(jdbc.conectar()){
            pb.setConexao(jdbc.getConnection());
            codigoNovo = pb.geraCodigo();
        }
        else{
            return 0;
        }
        jdbc.desconectar();
        return codigoNovo;
    }
%>
