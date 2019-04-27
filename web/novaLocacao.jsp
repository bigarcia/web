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
        <jsp:useBean id="locacao" class="br.ufscar.dc.dsw.model.Locadora" />
        <h1>Nova Locação</h1>
		
		<c:if test="${!empty requestScope.mensagens}">
			<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
			</ul>
		</c:if>
		
        <form action="novalocacao" method="post">
            <fieldset>
                <legend>Digite seus dados:</legend>
                Nome da Locadora: 
                <select name="nome_locacao">
                    <c:forEach items="${locadora.nome}" var="nome_locadora">
                    <option value="${nome_locadora}" ${sessionScope.novaLocacao.nome_locadora eq nome_locadora ? 'selected' : ''}>${nome_locadora}</option>
                </c:forEach>
            </select> <br/>
                CNPJ: <input name="cnpj_locacao" type="text" value="${sessionScope.novaLocacao.cnpj_locacao}"/><br/>
                Data da Locacao: <input name="data_locacao" type="text" value="${sessionScope.novaLocacao.data_locacao}"/><br/>
                <input type="submit" value="Gravar"/>
            </fieldset>
        </form>
    </body>
</html>
