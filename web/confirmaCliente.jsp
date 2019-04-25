<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
            <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Novo Cliente</h1>
        <!--Deseja realmente cadastrar este cliente?-->
        <br/>
        <br/>
        <table>
            <tr>
                <td>Nome</td>
                <td>${sessionScope.novoCliente.nome_cliente}</td>
            </tr>
            <!--<tr>
                <td>E-mail</td>
                <td>${sessionScope.novoCliente.email_cliente}</td>
            </tr>
            <tr>
                <td>Senha</td>
                <td>${sessionScope.novoCliente.senha_cliente}</td>
            </tr> -->
            <tr>
                <td>CPF</td>
                <td>${sessionScope.novoCliente.cpf_cliente}</td>
            </tr>
            <tr>
                <td>Telefone</td>
                <td>${sessionScope.novoCliente.telefone_cliente}</td>
            </tr>
            <tr>
                <td>Data de Nascimento</td>
                <td>${sessionScope.novoCliente.nascimento_cliente}</td>
            </tr>
            <tr>
                <td>Sexo</td>
                <td>${sessionScope.novoCliente.sexo_cliente}</td>
            </tr>
            
        </table>
        <br/>
        <a href="GravarClienteServlet">Confirmar</a>
        <a href="novoCliente.jsp">Modificar</a> <!--verificar-->
        <a href="index.jsp">Cancelar</a>
    </body>
</html>