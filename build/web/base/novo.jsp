<%-- 
    Document   : novo
    Created on : 28 de fev de 2022, 15:10:27
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/util/funcoes.jsp" %>


<form class="formulario" method="post" action="ProfissionalServletCadastrar" onsubmit="return validaForm(this);">
    
    
    
    <fieldset class="grupo">
        <div class="campo">
            <label><strong>Código </strong></label>
            <input type="text" name="codigo" id="codigo" disabled="true" size="4" maxlength="4" value="<%= novoCodigo()%>">
            <input type="hidden" name="codigo" id="codigo" value="<%= novoCodigo()%>">
        </div>
        <div class="campo">
            <label><strong>Data de cadastro </strong></label>
            <input type="text" name="datatela" disabled="true" size="10" maxlength="10" value="<%= gerarDataHoje()%>">
            <input type="hidden" name="datacad" value="<%= gerarDataHoje()%>">
        </div>
        <div class="campo">
            <label><strong>Nome </strong></label>
            <input type="text" name="nome" size="40" maxlength="40" id="nome" required>
        </div>
        
    </fieldset>
        
        <fieldset>
            <div class="campo">
            <label><strong>Sexo </strong></label>
            <input type="radio" name="sexo" id="sexo_M" value="M" checked="checked"> Maculino
            <input type="radio" name="sexo" id="sexo_F" value="F"> Feminino
        </div>
        <div class="campo">
            <label><strong>Data de Nascimento </strong></label>
            <input type="text" name="datanasc" size="10" maxlength="10" required onkeypress="mascaraCampo(this, '##-##-####'); return somenteNumero(event);">
        </div>
        </fieldset>

    <div class="campo">
        <label><strong>Endereço</strong></label>
    </div>

    <fieldset class="grupo">
        <div  class="campo">
            <label>Logradouro</label>
            <input type="text" name="logradouro" size="20" maxlength="20" id="logradouro" required>
        </div>
        <div class="campo">
            <label>Número </label>
            <input type="text" name="numero" id="numero" size="5" maxlength="5" required>
        </div>
        <div class="campo">
            <label>Complemento </label>
            <input type="text" name="complemento" id="complemento" size="15" maxlength="15">
        </div>
        <div class="campo">
            <label>Bairro </label>
            <input type="text" name="bairro" size="20" maxlength="20" id="bairro" required>
        </div>
        <div class="campo">
            <label>Cidade </label>
            <input type="text" name="cidade" size="20" maxlength="20" id="cidade" required>
        </div>
        <div class="campo">
            <label>Estado </label>
            <select name="estado" id="estado">
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
            <input type="text" name="cep" id="cep" size="9" required maxlength="9" onkeypress="mascaraCampo(this, '#####-###'); return somenteNumero(event);"> <br>
        </div>
    </fieldset>

    <fieldset class="grupo">
        <div class="campo">
            <label>TelFixo </label>
            <input type="text" name="telfixo" size="12" maxlength="12" onkeypress="mascaraCampo(this, '##-####-####'); return somenteNumero(event);">
        </div>
        <div class="campo">
            <label>TelCelular </label>
            <input type="text" name="telcel" size="13" maxlength="13" onkeypress="mascaraCampo(this, '##-#####-####'); return somenteNumero(event);">
        </div>
        <div class="campo">
            <label>E-mail </label>
            <input type="email" name="email" size="30" required maxlength="30">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Documentação</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>RG </label>
            <input type="text" name="rg" id="rg" size="18" required maxlength="18">
        </div>
        <div class="campo">
            <label>CPF </label>
            <input type="text" name="cpf" id="cpf" size="14" maxlength="14" required onkeypress="mascaraCampo(this, '###.###.###-##'); return somenteNumero(event);">
        </div>
        <div class="campo">
            <label>CTPS </label>
            <input type="text" name="ctps" id="ctps" size="8" maxlength="8" required onkeypress="mascaraCampo(this, '##.###-##'); return somenteNumero(event);">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Dados Profissionais</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>Profissão</label>
            <%= gerarCaixaSelecao("profissao", "nome", 0, true)%>
        </div>
        <div class="campo">
            <label>Conselho regulador</label>
            <%= gerarCaixaSelecao("documentotipo", "nome", 0, true)%>
        </div>
        <div class="campo">
            <label>Número da carteira profissional</label>
            <input type="text" name="documentonr" id="documentonr" size="10" required maxlength="10"><br>
        </div>
        <div class="campo">
            <label>Data de validade</label>
            <input type="text" name="documentoval" id="documentoval" size="10" required maxlength="10" onkeypress="mascaraCampo(this, '##-##-####'); return somenteNumero(event);">
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>Situação Profissional</strong></label>
    </div>

    <fieldset class="grupo">
        <div class="campo">
            <label>Cargo</label>
            <%= gerarCaixaSelecao("cargo", "nome", 0, true)%>
        </div>

        <div class="campo">
            <label>Salário</label>
            <input type="text" name="salario" id="salario" size="10" maxlength="10" onkeypress="return numerosDecimais(event, this);">
        </div>
        
        <div class="campo">
            <label>Vínculo Empregatício</label>
            <%= gerarCaixaSelecao("vinculotipo", "nome", 0, true)%>
        </div>

        <div class="campo">
            <label>Situação atual </label>
            <input type="radio" name="status" id="status_A" value="A" checked="checked"> Ativo
            <input type="radio" name="status" id="status_F" value="F" checked="checked"> Férias
            <input type="radio" name="status" id="status_L" value="L" checked="checked"> Licença
        </div>
    </fieldset>

    <div class="campo">
        <label><strong>OBS</strong></label>
        <input type="text" name="obs" id="obs" size="60" maxlength="60">
    </div>

    <div class="campo">
        <button class="botao" type="submit" name="btGravar" value="Gravar"> Gravar </button>
        <button class="botao" type="reset" name="btLimpar" value="Limpar"> Limpar </button>
    </div>


</form>
        

