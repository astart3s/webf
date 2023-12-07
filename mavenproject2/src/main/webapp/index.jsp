<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Search</title>
</head>
<body>
    <%
        //HttpSession session = request.getSession();
        String prevId = (String) session.getAttribute("searchId");
        String prevName = (String) session.getAttribute("searchName");
        String prevDob = (String) session.getAttribute("searchDob");
        String prevDepartment = (String) session.getAttribute("searchDepartment");
    %>
    <form action="search" method="post">
        ID: <input type="text" name="id" value="<%= prevId != null ? prevId : "" %>" /><br/>
        Name: <input type="text" name="name" value="<%= prevName != null ? prevName : "" %>" /><br/>
        Date of Birth: <input type="date" name="dob" value="<%= prevDob != null ? prevDob : "" %>" /><br/>
        Department: <input type="text" name="department" value="<%= prevDepartment != null ? prevDepartment : "" %>" /><br/>
        <input type="submit" value="Search"/>
    </form>
</body>
</html>