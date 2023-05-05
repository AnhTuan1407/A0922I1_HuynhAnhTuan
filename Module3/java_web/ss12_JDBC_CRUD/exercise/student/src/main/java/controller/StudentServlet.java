package controller;

import model.Student;
import service.IStudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {"/students", ""})
public class StudentServlet extends HttpServlet {

    IStudentService iStudentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
            switch (action){
                case "create": {
                    showCreate(request, response);
                    break;
                }

                case "update": {
                    showUpdate(request, response);
                    break;
                }

                case "delete": {
                    showDelete(request, response);
                    break;
                }

                default: {
                    showList(request, response);
                    break;
                }
            }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = iStudentService.findById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/student/delete.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = iStudentService.findAll();
        request.setAttribute("student", studentList);
        request.getRequestDispatcher("/student/list.jsp").forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = iStudentService.findById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/student/update.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/student/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action){
            case "create": {
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            case "update": {
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            case "delete": {
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            default: {
                showList(request, response);
                break;
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iStudentService.delete(id);
        response.sendRedirect("/students");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Student student = new Student(id, name, email, country);
        iStudentService.update(student);
        response.sendRedirect("/students");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Student student = new Student(name, email, country);
        iStudentService.save(student);
//        request.getRequestDispatcher("/student/create.jsp").forward(request, response);
        response.sendRedirect("/students");
    }
}
