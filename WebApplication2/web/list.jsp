<%-- 
    Document   : list
    Created on : Aug 26, 2022, 11:43:59 PM
    Author     : dttnb
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px solid black">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>gender</td>
                <td>dob</td>
            </tr>
            <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.sid}</td>
                    <td>${o.name}</td>
                    <td>${o.gender == true ? "1" : "0"}</td>
                    <td>${o.dob}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
