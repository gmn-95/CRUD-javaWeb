<%-- 
    Document   : editar
    Created on : 3 de mar de 2022, 14:26:44
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css"><%@include file="/util/style.css" %></style>

<%@page import="br.com.siswebjee2.model.ProfissionalBean, br.com.siswebjee2.model.EnderecoBean, java.util.List, java.util.ArrayList" %>
<%@include file="/util/funcoes.jsp" %>

<%
    EnderecoBean enderecoBean = (EnderecoBean) request.getAttribute("endereco");
    ProfissionalBean profissionalBean = (ProfissionalBean) request.getAttribute("profissional");
    
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
%>

<form class=".formulario-2" method="post" action="ProfissionalServletExcluir" onsubmit="return validaForm(this);">
    
    
    <fieldset class="grupo">
        <div class="campo">
            <label><strong>Código </strong></label>
            <input type="text" name="codigo" id="codigo" disabled="true" size="4" maxlength="4" value="<%= profissionalBean.getCodigo()%>">
            <input type="hidden" name="codigo" id="codigo" value="<%= profissionalBean.getCodigo()%>">
        </div>
        <div class="campo">
            <label><strong>Data de cadastro </strong></label>
            <input type="text" name="datatela" disabled="true" size="10" maxlength="10" value="<%= formato.format(profissionalBean.getDatacad())%>">
            <input type="hidden" name="datacad" value="<%= formato.format(profissionalBean.getDatacad())%>">
        </div>
        <div class="campo">
            <label><strong>Nome </strong></label>
            <input type="text" name="nome" disabled="true" size="40" maxlength="40" id="nome" value="<%= profissionalBean.getNome()%>" required>
        </div>
        
    </fieldset>
        
        <fieldset>
            <div class="campo">
            <label><strong>Sexo </strong></label>
            <input type="radio" name="sexo" disabled="true" id="sexo_M" value="M" <%if(profissionalBean.getSexo().equals("M")) out.print("checked='checked'");%>> Maculino
            <input type="radio" name="sexo" disabled="true" id="sexo_F" value="F" <%if(profissionalBean.getSexo().equals("F")) out.print("checked='checked'");%>> Feminino
        </div>
        <div class="campo">
            <label><strong>Data de Nascimento </strong></label>
            <input type="text" name="datanasc" disabled="true" size="10" maxlength="10" required onkeypress="mascaraCampo(this, '##-##-####'); return somenteNumero(event);"
                   value="<%= formato.format(profissionalBean.getDatanasc())%>">
        </div>
        </fieldset>

    <div class="campo">
        <label><strong>Endereço</strong></label>
    </div>

    <fieldset class="grupo">
        <div  class="campo">
            <label>Logradouro</label>
            <input type="text" name="logradouro" disabled="true" size="20" maxlength="20" id="logradouro" value="<%=enderecoBean.getLogradouro()%>" required>
        </div>
        <div class="campo">
            <label>Número </label>
            <input type="text" name="numero" disabled="true" id="numero" size="5" maxlength="5" value="<%=enderecoBean.getNumero()%>" required>
        </div>
        <div class="campo">
            <label>Complemento </label>
            <input type="text" name="complemento" disabled="true" id="complemento" size="15" maxlength="15" value="<%=enderecoBean.getComplemento()%>">
        </div>
        <div class="campo">
            <label>Bairro </label>
            <input type="text" name="bairro" disabled="true" size="20" maxlength="20" id="bairro" required value="<%=enderecoBean.getBairro()%>">
        </div>
        <div class="campo">
            <label>Cidade </label>
            <input type="text" name="cidade" disabled="true" size="20" maxlength="20" id="cidade" required value="<%=enderecoBean.getCidade()%>">
        </div>
        <div class="campo">
            <label>Estado </label>
            <select name="estado" id="estado" disabled="true">
                <option value="<%=enderecoBean.getEstado()%>" selected="selected"><%=enderecoBean.getEstado()%></option>
                <option value="NF">Não informado</option>
                <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amapá</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Ceará</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Espirito Santo</option>
                <option value="GO">Goiás</option>
                <option value="MA">Maranhão</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MT">Mato Grosso</option>
                <option value="MG">Minas Gerais</option>
                <option value="PA">Pará</option>
                <option value="PB">Paraíba</option>
                <option value="PR">Paraná</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piauí</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RO">Rondônia</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SP">São Paulo</option>
                <option value="SE">Sergipe</option>
                <option value="TO">Tocantins</option>
            </select>
        </div>
        <div class="campo">
            <label>CEP </label>
            <input type="text" name="cep" disabled="true" id="cep" size="9" required maxlength="9" onkeypress="mascaraCampo(this, '#####-###'); return somenteNumero(event);"
                   value="<%=enderecoBean.getCep()%>"> <br>
        </div>
    </fieldset>

    <fieldset class="grupo">
        <div class="campo">
            <label>TelFixo </label>
            <input type="text" name="telfixo" disabled="true" size="12" maxlength="12" onkeypress="mascaraCampo(this, '##-####-####'); return somenteNumero(event);"
                   value="<%= profissionalBean.getTelfixo()%>">
        </div>
        <div class="campo">
            <label>TelCelular </label>
            <input type="text" name="telcel" disabled="true" size="13" maxlength="13" onkeypress="mascaraCampo(this, '##-#####-####'); return somenteNumero(event);"
                   value="<%= profissionalBean.getTelcel()%>">
        </div>
        <div class="campo">
            <label>E-mail </label>
            <input type="email" name="email" disabled="true" size="30" required maxlength="30" value="<%= profissionalBean.getEmail()%>">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Documentação</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>RG </label>
            <input type="text" name="rg" disabled="true" id="rg" size="18" required maxlength="18" value="<%= profissionalBean.getRg()%>">
        </div>
        <div class="campo">
            <label>CPF </label>
            <input type="text" name="cpf" disabled="true" id="cpf" size="14" maxlength="14" required onkeypress="mascaraCampo(this, '###.###.###-##'); return somenteNumero(event);"
                   value="<%= profissionalBean.getCpf()%>">
        </div>
        <div class="campo">
            <label>CTPS </label>
            <input type="text" name="ctps" disabled="true" id="ctps" size="8" maxlength="8" required onkeypress="mascaraCampo(this, '##.###-##'); return somenteNumero(event);"
                   value="<%= profissionalBean.getCtps()%>">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Dados Profissionais</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>Profissão</label>
            <%= gerarCaixaSelecao("profissao", "nome", profissionalBean.getProfissao(), false)%>
        </div>
        <div class="campo">
            <label>Conselho regulador</label>
            <%= gerarCaixaSelecao("documentotipo", "nome", profissionalBean.getDocumentotipo(), false)%>
        </div>
        <div class="campo">
            <label>Número da carteira profissional</label>
            <input type="text" name="documentonr" disabled="true" id="documentonr" size="10" required maxlength="10"
                   value="<%= profissionalBean.getDocumentonr()%>"><br>
        </div>
        <div class="campo">
            <label>Data de validade</label>
            <input type="text" name="documentoval" disabled="true" id="documentoval" size="10" required maxlength="10" value="<%= formato.format(profissionalBean.getDocumentoval())%>" onkeypress="mascaraCampo(this, '##-##-####'); return somenteNumero(event);">
             <input type="hidden" name="documentoval" disabled="true" value="<%= formato.format(profissionalBean.getDocumentoval())%>">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Situação Profissional</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>Cargo</label>
            <%= gerarCaixaSelecao("cargo", "nome", profissionalBean.getCargo(), false)%>
        </div>

        <div class="campo">
            <label>Salário</label>
            <input type="text" name="salario" disabled="true" id="salario" size="10" maxlength="10" onkeypress="return numerosDecimais(event, this);"
                   value="<%= String.valueOf(profissionalBean.getSalario()).replace('.', ',')%>">
        </div>
        
        <div class="campo">
            <label>Vínculo Empregatício</label>
            <%= gerarCaixaSelecao("vinculotipo", "nome", profissionalBean.getVinculotipo(), false)%>
        </div>

        <div class="campo">
            <label>Situação atual </label>
            <input type="radio" name="status" disabled="true" id="status_A" value="A" <%if(profissionalBean.getStatus().equals("A")) out.print("checked='checked'");%>> Ativo
            <input type="radio" name="status" disabled="true" id="status_F" value="F" <%if(profissionalBean.getStatus().equals("F")) out.print("checked='checked'");%>> Férias
            <input type="radio" name="status" disabled="true" id="status_L" value="L" <%if(profissionalBean.getStatus().equals("L")) out.print("checked='checked'");%>> Licença
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>OBS</strong></label>
        <input type="text" name="obs" disabled="true" id="obs" size="60" maxlength="60" value="<%= profissionalBean.getObs()%>">
    </div>

    <div class="campo">
        <button class="botao" type="submit" name="btExcluir" value="Excluir" onclick="window.confirm('Tem certeza que deseja excluir?')"> Excluir </button>
    </div>


</form>
