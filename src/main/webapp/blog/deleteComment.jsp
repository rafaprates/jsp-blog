<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Comment" %>
<%@page import="com.blog.DAO.CommentDAO" %>

<%
    if (request.getMethod() == "POST") {
        String commentId = request.getParameter("id");
        CommentDAO.delete(commentId);
        response.sendRedirect("/blog/comments.jsp");
    }
%>
