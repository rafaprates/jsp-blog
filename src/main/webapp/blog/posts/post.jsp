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
        <%
            String postId = request.getParameter("id");
        %>

        <form action="update.jsp" method="GET">
            <input type="text" name="id" value="<%=postId%>" style="display:none" readonly />
            <button class="btn btn-success">Editar</button>
        </form>

        <div class='card mb-3'>
        <%
            Post p = PostDAO.getById(postId);
            out.write("<div class='card-header'><h2>" + p.getTitle().toUpperCase() + "<h2></div>");
            out.write("<div class='card-body'>" + p.getBody() + "</div>");
        %>
        </div>

        <div class='card mb-3'>
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
        </div>


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
