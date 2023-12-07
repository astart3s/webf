package servlet;

import dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        StudentDAO dao = new StudentDAO();
        dao.updateSelected(id);

        response.sendRedirect("index.jsp");
    }
}