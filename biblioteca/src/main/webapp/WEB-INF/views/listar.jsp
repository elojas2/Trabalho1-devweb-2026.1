<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Biblioteca</title></head>
<body>
<h1>Livros cadastrados</h1>

<a href="${pageContext.request.contextPath}/livros/cadastrar">Cadastrar novo livro</a>

<table border="1">
    <tr>
        <th>ID</th><th>Título</th><th>Autor</th><th>Ano</th><th>Disponível</th><th>Ações</th>
    </tr>
    <c:forEach var="livro" items="${livros}">
        <tr>
            <td>${livro.id}</td>
            <td>${livro.titulo}</td>
            <td>${livro.autor}</td>
            <td>${livro.ano}</td>
            <td>${livro.disponivel ? 'Sim' : 'Não'}</td>
            <td>
                <a href="${pageContext.request.contextPath}/livros/editar?id=${livro.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/livros/excluir?id=${livro.id}" 
                   onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>