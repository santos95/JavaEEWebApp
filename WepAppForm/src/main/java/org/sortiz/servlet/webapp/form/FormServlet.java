package org.sortiz.servlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String user = req.getParameter("username");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String[] lenguages = req.getParameterValues("lenguages");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        boolean habilitar = req.getParameter("habilitar") != null && req.getParameter("habilitar").equals("on");
        String secreto = req.getParameter("secret");

        //ArrayList<String> errors = new ArrayList<>();
        Map<String, String> errors = new HashMap<>();
        //isblank - valida que si es vacio o espacio en blanco - mas completo que isempty
        if (user == null || user.isBlank()) {
            errors.put("username", "user can not be empty");
        }

        if (pass == null || pass.isBlank()) {
            errors.put("pass", "pass can not be empty");
        }

        if (email == null || !email.contains("@")) {
            errors.put("email", "Mail is required and must have the email format");
        }

        //isBlank is similar to "" or " "
        if (country == null || country.equals("") || country.equals(" ")) {
            errors.put("country", "The country is required");
        }

        if (lenguages == null || lenguages.length == 0) {
            errors.put("lenguages", "You must select at least one lenguage");
        }

        if (roles == null || roles.length == 0) {
            errors.put("roles", "You must select at least one role");
        }

        if (idioma == null) {
            errors.put("idioma", "Must select one lenguage");
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
                out.println("<li>Username: " + user + "</li>");
                out.println("<li>Password: " + pass + "</li>");
                out.println("<li>Email: " + email + "</li>");
                out.println("<li>Country: " + country + "</li>");
                out.println("<li>Lenguajes: <ul>");

                Arrays.asList(lenguages).forEach(lenguage -> {
                    out.println("<li>" + lenguage + "</li>");
                });

                out.println("</ul></li>");

                out.println("<li>Roles: <ul>");

                Arrays.asList(roles).forEach(rol -> {
                    out.println("<li>" + rol + "</li>");
                });

                out.println("</ul></li>");
                out.println("<li>Idioma: " + idioma + "</li>");
                out.println("<li>Habilitar: " + habilitar + "</li>");
                out.println("<li>Secreto: " + secreto + "</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");

            }

        } else {

            //se define el atributo errors para pasar los errores al jsp
            //jsp java server page - paginas que soportan codigo java
            //obtiene el contexto y se pasa el req y el resp to the jsp
            req.setAttribute("errors", errors);
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
//                errors.forEach(error -> {
//
//                    out.println("<ul>");
//                    out.println("<li>" + error + "</li>");
//                    out.println("</ul>");
//
//                });
//
//                out.println("<p><a href=\"/WepAppForm/\">Go Back</a></p>");

        }
    }
}
