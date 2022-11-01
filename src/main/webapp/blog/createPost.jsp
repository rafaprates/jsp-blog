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
        <title>Cadastro</title>
        </head>
    <body>
    <div class="container">
        <form action="savePost.jsp" method="POST">
            <div class="form-group mt-5">
                <label for="title">Título</label>
                <input
                class="form-control"
                type="text"
                name="title"
                id="title"
                required
                />
            </div>

            <div class="form-group">
                <label for="body">Corpo</label>
                <textarea class="form-control" name="body" id="body" required>
                </textarea>
            </div>

            <div class="form-group">
                <label for="user">Usuário</label>
                <input class="form-control" type="number" name="userId" id="userId" value=1 readonly>
            </div>

            <div class="from-group">
                <button class="btn btn-primary">Postar</button>
            </div>
        </form>
    </div>
    </body>
</html>