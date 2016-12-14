package com.university.objects;

import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityFacade {


    private StudentDAO studentDAO;

    @Autowired
    public void setBookDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
        students = studentDAO.getStudents();
    }

    private List<Student> students;


    public List<Student> getStudents() {
        return students;
    }
}
