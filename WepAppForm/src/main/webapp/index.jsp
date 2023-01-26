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
    <ul class="alert alert-danger mx-5 px-5">
        <%for (String error : errors.values()) {%>
        <li><%=error%>
        </li>
        <%--jsp expressions - expresiones que se imprimen en pantalla--%>
        <%}%>
    </ul>
<%}%>
<div class="px-5">
    <form class="align-items-center" action="/WepAppForm/register" method="post">
        <div class="form-group row mb-3">
            <label for="username" class="col-form-label">Username</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="username" id="username" value="${param.username}">
            </div>
            <% if(errors != null && errors.containsKey("username")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("username") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="pass" class="col-form-label">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="pass" id="pass">
            </div>
            <% if(errors != null && errors.containsKey("pass")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("pass") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="email" class="col-form-label">E-Mail</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="email" id="email" value="${param.email}">
            </div>
            <% if(errors != null && errors.containsKey("email")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("email") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="country" class="col-form-label col-sm-2">Countrys</label>
            <select name="country" class="form-control" id="country" class="form-select">
                <option value="">--select--</option>
                <option value="NI" ${param.country.equals("NI") ? "selected" : "" }>Nicaragua</option>
                <option value="AR" ${param.country.equals("AR") ? "selected" : ""}>Argentina</option>
                <option value="MX" ${param.country.equals("MX") ? "selected" : ""}>Mexico</option>
                <option value="IT" ${param.country.equals("MX") ? "selected" : ""}>Italia</option>
                <option value="US" ${param.country.equals("MX") ? "selected" : ""}>United States</option>
            </select>
            <% if(errors != null && errors.containsKey("country")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("country") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="lenguages" class="col-form-label col-sm-2">Lenguages</label>
            <div class="col-sm-4">
                <select class="form-control" name="lenguages" id="lenguages" multiple class="form-select">
                    <option value="JAVA SE" ${paramValues.lenguages.stream().anyMatch(v->v.equals("JAVA SE")).get() ?  "selected" : ""}>Java SE</option>
                    <option value="PY" ${paramValues.lenguages.stream().anyMatch(v->v.equals("PY")).get() ? "selected" : ""}>Python</option>
                    <option value="PANDAS" ${paramValues.lenguages.stream().anyMatch(v->v.equals("PANDAS")).get() ? "selected" : ""}>Pandas</option>
                    <option value="JAKARTA EE" ${paramValues.lenguages.stream().anyMatch(v->v.equals("JAKARTA EE")).get() ? "selected" : ""}>Jakarta EE</option>
                    <option value="SPRING" ${paramValues.lenguages.stream().anyMatch(v->v.equals("SPRING")).get() ? "selected" : ""}>Spring</option>
                </select>
            </div>
            <% if(errors != null && errors.containsKey("lenguages")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("lenguages") + "</small>");
            }%>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Roles</label>
            <div class="form-check col-sm-2">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_ADMIN"
                ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_ADMIN")).get() ? "checked" : ""}>
                <label class="form-check-label">ADMIN</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_USER"
                ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_USER")).get() ? "checked" : ""}>
                <label class="form-check-label">USER</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="checkbox" class="form-check-input" name="roles" value="ROLE_MODERATOR"
                ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_MODERATOR")).get() ? "checked" : ""}>
                <label class="form-check-label">MODERATOR</label>
            </div>
            <% if(errors != null && errors.containsKey("roles")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("roles") + "</small>");
            }%>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Idiomas</label>
            <div class="form-check col-sm-2">
                <input class="form-check-input" type="radio" name="idioma" value="sp" ${param.idioma.equals("sp") ? "checked" : ""}>
                <label class="form-check-label">Spanish</label>
            </div>
            <div class="form-check col-sm-2">
                <input class="form-check-input" type="radio" name="idioma" value="en" ${param.idioma.equals("en") ? "checked" : ""}>
                <label class="form-check-label">English</label>
            </div>
            <div class="form-check col-sm-2">
                <input type="radio" class="form-check-input" name="idioma" value="pr" ${param.idioma.equals("pr") ? "checked" : ""}>
                <label class="form-check-label">Portugues</label>
            </div>
            <% if(errors != null && errors.containsKey("idioma"))
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("idioma") + "</small>"); %>
        </div>
        <div class="form-controller row mb-3">
            <label class="col-form-label col-sm-2">Habilitar</label>
            <div class="form-check col-sm-2">
                <input type="checkbox" class="form-check-input" name="habilitar" checked>
            </div>
        </div>
        <div class="row mb-3">
            <div>
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div>
            <input type="hidden" name="secret" value="1234">
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>