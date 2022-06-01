package com.doczilla.servlet;

import com.doczilla.dao.DaoStudent;
import com.doczilla.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class MainPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static String indexPath = "/WEB-INF/view/index.jsp";
    private final static String editFormPath = "/WEB-INF/view/EditForm.jsp";
    private DaoStudent daoStudent;


    public void init() {
        daoStudent = new DaoStudent();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                default:
                    findAllStudents(request, response);
                    request.getRequestDispatcher(indexPath).include(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void findAllStudents(HttpServletRequest request, HttpServletResponse response)
                        throws SQLException {
        try {
            List<Student> studentList = daoStudent.findAllStudents();
            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher(indexPath);
            dispatcher.forward(request, response);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student(id);
        daoStudent.delete(student);
//        if (status > 0)
        response.sendRedirect("studentList");
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String patronymic = request.getParameter("patronymic");

        final String StringDateOfBorn = request.getParameter("dateOfBorn");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate dateOfBorn = LocalDate.parse(StringDateOfBorn, formatter);

        final String nameOfGroup = request.getParameter("nameOfGroup");


        Student newStudent = new Student(name, surname, patronymic, dateOfBorn, nameOfGroup);
        daoStudent.save(newStudent);
        response.sendRedirect("/");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = daoStudent.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(editFormPath);
        request.setAttribute("student", existingStudent);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String patronymic = request.getParameter("patronymic");

        final String StringDateOfBorn = request.getParameter("dateOfBorn");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate dateOfBorn = LocalDate.parse(StringDateOfBorn, formatter);

        final String nameOfGroup = request.getParameter("nameOfGroup");


        Student student = new Student(id, name, surname, patronymic, dateOfBorn, nameOfGroup);
        daoStudent.updateStudent(student);
        response.sendRedirect("/");
    }
}











