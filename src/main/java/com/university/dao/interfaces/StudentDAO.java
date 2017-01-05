package com.university.dao.interfaces;

import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.university.entities.Student;

import java.util.List;


public interface StudentDAO {

    List<Student> getStudents() throws NullPointerException, Exception;

    List<Student> getStudents(String sortBy, boolean asc) throws MySQLTimeoutException;

    List<Student> getStudents(String fio) ;

    List<Student> getStudents(int groupNumber);

    Student getStudentById(int id);

    void deleteStudent(int id);

    void addStudent(Student student);

    void editStudent(Student student);


}
