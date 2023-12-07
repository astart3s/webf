package servlet;

import dao.StudentDAO;
import model.Student;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieving parameters from the request
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String dep = request.getParameter("dep");

        // Setting the department in the session
        HttpSession session = request.getSession();
        session.setAttribute("searchDep", dep);

        // Set individual attributes instead of a student object
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("dob", dob); // assuming you want to pass the parsed Date object
        request.setAttribute("dep", dep);

        // Forwarding to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("confirm.jsp");
        dispatcher.forward(request, response);
    }
}