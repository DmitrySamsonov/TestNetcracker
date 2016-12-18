package com.university.servlets;

import com.university.entities.Student;
import com.university.objects.UniversityFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentAddServlet",
urlPatterns = {"/add"})
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fio= request.getParameter("fio");
        int groupNumber= Integer.parseInt(request.getParameter("groupNumber"));
        String scolarship= request.getParameter("scolarship");

        Student student = new Student();
        student.setFio(fio);
        student.setGroupNumber(groupNumber);
        student.setScolarship(scolarship);

        try {
            UniversityFacade universityFacade = (UniversityFacade) getServletContext().getAttribute("universityFacade");

            universityFacade.addStudent(student);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("students").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("wherefrom", "studentAdd");
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

}

