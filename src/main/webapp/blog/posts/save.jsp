<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.DAO.PostDAO" %>

<%
    String title = request.getParameter("title");
    String body = request.getParameter("body");
    String userId = request.getParameter("userId");

    int userIdParsed = Integer.valueOf(userId);

    Post p = new Post();
    p.setTitle(title);
    p.setBody(body);
    p.setUserId(userIdParsed);
    PostDAO.save(p);

    response.sendRedirect("/index.jsp");
%>

