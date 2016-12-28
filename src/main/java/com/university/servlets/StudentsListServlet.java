package com.university.servlets;

import com.university.entities.Student;
import com.university.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentsListServlet",
        urlPatterns = {"/students"})
public class StudentsListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchData = (String) request.getParameter("searchData");
        String searchCriteria = (String) request.getParameter("searchCriteria");

        List<Student> studentsList = null;

        try {
            StudentService studentService = (StudentService) getServletContext().getAttribute("studentService");


            if (searchData != null && searchCriteria != null) {
                studentsList = studentService.getStudents(searchData, searchCriteria);
            } else {
                studentsList = studentService.getStudents();
            }


            request.setAttribute("entityArray", studentsList);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
    }
}



