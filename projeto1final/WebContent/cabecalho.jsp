<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Pessoas</title>
</head>
<body>
<table border="1">
<tr><td><b>ID</b></td>
<td><b>Título</b></td>
<td><b>Descrição</b></td>
</tr>
<c:forEach var="post" items="${posts}" varStatus="id">
<tr bgcolor="#${id.count%2 == 0 ? 'bbffcc' : 'ffffbb' }" >
<td>${post.id}</td>
<td>${post.title}</td>
<td>${post.description}</td>
<td><form action='http://localhost:8080/projeto1final/atualiza' method='get'><input type='submit' value='Editar ${post.id}' name='id'/></form></td>
<td><form action='http://localhost:8080/projeto1final/remove' method='get'><input type='submit' value='Remover ${post.id}' name='id'/></form></td>
</tr>
</c:forEach>
</table>
<form action='http://localhost:8080/projeto1final/cria'><input type='submit' value='Ir para Criar'/></form>
</body>
</html>