<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
            <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Nova Locadora</h1>
        <!--Deseja realmente cadastrar esta locadora?-->
        <br/>
        <br/>
        <table>
            <!--<tr>
                <td>E-mail</td>
                <td>${sessionScope.novoCliente.email_cliente}</td>
            </tr>
            <tr>
                <td>Senha</td>
                <td>${sessionScope.novoCliente.senha_cliente}</td>
            </tr> -->
            <tr>
                <td>CNPJ</td>
                <td>${sessionScope.novaLocadora.cnpj_locadora}</td>
            </tr>
            <tr>
                <td>Nome</td>
                <td>${sessionScope.novaLocadora.nome_locadora}</td>
            </tr>
            <tr>
                <td>Cidade</td>
                <td>${sessionScope.novaLocadora.cidade_locadora}</td>
            </tr>
            
        </table>
        <br/>
        <a href="GravarLocadoraServlet">Confirmar</a>
        <a href="novaLocadora.jsp">Modificar</a> <!--verificar-->
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
