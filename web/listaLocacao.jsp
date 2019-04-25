<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Locadoções</title>
		<link rel="stylesheet" type="text/css" href="estilo.css" />
	</head>
	<body>
		<h1>Locações</h1>
		<hr>
		<c:if test="${empty requestScope.listaLocacao}">
			Não há locações!
		</c:if>
		<c:if test="${!empty requestScope.listaLocacao}">
		<table>
			<tr>
				<th>Locacao</th>
			</tr>
			<c:forEach items="${requestScope.listaLocacao}" var="locacao">
				<tr>
					<td>${locacao.cnpj_locacao}</td>
					<td>${locacao.data_locacao}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</body>
</html>
