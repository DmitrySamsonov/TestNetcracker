package com.university.servlets;

import com.university.entities.Student;
import com.university.objects.UniversityFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentEditServlet",
urlPatterns = {"/edit"})
public class StudentEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        String fio= request.getParameter("fio");
        int groupNumber= Integer.parseInt(request.getParameter("groupNumber"));
        String scolarship= request.getParameter("scolarship");

        Student student = new Student();
        student.setId(id);
        student.setFio(fio);
        student.setGroupNumber(groupNumber);
        student.setScolarship(scolarship);

        try {
            UniversityFacade universityFacade = (UniversityFacade) getServletContext().getAttribute("universityFacade");

            universityFacade.editStudent(student);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        request.getRequestDispatcher("students").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = null;
        try {
            UniversityFacade universityFacade = (UniversityFacade) getServletContext().getAttribute("universityFacade");

            student= universityFacade.getStudentById(id);
            request.setAttribute("student", student);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        request.setAttribute("wherefrom", "studentEdit");
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}
