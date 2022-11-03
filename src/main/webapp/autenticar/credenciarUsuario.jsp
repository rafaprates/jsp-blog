<html>
<head>

<%
    String username = request.getAttribute("username").toString();
    String privilege = request.getAttribute("privilege").toString();
    out.write("<p id='username'>" + username + "</p>");
    out.write("<p id='privilege'>" + privilege + "</p>");
    out.write(username);
    out.write(privilege);
%>

<script>
    var username = document.getElementById("username").innerHTML;
    var privilege = document.getElementById("privilege").innerHTML;
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("privilege", privilege);
</script>

</head>

</html>