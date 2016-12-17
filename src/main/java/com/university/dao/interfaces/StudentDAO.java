package com.university.dao.interfaces;

import com.university.entities.Student;

import java.util.List;


public interface StudentDAO {

    List<Student> getStudents();
    int addStudent(Student student);

}
