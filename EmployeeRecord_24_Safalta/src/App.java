import java.sql.*;
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";       
        String password = "";      
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!\n");
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_READ_ONLY          
            );
            String query = "SELECT * FROM emp";
            rs = stmt.executeQuery(query);
            System.out.println("--- Navigate ResultSet ---");
            if (rs.first()) {
                System.out.println("\nFirst Employee:");
                printEmployee(rs);
            }
            if (rs.last()) {
                System.out.println("\nLast Employee:");
                printEmployee(rs);
            }
            if (rs.previous()) {
                System.out.println("\nPrevious Employee (from last):");
                printEmployee(rs);
            }
            if (rs.next()) {
                System.out.println("\nNext Employee:");
                printEmployee(rs);
            }
            if (rs.absolute(3)) {
                System.out.println("\nEmployee at Row 3:");
                printEmployee(rs);
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
    public static void printEmployee(ResultSet rs) throws SQLException {
        int id = rs.getInt("emp_id");
        String name = rs.getString("emp_name");
        double salary = rs.getDouble("emp_salary");
        String dept = rs.getString("emp_department");

        System.out.printf("ID: %d, Name: %s, Salary: %.2f, Department: %s%n", id, name, salary, dept);
    }
}
