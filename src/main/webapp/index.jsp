<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.DAO.PostDAO" %>
<%@ page import="java.util.List" %>

<html>
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
        List<Post> posts = PostDAO.listAll();
        for (Post p : posts) {
            String linkToPost = "blog/posts/post.jsp?id=" + p.getId();
            int maxPostLength = p.getBody().length();

            String postPreview;
            if (maxPostLength < 15) {
                postPreview = p.getBody();
            } else {
                postPreview = p.getBody().substring(0, 15).trim() + "...";
            }

            out.write("<div class='card mb-3'>" +
                        "<div class='card-body'>" +
                            "<h5 class='card-title mb-2'>" + p.getTitle().toUpperCase() + "</h5>" +
                            "<p class='card-text'>" + postPreview + "</p>" +
                            "<a class='card-link' href=" + linkToPost + ">Ler mais</a>" +
                        "</div>" +
                    "</div>"
                    );
        }
        %>
    </div>
    <script src="/main.js"></script>
</body>
</html>