/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 *
 * @author shres
 */
public class MyServlet implements Servlet {
    ServletConfig config=null;
    @Override
    public void init(ServletConfig sc) throws ServletException {
        config=sc;
        System.out.println("Init Method Executed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
res.setContentType("text/html");
PrintWriter pw= res.getWriter();
pw.println("<h2>hello from life cycle servlet</h2>");
System.out.println("in service");
}
    
    @Override
    public String getServletInfo() {
       return"getServletInfo";
    }
    
    @Override
    public void destroy() {
           System.out.println("Destroyed Executed");
    
    }
}

