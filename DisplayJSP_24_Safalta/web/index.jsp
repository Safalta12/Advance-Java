<%-- 
    Document   : Display
    Created on : Dec 27, 2025, 5:43:43?PM
    Author     : shres
--%>

<%@ page import="java.sql.*" %>
<html>
<head></head>
<body>
<h2>User Details</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr> <%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC",
            "root","root"        );
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM user_details");
        while (rs.next()) { %>
    <tr> <td><%= rs.getInt("id") %></td>
        	<td><%= rs.getString("name") %></td>
        	<td><%= rs.getString("email") %></td>
        	<td><%= rs.getString("address") %></td> </tr>
<%  } 
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } %>
</table>
</body>
</html>
