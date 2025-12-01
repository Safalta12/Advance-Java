<%@ page import="javax.servlet.http.Cookie" %>
<%
    String username = "";
    String password = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                username = c.getValue();
            }
            if (c.getName().equals("password")) {
                password = c.getValue();
            }
        }
    }
%>

<html>
<body>
<h2>Values Retrieved from Cookies</h2>
<p><b>Username:</b> <%= username %></p>
<p><b>Password:</b> <%= password %></p>

</body>
</html>
