<%-- 
    Document   : SIForm.jsp
    Created on : Dec 19, 2025, 1:53:25 PM
    Author     : shres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Interest Form</title>
</head>
<body>
    <h2>Simple Interest Calculator</h2>

    <form action="SIResult.jsp" method="post">
        Principal:
        <input type="text" name="principal" required><br><br>

        Time (in years):
        <input type="text" name="time" required><br><br>

        Rate of Interest:
        <input type="text" name="rate" required><br><br>

        <input type="submit" value="Calculate">
    </form>
    </body>
</html>
