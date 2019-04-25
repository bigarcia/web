<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
            <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Nova Locacao</h1>
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
                <td>cnpj</td>
                <td>${sessionScope.novaLocacao.cnpj_locacao}</td>
            </tr>
            <tr>
                <td>Nome</td>
                <td>${sessionScope.novaLocacao.nome_locacao}</td>
            </tr>
            <tr>
                <td>data</td>
                <td>${sessionScope.novaLocacao.data_locacao}</td>
            </tr>
            
        </table>
        <br/>
        <a href="GravarLocacaoServlet">Confirmar</a>
        <a href="novaLocacao.jsp">Modificar</a> <!--verificar-->
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
