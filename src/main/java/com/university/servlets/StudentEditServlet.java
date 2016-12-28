package com.university.servlets;

import com.university.entities.Student;
import com.university.service.StudentService;

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

        try {
            int id = Integer.parseInt(request.getParameter("id"));

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

//            TODO если не забыл, тут мои косяки при попытке сделать scolarship необязательным полем
//            TODO не может обработать толи null String то ли "" строку!





            Student student = new Student();
            student.setId(id);
            student.setFio(fio);
            student.setGroupNumber(groupNumber);
            student.setScolarship(scolarship);

            StudentService studentService = (StudentService) getServletContext().getAttribute("studentService");

            studentService.editStudent(student);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("students").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = null;
        try {
            StudentService studentService = (StudentService) getServletContext().getAttribute("studentService");

            student = studentService.getStudentById(id);
            request.setAttribute("student", student);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        request.setAttribute("wherefrom", "studentEdit");
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}
