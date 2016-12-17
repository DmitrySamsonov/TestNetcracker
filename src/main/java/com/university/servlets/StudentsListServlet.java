package com.university.servlets;

import com.university.dao.impl.StudentDAOImpl;
import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;
import com.university.objects.UniversityFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentsListServlet",
urlPatterns = {"/StudentsListServlet"})
public class StudentsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HI HI HI HI HI HI HI HI");

        try {
            UniversityFacade universityFacade = (UniversityFacade) getServletContext().getAttribute("universityFacade");

            List<Student> studentsList = universityFacade.getStudents();


            System.out.println("studentsList = " + studentsList);
            request.setAttribute("entityArray", studentsList);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            out.close();
        }

        request.getRequestDispatcher("students.jsp").forward(request, response);

    }
}
