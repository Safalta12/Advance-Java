/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author shres
 */
@WebServlet(urlPatterns = {"/PrintSwastikServlet"})
public class PrintSwastikServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Print Swastik College</title></head>");
            out.println("<body>");
            out.println("<h1>Servlet PrintSwastikServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Printing 'Swastik College' 10 times:</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
       ServletConfig config = null;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        config = sc;
        System.out.println("Init Method Executed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<h2>Printing Swastik College 10 Times:</h2>");
        for (int i = 1; i <= 10; i++) {
            pw.println(i + ". Swastik College<br>");
        }

        System.out.println("Service Method Executed");
    }

    @Override
    public String getServletInfo() {
        return "MyServlet for Printing Swastik College";
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Method Executed");
    }
}