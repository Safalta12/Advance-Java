import java.sql.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";     
        String password = "";      
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!\n");
            System.out.print("Enter Employee ID to update: ");
            int empId = sc.nextInt();
            sc.nextLine(); 
            String query = "SELECT * FROM emp WHERE emp_id = ?";
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, empId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Current Employee Details:");
                printEmployee(rs);
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                rs.updateString("emp_name", newName);
                rs.updateRow();  
                System.out.println("\n Employee record updated successfully!");
                System.out.println("Updated Employee Details:");
                printEmployee(rs);
            } else {
                System.out.println(" Employee with ID " + empId + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                sc.close();
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
