package org.sortiz.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet(value = "/index")
public class TareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        Date fecha = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("dd 'de' MMMM, yyyy", new Locale("es"));
//        LocalDateTime fecha = LocalDateTime.now();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM, yyyy", new Locale("es", "ES"));
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM, yyyy", new Locale("es","ES"));


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Tarea 1!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Tarea 1: Servlet y envio de parametros</h1>");

        if(nombre != null && apellido != null){
            out.println("<h2>Hola, mi nombre es: " + nombre + " " + apellido  + "</h2>");
            out.println("<h3>La fecha actual es: " + fm.format(fecha) + "</h3>");

        } else {
            out.println("No se han enviado los parametros nombre y apellido");
        }

        out.println("<h1></h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
