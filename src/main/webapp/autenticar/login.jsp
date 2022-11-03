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
        <title>Login</title>
        <style>
            .container {
                max-width: 400px;
            }
        </style>
        </head>
    <body>
    <div class="container">
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
                    RequestDispatcher rd = request.getRequestDispatcher("/autenticar/credenciarUsuario.jsp");
                    rd.forward(request, response);
                }
            }
        %>

        <form action="/autenticar/login.jsp" method="POST">
            <div class="form-group mt-5">
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

        <form class="mt-2" action="/autenticar/registrar.jsp" method="GET">
            <button class="btn btn-primary">Registrar-se</button>
        </form>
    </div>
    </body>
</html>
