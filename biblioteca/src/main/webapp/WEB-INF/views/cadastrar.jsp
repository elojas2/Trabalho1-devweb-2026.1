<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Cadastrar Livro</title></head>
<body>
<h1>Cadastrar novo livro</h1>

<form action="${pageContext.request.contextPath}/livros" method="post">
  <label>Título: <input type="text" name="titulo" required></label><br>
  <label>Autor: <input type="text" name="autor" required></label><br>
  <label>Ano: <input type="number" name="ano" required></label><br>
  <label>Disponível:
    <select name="disponivel">
      <option value="true">Sim</option>
      <option value="false">Não</option>
    </select>
  </label><br>
  <button type="submit">Cadastrar</button>
</form>

<a href="${pageContext.request.contextPath}/livros">Voltar</a>
</body>
</html>