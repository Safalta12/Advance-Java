import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataFetch extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<html><body>");
            out.println("<h2>Employee Table Data</h2>");
            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th></tr>");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/univer?useSSL=false",
                        "root", "root")) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from emp");
                    
                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt(1) + "</td>");
                        out.println("<td>" + rs.getString(2) + "</td>");
                        out.println("<td>" + rs.getString(3) + "</td>");
                        out.println("<td>" + rs.getString(4) + "</td>");
                        out.println("</tr>");
                    }
                }

            } catch (ClassNotFoundException | SQLException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }

            out.println("</table>");
            out.println("</body></html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}