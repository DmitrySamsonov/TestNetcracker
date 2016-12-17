package com.university.dao.interfaces;

import com.university.entities.Student;

import java.util.List;


public interface StudentDAO {

    List<Student> getStudents();
    void addStudent(Student student);
    void editStudent(Student student);
    void

}
