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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Gerenciar comentários</title>
        </head>
    <body>
    <div class="container">

        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/index.jsp">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/login.jsp">Entrar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/registrar.jsp">Cadastrar-se</a>
              </li>
              <li class="nav-item dropdown admin-element active">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Administrar
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/blog/posts/create.jsp">Criar nova postagem</a>
                    <a class="dropdown-item" href="/blog/posts/listAll.jsp">Listar/editar todas as postagem</a>
                    <a class="dropdown-item" href="/blog/comments.jsp">Aprovar comentários</a>
                  </div>
              </li>
            </ul>
        </nav>


        <h2>Central de aprovação de comentários</h2>
        <hr>


        <h4>Pendentes</h4>
            <table class=table>
                <thead>
                    <th>Comentário</th>
                    <th>Por</th>
                    <th>Ação</th>
                </thead>
        <%
            List<Comment> comments = CommentDAO.listAllUnapproved();
            for (Comment c : comments) {
            String approveCommentUrl = "/blog/comments/approve.jsp?id=" + String.valueOf(c.getCommentId());
            String deleteCommentUrl = "/blog/comments/delete.jsp?id=" + String.valueOf(c.getCommentId());
            out.write("<tr>");
                out.write("<td>" + c.getBody() + "</td>");
                out.write("<td>" + String.valueOf(c.getUserId()) + "</td>");
                out.write("<td class='d-flex'>" +
                          "<form class = 'mr-2' action='" + approveCommentUrl + "' method='POST'>" +
                          "<button class='btn btn-success'>Aprovar</button>" +
                          "</form>" +
                          "<form action='" + deleteCommentUrl + "' method='POST'>" +
                          "<button class='btn btn-danger'>Deletar</button>" +
                          "</form>" +
                          "</td>");
            out.write("</tr>");
            }
        %>
            </table>
    </div>
    <script src="/main.js"></script>
    </body>
</html>
