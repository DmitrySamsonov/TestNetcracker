package com.university.servlets;

import com.university.entities.Student;
import com.university.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentAddServlet",
        urlPatterns = {"/add"})
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String groupNumberParameter = request.getParameter("groupNumber");
            String scolarshipParameter = request.getParameter("scolarship");
            String fio = request.getParameter("fio");
            int groupNumber = 0;
            Double scolarship = 0.0;

            if(groupNumberParameter!=null && groupNumberParameter!=""){
                groupNumber = Integer.parseInt(groupNumberParameter);
            }
            if(scolarshipParameter!=null && scolarshipParameter!=""){
                scolarship = Double.parseDouble(scolarshipParameter);
            }


            Student student = new Student();
            student.setFio(fio);
            student.setGroupNumber(groupNumber);
            student.setScolarship(scolarship);

            StudentService studentService = (StudentService) getServletContext().getAttribute("studentService");

            studentService.addStudent(student);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

