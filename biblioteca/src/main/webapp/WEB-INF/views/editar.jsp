<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Livro</title>
</head>
<body>
<h1>Editar livro</h1>

<form id="formLivro" action="${pageContext.request.contextPath}/livros/editar" method="post">
    <input type="hidden" name="id" value="${livro.id}">

    <label>Título: <input type="text" name="titulo" id="titulo" value="${livro.titulo}" required></label><br>
    <label>Autor: <input type="text" name="autor" id="autor" value="${livro.autor}" required></label><br>
    <label>Ano: <input type="number" name="ano" id="ano" value="${livro.ano}" required></label><br>
    <label>Disponível:
        <select name="disponivel">
            <option value="true" ${livro.disponivel ? 'selected' : ''}>Sim</option>
            <option value="false" ${not livro.disponivel ? 'selected' : ''}>Não</option>
        </select>
    </label><br>
    <span id="msgErro" style="color:red; display:none;"></span><br>
    <button type="submit">Salvar Alterações</button>
</form>

<a href="${pageContext.request.contextPath}/livros">Voltar</a>

<script src="${pageContext.request.contextPath}/assets/js/validacao-livro.js"></script>
</body>
</html>