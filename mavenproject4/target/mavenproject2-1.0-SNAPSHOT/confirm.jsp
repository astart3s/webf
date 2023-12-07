<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Details</title>
</head>
<body>
    <div class="container">
        <h2>Confirm Student Details</h2>
        <p><strong>ID:</strong> <%= request.getAttribute("id") %></p>
        <p><strong>Name:</strong> <%= request.getAttribute("name") %></p>
        <p><strong>Date of Birth:</strong> <%= request.getAttribute("dob") %></p>
        <p><strong>Department:</strong> <%= request.getAttribute("dep") %></p>
        
        <!-- Confirm Button -->
        <form action="create" method="post">
            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
            <input type="hidden" name="name" value="<%= request.getAttribute("name") %>">
            <input type="hidden" name="dob" value="<%= request.getAttribute("dob") %>">
            <input type="hidden" name="dep" value="<%= request.getAttribute("dep") %>">
            <button type="submit" class="confirm-btn">Confirm</button>
        </form>

        <!-- Back Button -->
        <button onclick="history.back()" class="back-btn">Back</button>
    </div>
</body>
</html>
