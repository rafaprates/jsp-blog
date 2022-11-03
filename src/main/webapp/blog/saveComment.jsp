<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Comment" %>
<%@page import="com.blog.DAO.CommentDAO" %>
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

<%
    if (request.getMethod() == "POST") {
        String userId = request.getParameter("userId");
        String postId = request.getParameter("postId");
        String commentBody = request.getParameter("commentBody");

        Comment c = new Comment();
        c.setUserId(Integer.parseInt(userId));
        c.setPostId(Integer.parseInt(postId));
        c.setBody(commentBody);

        CommentDAO.save(c);
        response.sendRedirect("/blog/posts/post.jsp?id="+postId);
    }
%>

</body>
</html>
