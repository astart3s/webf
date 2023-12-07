package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/thi";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456aA@";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

        public List<Student> listAllStudents() {
        List<Student> students = new ArrayList<>();
        String SELECT_ALL_STUDENTS = "SELECT * FROM student";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String department = rs.getString("department");
                int selected = rs.getInt("selected");

                students.add(new Student(id, name, dob, department, selected));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, log error or return error status
        }
        return students;
    }
    
    public void deleteStudentById(String id) {
    String DELETE_STUDENT_SQL = "DELETE FROM student WHERE id = ?";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
        preparedStatement.setString(1, id);

        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Student with ID " + id + " was deleted successfully!");
        } else {
            System.out.println("No student found with ID " + id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Optionally, log error or return error status
    }
}
    
        
    public void createStudent(String id, String name, String dob, String department) {
        String INSERT_STUDENT_SQL = "INSERT INTO student (id, name, dob, department, selected) VALUES (?, ?, ?, ?, 0)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, department);

            int rowInserted = preparedStatement.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, log error or return error status
        }
    }

    private PreparedStatement createPreparedStatement(Connection connection, String id, String name, String dob, String department) throws SQLException {
        String query = "SELECT * FROM student WHERE id LIKE ? AND name LIKE ? AND dob LIKE ? AND department LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "%" + id + "%");
        preparedStatement.setString(2, "%" + name + "%");
        preparedStatement.setString(3, "%" + dob + "%");
        preparedStatement.setString(4, "%" + department + "%");
        return preparedStatement;
    }
}
