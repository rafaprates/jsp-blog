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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Editar Post</title>
        </head>
    <body>
        <%
            String postId = request.getParameter("id");
            Post p = PostDAO.getById(postId);
            String title = p.getTitle();
            String body = p.getBody();

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


        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/index.jsp">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/login.jsp">Entrar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/registrar.jsp">Cadastrar-se</a>
              </li>
              <li class="nav-item dropdown admin-element active">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Administrar
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/blog/posts/create.jsp">Criar nova postagem</a>
                    <a class="dropdown-item" href="/blog/posts/listAll.jsp">Listar/editar todas as postagem</a>
                    <a class="dropdown-item" href="/blog/comments/comments.jsp">Aprovar comentários</a>
                  </div>
              </li>
            </ul>
        </nav>


            <form class="mb-5"  action="update.jsp" method="POST">
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
