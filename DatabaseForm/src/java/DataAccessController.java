/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DataAccessController extends HttpServlet {    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                       
        try(Connection con = DBUtil.getConnection()) 
             {
                String sql = "INSERT INTO emp(ID,Name,Email,Address) VALUES (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ps.setString(2, request.getParameter("name"));
                ps.setString(3, request.getParameter("email"));
                ps.setString(4, request.getParameter("address"));
                
                ps.executeUpdate();
                 response.getWriter().println("<html><body><h3>Successfully Inserted</h3></body></html>");
            }        
        
        catch (SQLException ex) {
            response.getWriter().println("<h3>Error: " + ex.getMessage() + "</h3>");
        }
    }
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



