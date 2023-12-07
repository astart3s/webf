package servlet;

import dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dobString = request.getParameter("dob");
        String dep = request.getParameter("dep");

        StudentDAO dao = new StudentDAO();
        dao.createStudent(id, name, dobString, dep);

        response.sendRedirect("index.jsp");
    }
}