package com.sortiz.webapp.headers.controller;

import com.sortiz.webapp.headers.model.Product;
import com.sortiz.webapp.headers.service.ProductService;
import com.sortiz.webapp.headers.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTMLWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//para exportar a excel - servlet soporta varias rutas
@WebServlet({"/products.xls", "/products.html"})
public class ProductXlsServlet extends HttpServlet {
    //get a list of products
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceImpl service = new ProductServiceImpl();
        List<Product> products = service.getList();

        resp.setContentType("text/html;charset=UTF-8");

        String servletPath = req.getServletPath();
        boolean isXls = servletPath.endsWith(".xls");

        if(isXls){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=products.xls");
        }
        else {

            try(PrintWriter out = resp.getWriter() ){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Products</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>List of Products</h1>");

                out.println("<p><a href=\"" + req.getContextPath() + "/products.xls" + "\">Export to excel</a></p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>PRODUCT</th>");
                out.println("<th>TYPE</th>");
                out.println("<th>PRICE</th>");
                out.println("</tr>");

                products.forEach(p->{
                    out.println("<tr>");
                    out.println("<td>" + p.getId() + "</td>");
                    out.println("<td>" + p.getName() + "</td>");
                    out.println("<td>" + p.getTipoProducto()+ "</td>");
                    out.println("<td>" + p.getPrice() + "</td>");
                    out.println("</tr>");
                });

                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }

        }

    }

}
