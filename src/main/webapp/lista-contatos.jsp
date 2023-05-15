<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
          br.edu.ifsp.spo.* "%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
		</thead>
		<tbody>
		<jsp:useBean id="dao" class="br.edu.ifsp.spo.ContatoDao"></jsp:useBean>
		<c:forEach var="contato" items="${dao.contatos}">
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
	        	<td>${contato.endereco}</td>
	        	<td>${contato.dataNascimentoFormatada}</td>
	        </tr>
   		</c:forEach>
   		</tbody>
	</table>
</body>
</html>