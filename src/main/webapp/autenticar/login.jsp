<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.blog.Entities.User" %>
<%@page import="com.blog.DAO.UserDAO" %>
<%@ page import="java.util.List" %>

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
        <title>Login</title>
        <style>
            .register-box {
                max-width: 400px;
            }
        </style>
    </head>


    <body>
        <% String loginFeedback = ""; %>
        <%
            if (request.getMethod() == "POST") {
                String username = request.getParameter("username");
                String passcode = request.getParameter("passcode");

                User u = new User();
                u = UserDAO.getByUsername(username);

                if (u == null || !passcode.equals(u.getPasscode())) {
                    loginFeedback = "Usuário ou senha incorretos. Tente novamente.";
                } else {
                    request.setAttribute("username", u.getUsername());
                    request.setAttribute("privilege", u.getPrivilege());
                    request.setAttribute("userId", u.getUserId());
                    RequestDispatcher rd = request.getRequestDispatcher("/autenticar/credenciarUsuario.jsp");
                    rd.forward(request, response);
                }
            }
        %>


        <div class="container">

        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/index.jsp">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/autenticar/login.jsp">Entrar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/autenticar/registrar.jsp">Cadastrar-se</a>
              </li>
              <li class="nav-item dropdown admin-element">
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

            <section class="row justify-content-center">
                <h2 class="mb-3 mt-5 user-only-element">Você já está logado. <a href="/autenticar/endSession.jsp">Sair</a></h2>
                <div class="register-box visitor-only-element">
                    <h2 class="mb-3 mt-5">Entre ou registre-se, é de graça!</h2>

                    <form action="/autenticar/login.jsp" method="POST">
                        <div class="form-group">
                            <label for="username">Usuário</label>
                            <input
                            class="form-control"
                            type="text"
                            name="username"
                            id="username"
                            required
                            />
                        </div>

                        <div class="form-group">
                            <label for="passcode">Senha</label>
                            <input
                            class="form-control"
                            type="password"
                            name="passcode"
                            id="passcode"
                            required
                            />
                        </div>
                        <p>
                            <%
                                if (!loginFeedback.isEmpty()) { out.write(loginFeedback); }
                            %>
                         </p>
                        <button class="btn btn-primary">Entrar</button>
                    </form>

                    <p class="mt-2">Ainda não tem conta? <a href="/autenticar/registrar.jsp">Cadastre-se</a></p>

                </div>
            </section>
    </div>
    <script src="/main.js"></script>
    </body>
</html>
