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
        <title>Cadastro</title>
        </head>
    <body>
    <div class="container">
        <%
            String postId = request.getParameter("id");
        %>

        <form action="update.jsp" method="GET">
            <input type="text" name="id" value="<%=postId%>" style="display:none" readonly />
            <button class="btn btn-success">Editar</button>
        </form>"

        <%
            Post p = PostDAO.getById(postId);
            out.write("<h2>" + p.getTitle() + "</h2>");
            out.write("<p>" + p.getBody() + "</p>");
        %>

        <hr>

        <h4>Comentários</h4>
        <%
            List<Comment> comments = CommentDAO.listAllApprovedByPostId(postId);
            for (Comment c : comments) {
                out.write("<p>" + c.getUserId() + "</p>");
                out.write("<p>" + c.getBody() + "</p>");
            }
        %>

        <hr>

        <h4>Deixar um comentário</h4>
        <form action="/blog/comentar.jsp" method="POST">
            <div class="form-group">
                <textarea name="comment-body" id="comment-body" required></textarea>
            </div>

            <div class="form-group">
                <button class="btn btn-primary">Comentar</button>
            </div>
        </form>
    </div>
    </body>
</html>
