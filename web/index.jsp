<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoCliente" />
<c:remove scope="session" var="novaLocadora" />
<c:remove scope="session" var="novaLocacao" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locação</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Bem vindo à Locação</h1>
        <hr>
		
        <c:if test="${!empty mensagem}">
		${mensagem}
		<hr>
		</c:if>
		
        <p>Escolha o que deseja fazer:</p>
        <a href="novoCliente.jsp">Cadastrar Cliente</a><br/>
        <a href="novaLocadora.jsp">Cadastrar Locadora</a><br/>
        <a href="novaLocacao.jsp">Cadastrar Locação</a><br/>
        <a href="listaLocadoras.jsp">Listagem de todas as locadoras</a><br/>
        <!--<a href="listaLocadoraCidade.jsp">Listagem de todas as locadoras por cidade</a><br/> <!--Fazer
        <a href="listaLocacaoCliente.jsp">Listar todas as locações de um cliente</a><br/> <!--Fazer
        <a href="listaLocacaoLocadora.jsp">Listar todas as locações de uma locadora</a><br/><!--Fazer-->
    </body>
</html>
