package com.university.controller;

import com.university.entities.Student;
import com.university.service.impl.StudentServiceImpl;

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

        String sortBy = (String) request.getParameter("sortBy");

        String searchData = (String) request.getParameter("searchData");
        String searchCriteria = (String) request.getParameter("searchCriteria");

        List<Student> studentsList = null;


        try {
            StudentServiceImpl studentServiceImpl = (StudentServiceImpl) getServletContext().getAttribute("studentServiceImpl");


            if (searchData != null && searchCriteria != null) {
                studentsList = studentServiceImpl.getStudents(searchData, searchCriteria);
            } else {

                if (sortBy != null)
                    studentsList = studentServiceImpl.getStudents(sortBy, true);
                else
                    studentsList = studentServiceImpl.getStudents();
            }


            request.setAttribute("entityArray", studentsList);

        }
        catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("students.jsp").forward(request, response);

    }
}



