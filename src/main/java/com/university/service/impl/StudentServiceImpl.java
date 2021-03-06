package com.university.service.impl;

import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl{

    @Autowired
    private StudentDAO studentDAO;

    public List<Student> getStudents() throws NullPointerException, Exception{
        List<Student> students = new ArrayList<Student>();
        try {
            students = studentDAO.getStudents();
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage()+" throw service");
//            throw e;
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return students;
    }


    public List<Student> getStudents(String sortBy, boolean asc) throws MySQLTimeoutException{
        List<Student> students = new ArrayList<Student>();
        try {
            students = studentDAO.getStudents(sortBy, asc);
        }catch (MySQLTimeoutException ex){
            throw ex;
        }
        catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return students;
        }
    }

    public List<Student> getStudents(String searchData, String searchCriteria) {
        List<Student> students = new ArrayList<Student>();
        try {
            if (searchCriteria.equals("fio")) {
                students = studentDAO.getStudents(searchData);
            }
            if (searchCriteria.equals("groupNumber")) {
                students = studentDAO.getStudents(Integer.parseInt(searchData));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return students;
        }
    }

    public Student getStudentById(int id) {
        Student student = null;
        try {
            student = studentDAO.getStudentById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return student;
        }
    }

    public void deleteStudent(int id) {
        try {
            studentDAO.deleteStudent(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void addStudent(Student student) {
        try {
            studentDAO.addStudent(student);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void editStudent(Student student) {
        try {
            studentDAO.editStudent(student);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}

