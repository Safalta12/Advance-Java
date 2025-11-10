import java.sql.*;
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/coll";
        String user = "root";       
        String password = "";     
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!");
            String createTableQuery = "CREATE TABLE IF NOT EXISTS tblstudent (" +
                                      "id INT PRIMARY KEY," +
                                      "name VARCHAR(50)," +
                                      "email VARCHAR(50))";
            stmt = conn.createStatement();
            stmt.execute(createTableQuery);
            System.out.println(" Table tblstudent created successfully!");
            String insertQuery = "INSERT INTO tblstudent (id, name, email) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Aasa Shrestha");
            pstmt.setString(3, "aasa@example.com");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Record inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
