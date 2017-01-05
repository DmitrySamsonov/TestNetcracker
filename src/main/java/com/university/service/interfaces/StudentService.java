package com.university.service.interfaces;


import com.university.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getStudents() throws NullPointerException, Exception;

    List<Student> getStudents(String searchData, String searchCriteria);

    Student getStudentById(int id);

    void deleteStudent(int id);

    void addStudent(Student student);

    void editStudent(Student student);

}
