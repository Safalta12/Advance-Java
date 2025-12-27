import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>User Records</title></head><body>");
        out.println("<h2>User Details</h2>");
        out.println("<table border='1'>");
   out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th></tr>");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC","root","root" );
Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_details");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("</tr>");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            out.println("<tr><td colspan='4'>Error: " + e.getMessage() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");}}