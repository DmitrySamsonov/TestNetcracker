package com.university.service.interfaces;


import com.university.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    List<Student> getStudents(String searchData, String searchCriteria);

    Student getStudentById(int id);

    void deleteStudent(int id);

    void addStudent(Student student);

    void editStudent(Student student);

}
