<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Novo Cliente</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <jsp:useBean id="cliente" class="br.ufscar.dc.dsw.model.Cliente" />
        <h1>Novo cliente</h1>

        <c:if test="${!empty requestScope.mensagens}">
                <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                        <li>${mensagem}</li>
                </c:forEach>
                </ul>
        </c:if>
		
        <form action="NovoClienteServlet" method="post">
            <fieldset>
                <legend>Digite seus dados:</legend>
                Nome: <input name="nome_cliente" type="text" value="${sessionScope.novoCliente.nome_cliente}" /><br/>
                CPF: <input name="cpf_cliente" type="text" value="${sessionScope.novoCliente.cpf_cliente}"/><br/>
                Telefone: <input name="telefone_cliente" type="text" value="${sessionScope.novoCliente.telefone_cliente}" /><br/>
                Sexo: <input name="sexo_cliente" type="text" value="${sessionScope.novoCliente.sexo_cliente}"/><br/>
                Data de nascimento: <input name="nascimento_cliente" type="date" value="${sessionScope.novoCliente.nascimento_cliente}" /><br/>
                E-mail: <input name="email_cliente" type="text" value="${sessionScope.novoCliente.email_cliente}"/><br/>
                Senha: <input name="senha_cliente" type="text" value="${sessionScope.novoCliente.senha_cliente}"/><br/>
                
                
                
                <input type="submit" value="Enviar"/>
            </fieldset>
        </form>
    </body>
</html>
