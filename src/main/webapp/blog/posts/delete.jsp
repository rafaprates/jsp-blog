<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.DAO.PostDAO" %>

<%
    if (request.getMethod() == "POST") {
        String postId = request.getParameter("id");
        String status = PostDAO.delete(postId);
        response.sendRedirect("/index.jsp");
    }
%>