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

    public List<Student> searchStudents(String id, String name, String dob, String department) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPreparedStatement(connection, id, name, dob, department);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String studentId = rs.getString("id");
                String studentName = rs.getString("name");
                Date studentDob = rs.getDate("dob");
                String studentDepartment = rs.getString("department");
                int studentSelected = rs.getInt("selected");
                students.add(new Student(studentId, studentName, studentDob, studentDepartment, studentSelected));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
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

    public void updateSelected(String id) {
        String UPDATE_SELECTED_SQL = "UPDATE student SET selected = 1 WHERE id = ?";
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SELECTED_SQL)) {
            preparedStatement.setString(1, id);
            int rowUpdated = preparedStatement.executeUpdate();

            if (rowUpdated > 0) {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, log error or return error status
        }
        return;
    }
}
