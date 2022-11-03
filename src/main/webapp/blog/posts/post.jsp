<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.Entities.Comment" %>
<%@page import="com.blog.DAO.PostDAO" %>
<%@page import="com.blog.DAO.CommentDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Blog</title>
    </head>

    <body>
    <div class="container">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href="/index.jsp">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/login.jsp">Entrar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/registrar.jsp">Cadastrar-se</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled admin-element" href="#">Administrar</a>
              </li>
            </ul>
        </nav>

        <%
            String postId = request.getParameter("id");
            Post p = PostDAO.getById(postId);
        %>


        <div class='card mb-2'>
            <div class="card-header">
                <h2><%=p.getTitle().toUpperCase()%><h2>
                <form action="update.jsp" method="GET" class="admin-element">
                    <input type="hidden" name="id" value="<%=postId%>" readonly />
                    <button class="btn btn-success">Editar</button>
                </form>
            </div>
            <div class='card-body'>
                <%=p.getBody()%>
            </div>
        </div>


        <div class='card mb-2'>
            <div class='card-header'><h5>Comentários<h5></div>
            <div class='card-body'>
                <%
                    List<Comment> comments = CommentDAO.listAllApprovedByPostId(postId);
                    if (comments.size() < 1) {
                        out.write("<p class='card-text'>Ainda não há comentários. Seja o primeiro a comentar.</p>");
                    } else {
                        for (Comment c : comments) {
                            out.write("<p class='card-text'>" + c.getBody() + "</p>");
                            out.write("<p class='card-text'>" + c.getUserId() + "</p>");
                        }
                    }
                %>
            </div>


        <h5 class="ml-3">Deixar um comentário</h5>
        <p class="visitor-only-element ml-3">Para deixar um comentário é necessário estar logado.
        <a href="/autenticar/login.jsp">Entre</a> ou
        <a href="/autenticar/registrar.jsp">Registre-se</a>.
        </p>


        <form class="user-only-element ml-3" action="/blog/saveComment.jsp" method="POST">
            <div class="form-group">
                <textarea class="form-control" name="commentBody" id="comment-body" required></textarea>
                <input type="hidden" name="userId" id="userId" value="1">
                <input type="hidden" name="postId" id="userId" value=<%=postId%>>
            </div>

            <div class="form-group">
                <button class="btn btn-primary">Comentar</button>
            </div>
        </form>


    </div>
    <script src="/main.js"></script>
    <script>
        document.getElementById("userId").value = sessionStorage.getItem("userId");
    </script>
    </body>
</html>
