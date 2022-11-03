<html>
<head>

<%
    String username = request.getAttribute("username").toString();
    String privilege = request.getAttribute("privilege").toString();
    String userId = request.getAttribute("userId").toString();
    out.write("<p style='display:none' id='username'>" + username + "</p>");
    out.write("<p style='display:none 'id='privilege'>" + privilege + "</p>");
    out.write("<p style='display:none' id='userId'>" + userId + "</p>");
%>

<script>
    const username = document.getElementById("username").innerHTML;
    const privilege = document.getElementById("privilege").innerHTML;
    const userId = document.getElementById("userId").innerHTML;
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("privilege", privilege);
    sessionStorage.setItem("userId", userId);
    const redirectToUrl = "http://" + window.location.hostname + ":" +window.location.port;
    window.location.replace(redirectToUrl);
</script>

</head>


</html>