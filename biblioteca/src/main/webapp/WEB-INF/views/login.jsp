<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - BiblioTech</title>
</head>
<body>
    <div class="login-card">
        <h2>Entrar no Sistema</h2>

        <c:if test="${not empty mensagem}">
            <p style="color: green;">${mensagem}</p>
        </c:if>

        <c:if test="${not empty erro}">
            <p style="color: red;">${erro}</p>
        </c:if>

        <form id="formLogin" action="${pageContext.request.contextPath}/login" method="post">
            <div>
                <label for="email">E-mail</label><br>
                <input type="email" id="email" name="email" required placeholder="seu@email.com">
            </div>
            <br>
            <div>
                <label for="senha">Senha</label><br>
                <input type="password" id="senha" name="senha" required placeholder="******">
            </div>
            <br>
            <span id="msgErro" style="color:red; display:none;"></span>
            <br>
            <button type="submit">Entrar</button>
        </form>

        <p>Não tem conta? <a href="${pageContext.request.contextPath}/cadastro-usuario">Criar conta</a></p>
    </div>

    <script src="${pageContext.request.contextPath}/assets/js/validacao-login.js"></script>
</body>
</html>
