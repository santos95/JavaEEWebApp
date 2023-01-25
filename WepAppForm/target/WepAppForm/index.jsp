<%@page contentType="text/html" %>
<%@page import="java.util.Map" %>

<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>
<%--el atributo se debe castear a list string--%>
<%--Scriptlet java - hay objetos que incluye la jsp como response, request o out para imprimir--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<h3>Users Form</h3>
<%if (errors != null && errors.size() > 0) {%>
    <ul>
        <%for (String error : errors.values()) {%>
        <li><%=error%>
        </li>
        <%--jsp expressions - expresiones que se imprimen en pantalla--%>
        <%}%>
    </ul>
<%}%>
    <form action="/WepAppForm/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <div>
                <input type="text" class="form-control" name="username" id="username">
            </div>
            <% if(errors != null && errors.containsKey("username")) {
                out.println("<small style='color: red'>" + errors.get("username") + "</small>");
            }%>
        </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <div>
                <input type="password" class="form-control" name="pass" id="pass">
            </div>
            <% if(errors != null && errors.containsKey("pass")) {
                out.println("<small style='color: red'>" + errors.get("pass") + "</small>");
            }%>
        </div>
        <div class="form-group">
            <label for="email">E-Mail</label>
            <div>
                <input type="text" class="form-control" name="email" id="email">
            </div>
            <% if(errors != null && errors.containsKey("email")) {
                out.println("<small style='color: red'>" + errors.get("email") + "</small>");
            }%>
        </div>
        <div class="form-group">
            <label for="country">Countrys</label>
            <select name="country" class="form-control" id="country">
                <option value="NI">Nicaragua</option>
                <option value="AR">Argentina</option>
                <option value="MX">Mexico</option>
                <option value="IT">Italia</option>
                <option value="US">United States</option>
            </select>
            <% if(errors != null && errors.containsKey("country")) {
                out.println("<small style='color: red'>" + errors.get("country") + "</small>");
            }%>
        </div>
        <div class="form-group">
            <label for="lenguages">Lenguages</label>
            <div>
                <select class="form-control" name="lenguages" id="lenguages" multiple>
                    <option value="JAVA SE" selected>Java SE</option>
                    <option value="PY">Python</option>
                    <option value="PANDAS">Pandas</option>
                    <option value="JAKARTA EE">Jakarta EE</option>
                    <option value="SPRING">Spring</option>
                </select>
            </div>
            <% if(errors != null && errors.containsKey("lenguages")) {
                out.println("<small style='color: red'>" + errors.get("lenguages") + "</small>");
            }%>
        </div>
        <div>
            <label>Roles</label>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_ADMIN">
                <label class="from-check-label">ADMIN</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_USER" checked>
                <label class="form-check-label">USER</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_MODERATOR">
                <label class="form-check-label">MODERATOR</label>
            </div>
            <% if(errors != null && errors.containsKey("roles")) {
                out.println("<small style='color: red'>" + errors.get("roles") + "</small>");
            }%>
        </div>
        <div>
            <label>Idiomas</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="idioma" value="sp" checked>
                <label class="form-check-label">Spanish</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="idioma" value="en">
                <label class="form-check-label">English</label>
            </div>
            <div class="form-chech">
                <input type="radio" class="form-check-input" name="idioma" value="pr">
                <label class="form-check-label">Portugues</label>
            </div>
            <% if(errors != null && errors.containsKey("idioma"))
                out.println("<small style='color: red'>" + errors.get("idioma") + "</small>"); %>
        </div>
        <div class="form-controller">
            <label>Habilitar</label>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="habilitar" checked>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <div>
            <input type="hidden" name="secret" value="1234">
        </div>
    </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>