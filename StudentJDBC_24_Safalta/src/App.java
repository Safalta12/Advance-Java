import java.sql.*;
public class App{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college"; 
        String user = "root"; 
        String password = ""; 
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!");
            String insertQuery = "INSERT INTO student (id, name, gender, address) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            Object[][] students = {
                {1, "Safalta", "Female", "Bhaktapur"},
                {2, "Bikash", "Male", "Pokhara"},
                {3, "Sita", "Female", "Lalitpur"},
                {4, "Ram", "Male", "Kathmandu"},
                {5, "Aasa", "Female", "Dharan"}
            };
            for (Object[] s : students) {
                pstmt.setInt(1, (int) s[0]);
                pstmt.setString(2, (String) s[1]);
                pstmt.setString(3, (String) s[2]);
                pstmt.setString(4, (String) s[3]);
                pstmt.executeUpdate();
            }
            System.out.println(" 5 records inserted successfully!");
            String selectQuery = "SELECT * FROM student ORDER BY name ASC";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(selectQuery);
            System.out.println("\n--- Student Records (Name Ascending) ---");
            System.out.printf("%-5s %-15s %-10s %-15s%n", "ID", "Name", "Gender", "Address");
            System.out.println("---------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String address = rs.getString("address");

                System.out.printf("%-5d %-15s %-10s %-15s%n", id, name, gender, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
