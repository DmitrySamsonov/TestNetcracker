package com.university.objects;

import com.university.dao.impl.StudentDAOImpl;
import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("universityFacade")
@Scope("singleton")
public class UniversityFacade {


    private StudentDAO studentDAO;

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
        students = studentDAO.getStudents();
    }

    private List<Student> students;


    public List<Student> getStudents() {

//        studentDAO = new StudentDAOImpl();


        try{
            students = studentDAO.getStudents();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return students;
    }
}

