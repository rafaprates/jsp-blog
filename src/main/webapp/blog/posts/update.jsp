<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.Post" %>
<%@page import="com.blog.DAO.PostDAO" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Editar Post</title>
        </head>
    <body>
        <%
            String postId = request.getParameter("id");
            Post p = PostDAO.getById(postId);
            String title = p.getTitle();
            String body = p.getBody();

            out.write(request.getMethod());

            if (request.getMethod() == "POST") {
                String newTitle = request.getParameter("title");
                String newBody = request.getParameter("body");
                p.setTitle(newTitle);
                p.setBody(newBody);
                PostDAO.updatePost(p);
                response.sendRedirect("/index.jsp");
            }
        %>

        <div class="container">
            <form action="update.jsp" method="POST">
                <input type='text' name='id' value='<%=postId%>' style='display:none' readonly/>

                <div class="form-group mt-5">
                    <label for="title">Título</label>
                    <input
                    class="form-control"
                    type="text"
                    name="title"
                    id="title"
                    value="<%=title%>"
                    required
                    />
                </div>

                <div class="form-group">
                    <label for="body">Corpo</label>
                    <textarea class="form-control" name="body" id="body" rows="15"><%=body%></textarea>
                </div>

                <div class="form-group">
                    <label for="user">Usuário</label>
                    <input class="form-control" type="number" name="userId" id="userId" value=1 readonly>
                </div>

                <div class="from-group d-flex gap-3">
                    <form action="/blog/posts/update.jsp" method="POST">
                        <input type='text' name='id' value='<%=postId%>' style='display:none' readonly/>
                        <button class="btn btn-warning mr-3">Modificar Post</button>
                    </form>

                    <form action="/blog/posts/delete.jsp" method="POST">
                        <input type='text' name='id' value='<%=postId%>' style='display:none' readonly/>
                        <button class="btn btn-danger">Excluir</button>
                    </form>
                </div>
            </form>
        </div>
    </body>
</html>
