<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiblioTech - Bem-vindo</title>
</head>
<body>
    <div class="container">
        <h1>BiblioTech</h1>
        <p>Sua porta de entrada para o conhecimento. Explore, aprenda e gerencie sua coleção.</p>

        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/login" class="btn btn-login">Entrar</a>
            <a href="${pageContext.request.contextPath}/cadastro-usuario" class="btn btn-outline">Criar Conta</a>
        </div>

        <div class="footer">
            &copy; 2026 Sistema de Biblioteca Digital
        </div>
    </div>
</body>
</html>
