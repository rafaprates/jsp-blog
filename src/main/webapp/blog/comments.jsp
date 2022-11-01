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
            String approveCommentUrl = "approveComment.jsp?id=" + String.valueOf(c.getCommentId());
            out.write("<tr>");
                out.write("<td>" + c.getBody() + "</td>");
                out.write("<td>" + String.valueOf(c.getUserId()) + "</td>");
                out.write("<td>" +
                          "<form action='" + approveCommentUrl + "' method='POST'>" +
                          "<button class='btn btn-success'>Aprovar</button>" +
                          "</form>" +
                          "</td>");
            out.write("</tr>");
            }
        %>
            </table>
    </div>
    </body>
</html>
