<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Nova Locadora</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <jsp:useBean id="locadora" class="br.ufscar.dc.dsw.model.Locadora" />
        <h1>Nova Locadora</h1>
		
		<c:if test="${!empty requestScope.mensagens}">
			<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
			</ul>
		</c:if>
		
        <form action="novalocadora" method="post">
            <fieldset>
                <legend>Digite os dados da locadora:</legend>            
                Nome: <input name="nome_locadora" type="text" value="${sessionScope.novaLocadora.nome_locadora}" /><br/>
                CNPJ: <input name="cnpj_locadora" type="text" value="${sessionScope.novaLocadora.cnpj_locadora}"/><br/>
                Cidade: <input name="cidade_locadora" type="text" value="${sessionScope.novaLocadora.cidade_locadora}" /><br/>
                E-mail: <input name="email_locadora" type="text" value="${sessionScope.novaLocadora.email_locadora}"/><br/>
                Senha: <input name="senha_locadora" type="text" value="${sessionScope.novaLocadora.senha_locadora}"/><br/>
                <input type="submit" value="Enviar"/>
            </fieldset>
        </form>
    </body>
</html>