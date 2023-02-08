package com.sortiz.webapp.headers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.Enumeration;

@WebServlet({"/headers-request"})
public class HeadersHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String httpMethod = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString(); // string buffer - convert to string
        String contextPath = req.getContextPath(); // nombre del proyecto - contexto
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr(); // ip - v6 - segun navegador el v4 - crome - ipv6
        int port = req.getLocalPort(); // port
        String server = req.getServerName(); // server name
        String schema = req.getScheme();
        String host = req.getHeader("host"); // devuelve la ruta
        String fullUrl = schema + "/" + host + "/" + contextPath + servletPath;
        String ipCliente = req.getRemoteAddr(); //en este caso la misma que el servidor
        //getremote - remote refers to the client - the server that send a request to the servlet
        String clientUser = req.getRemoteUser();
        String clientHost = req.getRemoteHost();


        try (PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>HttpHeaders</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Http Headers: </h1>");
            out.println("<ul>");
            out.println("<li>Method:" + httpMethod + "</li>");
            out.println("<li>RequestUri" + requestUri + "</li>");
            out.println("<li>RequestUrl" + requestUrl + "</li>");
            out.println("<li>context:" + contextPath + "</li>");
            out.println("<li>servletPath:" + servletPath + "</li>");
            out.println("<li>IP:" + ip + "</li>");
            out.println("<li>Server:" + server + "</li>");
            out.println("<li>port:" + port + "</li>");
            out.println("<li>Schema:" + schema + "</li>");
            out.println("<li>host:" + host + "</li>");
            out.println("<li><a href="+ fullUrl +">" + fullUrl + "</a></li>");
            out.println("<li>IPCliente: " + ipCliente +  "</li>");
            out.println("<li>ClientHost: " + clientHost +  "</li>");
            out.println("<li>ClientUser: " + clientUser +  "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();

            while(headerNames.hasMoreElements()){
                String header = headerNames.nextElement();
                out.println("<li>" + header + ":" + req.getHeader(header) + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}
