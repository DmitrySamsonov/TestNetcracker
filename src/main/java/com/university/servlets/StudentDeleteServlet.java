package com.university.servlets;

import com.university.objects.StudentFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentDeleteServlet",
urlPatterns = {"/delete"})
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        try {
            StudentFacade studentFacade = (StudentFacade) getServletContext().getAttribute("studentFacade");

            studentFacade.deleteStudent(id);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("students").forward(request, response);
        }

    }

}
