<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Catálogo - BiblioTech</title>
</head>
<body>

<div class="navbar">
    <div class="logo"><strong>BiblioTech</strong></div>
    <div class="user-info">
        <c:choose>
            <c:when test="${not empty sessionScope.usuarioLogado}">
                Olá, <strong>${sessionScope.usuarioLogado.nome}</strong> (${sessionScope.usuarioLogado.perfil})
                <a href="${pageContext.request.contextPath}/logout">Sair</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Entrar</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div class="container">
    <c:if test="${not empty sessionScope.mensagem}">
        <div style="background: #d4edda; color: #155724; padding: 10px; border-radius: 4px; margin-bottom: 1rem;">
            ${sessionScope.mensagem}
            <% session.removeAttribute("mensagem"); %>
        </div>
    </c:if>
    <c:if test="${not empty sessionScope.erro}">
        <div style="background: #f8d7da; color: #721c24; padding: 10px; border-radius: 4px; margin-bottom: 1rem;">
            ${sessionScope.erro}
            <% session.removeAttribute("erro"); %>
        </div>
    </c:if>

    <div class="header-actions">
        <h1>Catálogo de Livros</h1>
        <c:if test="${sessionScope.usuarioLogado.admin}">
            <a href="${pageContext.request.contextPath}/livros/cadastrar" class="btn btn-add">+ Novo Livro</a>
        </c:if>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Ano</th>
                <th>Status</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="livro" items="${livros}">
                <tr>
                    <td>${livro.id}</td>
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.ano}</td>
                    <td>
                        <c:choose>
                            <c:when test="${livro.disponivel}">
                                <span class="badge badge-success">Disponível</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge badge-danger">Emprestado</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${sessionScope.usuarioLogado.admin}">
                            <a href="${pageContext.request.contextPath}/livros/editar?id=${livro.id}" class="btn btn-edit">Editar</a>
                            <form action="${pageContext.request.contextPath}/livros/excluir" method="post" style="display:inline" onsubmit="return confirm('Excluir livro?')">
                                <input type="hidden" name="id" value="${livro.id}">
                                <button type="submit" class="btn btn-delete">Excluir</button>
                            </form>
                        </c:if>
                        <c:if test="${not empty sessionScope.usuarioLogado and not sessionScope.usuarioLogado.admin and livro.disponivel}">
                            <form action="${pageContext.request.contextPath}/emprestimos/solicitar" method="post" style="display:inline">
                                <input type="hidden" name="idLivro" value="${livro.id}">
                                <button type="submit" class="btn btn-loan">Solicitar Empréstimo</button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
