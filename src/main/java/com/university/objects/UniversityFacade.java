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

//    @Autowired
//    public void setStudentDAO(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//        students = studentDAO.getStudents();
//    }

    private List<Student> students;


    public List<Student> getStudents() {
        try{
            students = studentDAO.getStudents();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return students;
    }
    public Student getStudentById(int id) {
        Student student = null;
        try{
            student = studentDAO.getStudentById(id);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally {
            return student;
        }
    }

    public void deleteStudent(int id) {
        try{
            studentDAO.deleteStudent(id);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }


    public void addStudent(Student student) {
        try{
            studentDAO.addStudent(student);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void editStudent(Student student) {
        try{
            studentDAO.editStudent(student);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }


}

