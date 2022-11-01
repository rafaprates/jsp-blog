<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.DAO.PostDAO" %>
<%@ page import="java.util.List" %>

<html>
<body>
<h2>Hello World!</h2>

<a href="blog/createPost.jsp">Create new post</a>
<a href="blog/listPosts.jsp">List all posts</a>

<hr>

    <div class="container">
        <%
        List<Post> posts = PostDAO.listAll();
        for (Post p : posts) {
            out.write("Título: " + p.getTitle() + " por usuário: " + p.getUserId());
            out.write("<br>");
            out.write("Corpo: " + p.getBody());
            out.write("<br>");
            out.write("<hr>");
        }
        %>
    </div>
</body>
</html>

<%


%>