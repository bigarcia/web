<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Locadoras</title>
		<link rel="stylesheet" type="text/css" href="estilo.css" />
	</head>
	<body>
		<h1>Locadoras</h1>
		<hr>
		<c:if test="${empty requestScope.listaLocadora}">
			Não há locadoras!
		</c:if>
		<c:if test="${!empty requestScope.listaLocadora}">
		<table>
			<tr>
				<th>Locadora</th>	
			</tr>
			<c:forEach items="${requestScope.listaLocadora}" var="locadora">
				<tr>
					<td>${locadora.email_locadora}</td>
					<td>${locadora.senha_locadora}</td>
					<td>${locadora.cnpj_locadora}</td>
					<td>${locadora.nome_locadora}</td>
					<td>${locadora.cidade_locadora}</td>	
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</body>
</html>
