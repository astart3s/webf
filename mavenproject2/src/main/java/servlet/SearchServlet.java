package servlet;

import dao.StudentDAO;
import model.Student;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String department = request.getParameter("department");

        HttpSession session = request.getSession();
        session.setAttribute("searchId", id);
        session.setAttribute("searchName", name);
        session.setAttribute("searchDob", dob);
        session.setAttribute("searchDepartment", department);

        StudentDAO dao = new StudentDAO();
        
        List<Student> students = null;
        students = dao.searchStudents(id, name, dob, department);

        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
        dispatcher.forward(request, response);
    }
}