package com.university.servlets;

import com.university.entities.Student;
import com.university.objects.StudentFacade;

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
        String searchData = (String)request.getParameter("searchData");
        String searchCriteria = (String)request.getParameter("searchCriteria");

        try {
            StudentFacade studentFacade = (StudentFacade) getServletContext().getAttribute("studentFacade");

            List<Student>  studentsList = studentFacade.getStudents(searchData, searchCriteria);


            System.out.println("studentsList = " + studentsList);
            request.setAttribute("entityArray", studentsList);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            StudentFacade studentFacade = (StudentFacade) getServletContext().getAttribute("studentFacade");

            List<Student> studentsList = studentFacade.getStudents();


            System.out.println("studentsList = " + studentsList);
            request.setAttribute("entityArray", studentsList);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
    }


}
