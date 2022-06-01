package com.doczilla.dao;

import com.doczilla.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoStudent {
    private static String url = "jdbc:postgresql://localhost:5432/doczilla";
    private static String username = "tsemen";
    private static String password = "123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
    }

    private static void closeConnection(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    public List<Student> findAllStudents() {
        String sqlAllStudents = "SELECT * FROM students ORDER BY id ASC";
        List<Student> result = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlAllStudents);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPatronymic(resultSet.getString("patronymic"));
                student.setDateOfBorn(resultSet.getObject("dateOfBorn", LocalDate.class));
                student.setNameOfGroup(resultSet.getString("nameOfGroup"));

                result.add(student);

            }
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    public int save(Student student){
        String sqlSave = "INSERT INTO students (name, surname, patronymic, dateOfBorn, nameOfGroup) VALUES (?,?,?,?,?)";

        Connection connection = null;
        int status=0;
        try{
            connection = DaoStudent.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSave);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getPatronymic());
            statement.setObject(4, student.getDateOfBorn());
            statement.setString(5, student.getNameOfGroup());

            status = statement.executeUpdate();

            statement.close();

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return status;
    }

    public int delete(Student student){
        String sqlDelete = "DELETE FROM students WHERE id=?";

        Connection connection = null;
        int status=0;
        try{
            connection = DaoStudent.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlDelete);
            statement.setInt(1, student.getId());
            status = statement.executeUpdate();

            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return status;
    }

    public Student getStudent(int id) throws SQLException {
        String sqlGetStudent = "SELECT * FROM students WHERE id = ?";
        Student student = null;

        Connection connection = null;

        try {
            connection = DaoStudent.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlGetStudent);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idToUpdate = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                LocalDate dateOfBorn = resultSet.getObject("dateOfBorn", LocalDate.class);
                String nameOfGroup = resultSet.getString("nameOfGroup");

                student = new Student(idToUpdate, name, surname, patronymic, dateOfBorn, nameOfGroup);
            }

            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return student;
    }

    public int updateStudent(Student student) throws SQLException {
        String sqlUpdate = "UPDATE students SET name = ?, surname = ?, patronymic = ?, dateOfBorn = ?, nameOfGroup = ? WHERE id = ?";

        Connection connection = null;
        int status=0;
        try {
            connection = DaoStudent.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getPatronymic());
            statement.setObject(4, student.getDateOfBorn());
            statement.setString(5, student.getNameOfGroup());
            statement.setInt(6, student.getId());

            status = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return status;
    }
}
