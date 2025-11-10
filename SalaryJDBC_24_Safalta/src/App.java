import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root"; 
        String password = ""; 
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!");
            stmt = conn.createStatement();
            String updateQuery = "UPDATE student SET salary = salary + (salary * 0.15) WHERE salary < 20000";
            int rows = stmt.executeUpdate(updateQuery);
            System.out.println("\n " + rows + " record(s) updated successfully!\n");
            String selectQuery = "SELECT * FROM student ORDER BY salary ASC";
            rs = stmt.executeQuery(selectQuery);
            System.out.println("--- Student Records After Update ---");
            System.out.printf("%-5s %-15s %-10s %-10s%n", "ID", "Name", "Salary", "Gender");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String gender = rs.getString("gender");
                System.out.printf("%-5d %-15s %-10.2f %-10s%n", id, name, salary, gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
