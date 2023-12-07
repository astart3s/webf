<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Department</th>
            <th>Status</th>
        </tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getDob() %></td>
            <td><%= student.getDepartment() %></td>
            <td>
                <% if (student.getSelected() == 0) { %>
                    <form action="select" method="post">
                        <input type="hidden" name="id" value="<%= student.getId() %>"/>
                        <input type="submit" value="Select"/>
                    </form>
                <% } else { %>
                    Selected
                <% } %>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
