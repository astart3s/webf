<%@ page import="java.util.List" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Students</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        #studentTable {
            display: none;
        }
    </style>
    <script>
        function toggleStudentTable() {
            var x = document.getElementById("studentTable");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }
        x.style.display = "none";
    </script>
</head>
<body>

<h2>Student List</h2>

<%
    StudentDAO dao = new StudentDAO();
    List<Student> list = dao.listAllStudents();
%>

<button onclick="toggleStudentTable()">View Students</button>
<table id="studentTable">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Department</th>
        <th>Selected</th>
        <th>Delete</th>
    </tr>
    <%
        for (Student student : list) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getDob() %></td>
        <td><%= student.getDepartment() %></td>
        <td>
            <form action="/select" method="post">
                <input type="hidden" name="id" value="<%= student.getId() %>">
                <input type="hidden" name="name" value="<%= student.getName() %>">
                <input type="hidden" name="dob" value="<%= student.getDob() %>">
                <input type="hidden" name="department" value="<%= student.getDepartment() %>">
                <button type="submit">Select</button>
            </form>
        </td>
        <td>
            <form action="/delete" method="post">
                <input type="hidden" name="id" value="<%= student.getId() %>">
                <input type="hidden" name="name" value="<%= student.getName() %>">
                <input type="hidden" name="dob" value="<%= student.getDob() %>">
                <input type="hidden" name="department" value="<%= student.getDepartment() %>">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
