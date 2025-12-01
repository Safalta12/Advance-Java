<%@ page import="javax.servlet.http.Cookie" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Create cookies
    Cookie userCookie = new Cookie("username", username);
    Cookie passCookie = new Cookie("password", password);

    // Set cookie age (optional)
    userCookie.setMaxAge(60 * 60 * 24); // 1 day
    passCookie.setMaxAge(60 * 60 * 24);

    // Add cookies to response
    response.addCookie(userCookie);
    response.addCookie(passCookie);
%>

<html>
<body>
<h3>Cookies Saved Successfully!</h3>
<a href="readcookie.jsp">Click here to read saved cookies</a>
</body>
</html>
