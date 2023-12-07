<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Search</title>
</head>
<body>
    <%
        //HttpSession session = request.getSession(); // Un-comment this line to enable session
        String prevDepartment = request.getParameter("dep");

        if (prevDepartment != null && !prevDepartment.isEmpty()) {
            session.setAttribute("searchDep", prevDepartment);
        } else {
            prevDepartment = (String) session.getAttribute("searchDep");
        }
    %>
    <form action="add" method="post">
        ID: <input type="text" name="id" value="" /><br/>
        Name: <input type="text" name="name" value="" /><br/>
        DoB: <input type="date" name="dob" value="" /><br/>
        Department:
        <select name="dep">
            <option value="red" <%= "red".equals(prevDepartment) ? "selected" : "" %>>Red</option>
            <option value="blue" <%= "blue".equals(prevDepartment) ? "selected" : "" %>>Blue</option>
            <option value="black" <%= "black".equals(prevDepartment) ? "selected" : "" %>>Black</option>
        </select><br/>
        <input type="submit" value="Add"/>  
    </form>
</body>
</html>
