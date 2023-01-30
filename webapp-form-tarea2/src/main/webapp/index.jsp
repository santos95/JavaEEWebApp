<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <title>Registro Productos</title>
</head>
<body>
<h1 class="px-3">Registro Productos</h1>
<div class="px-5">
    <form class="align-items-center" action="/webapp-form-tarea2/crear" method="post">
        <div class="form-group row mb-3">
            <label for="producto" class="col-form-label">Producto</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="producto" id="producto" value="${param.producto}">
            </div>
            <% if(errors != null && errors.containsKey("producto")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("producto") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="categoria" class="col-form-label col-sm-1">Categoria</label>
            <div class="col-sm-5">
                <select class="form-control" name="categoria" id="categoria" class="form-select">
                    <option value="">--select--</option>
                    <option value="ordenador" ${param.categoria.equals("ordenador")?  "selected" : ""}>Ordenador</option>
                    <option value="laptop" ${param.categoria.equals("laptop") ? "selected" : ""}>Laptop</option>
                    <option value="consola" ${param.categoria.equals("consola") ? "selected" : ""}>Consola</option>
                </select>
            </div>
            <% if(errors != null && errors.containsKey("categoria")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("categoria") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="precio" class="col-form-label">Precio</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="precio" id="precio" value="${param.precio}">
            </div>
            <% if(errors != null && errors.containsKey("precio")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("precio") + "</small>");
            }%>
        </div>
        <div class="form-group row mb-3">
            <label for="fabricante" class="col-form-label">Fabricante</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="fabricante" id="fabricante" value="${param.fabricante}">
            </div>
            <% if(errors != null && errors.containsKey("fabricante")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color: red'>" + errors.get("fabricante") + "</small>");
            }%>
        </div>

        <div class="row mb-3">
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
