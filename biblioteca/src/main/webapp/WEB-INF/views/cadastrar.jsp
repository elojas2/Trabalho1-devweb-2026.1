<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Livro</title>
</head>
<body>
<h1>Cadastrar novo livro</h1>

<form id="formLivro" action="${pageContext.request.contextPath}/livros" method="post">
    <label>Título: <input type="text" name="titulo" id="titulo" required></label><br>
    <label>Autor: <input type="text" name="autor" id="autor" required></label><br>
    <label>Ano: <input type="number" name="ano" id="ano" required></label><br>
    <label>Disponível:
        <select name="disponivel">
            <option value="true">Sim</option>
            <option value="false">Não</option>
        </select>
    </label><br>
    <span id="msgErro" style="color:red; display:none;"></span><br>
    <button type="submit">Cadastrar</button>
</form>

<a href="${pageContext.request.contextPath}/livros">Voltar</a>

<script src="${pageContext.request.contextPath}/assets/js/validacao-livro.js"></script>
</body>
</html>