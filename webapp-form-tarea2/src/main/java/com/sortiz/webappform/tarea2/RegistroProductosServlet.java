package com.sortiz.webappform.tarea2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/crear")
public class RegistroProductosServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String nombreProducto = req.getParameter("producto");
        String categoria = req.getParameter("categoria");

        Integer precio = null;
        try {
            precio = Integer.parseInt(req.getParameter("precio"));
        } catch (NumberFormatException ex) {
        }

        String fabricanate = req.getParameter("fabricante");

        Map<String, String> errors = new HashMap<>();

        if (nombreProducto.isBlank() || nombreProducto == null) {
            errors.put("producto", "Debe ingresar nombre del producto!");
        }

        if (categoria.isBlank() || categoria == null) {
            errors.put("categoria", "Debe seleccionar una categoria");
        }

        if (precio == null || precio < 0) {
            errors.put("precio", "El precio es requerido y debe ser un numero mayor a 0");
        }

        if (fabricanate == null || fabricanate.isBlank()) {
            errors.put("fabricante", "El fabricante es requerido");
        } else if (fabricanate.length() < 4 || fabricanate.length() > 10) {
            errors.put("fabricante", "El nombre del fabricante debe contener entre 4 y 10 caracteres");
        }

        if (errors.isEmpty()) {

            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Form Result</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Form Result</h1>");
                out.println("<ul>");
                out.println("<li>Producto: " + nombreProducto + "</li>");
                out.println("<li>Categoria: " + categoria + "</li>");
                out.println("<li>Precio: " + precio + "</li>");
                out.println("<li>Fabricante: " + fabricanate + "</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");

            }
        }  else{
            req.setAttribute("errors", errors);
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
