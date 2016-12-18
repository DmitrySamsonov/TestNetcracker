package com.university.dao.interfaces;

import com.university.entities.Student;

import java.util.List;


public interface StudentDAO {

    List<Student> getStudents();
    List<Student> getStudents(String fio);
    List<Student> getStudents(int groupNumber);
    Student getStudentById(int id);
    void deleteStudent(int id);
    void addStudent(Student student);
    void editStudent(Student student);


}
