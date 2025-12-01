
import java.sql.*;


public class DBUtil {
    public static Connection getConnection() throws SQLException{
       Connection con=null;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/univer","root","root");
        }catch(ClassNotFoundException e){
            
        }
        return con;
    }
}
