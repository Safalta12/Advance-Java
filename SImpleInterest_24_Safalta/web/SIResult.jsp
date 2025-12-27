<%-- 
    Document   : SIResult
    Created on : Dec 19, 2025, 1:53:53 PM
    Author     : shres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Simple Interest Result</title>
</head>
<body>
    <h2>Simple Interest Result</h2>

    <%
        double principal = Double.parseDouble(request.getParameter("principal"));
        double time = Double.parseDouble(request.getParameter("time"));
        double rate = Double.parseDouble(request.getParameter("rate"));

        double simpleInterest = (principal * time * rate) / 100;
    %>

    <p>Principal: <%= principal %></p>
    <p>Time: <%= time %> years</p>
    <p>Rate: <%= rate %> %</p>
    <p><b>Simple Interest: <%= simpleInterest %></b></p>
</body>
</html>
