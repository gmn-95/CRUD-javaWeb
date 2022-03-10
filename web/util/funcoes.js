
function mascaraCampo(item, formato){
    var campo = item.value.length;
    var resultado = formato.substring(0, 1);
    var texto = formato.substring(campo);
    
    if(texto.substring(0, 1) !== resultado){
        item.value += texto.substring(0, 1);
    }
} 

function somenteNumero(e){
    navegador = /msie/i.test(navigator.userAgent);
    
    if(navegador){
        var caractere = event.keyCode;
    }
    else{
        var caractere = e.which;
    }
    
    if(caractere > 47 && caractere < 58){
        return true;
    }
    else{
        if(caractere !== 8){
            return false;
        }
        else{
            return true;
        }
    }
}

function confirmar(parametro, acao, aviso, pagina){
    if(window.confirm(aviso)){
        location.href = pagina + "?acao=" + acao + "&codigo=" + parametro;
    }
}

function numerosDecimais(e, field){
    navegador = /msie/i.test(navigator.userAgent);

    if(navegador){
        var caractere = e.keyCode;
    }
    else{
        var caractere = e.which;
    }

    if((caractere > 47) && (caractere < 57) || caractere == 44){
        if(caractere == 44){
            var patter = new RegExp("\\,");
            var ch = patter.exec(field.value);

            if(ch == ","){
                alert("Só é permitido um separador decimal!");
                return false;
            }
        }
    }

    return true;
}

function validaForm(form){
    if(form.salario.value === ""){
        alert("Insira um valor para o campo salário!");
        form.salario.focus();
        return false;
    }
}
