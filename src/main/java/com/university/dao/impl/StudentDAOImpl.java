package com.university.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;


@Component
public class StudentDAOImpl implements StudentDAO {


    @Autowired
    private SessionFactory sessionFactory;

    private List<Student> students;


    @Transactional
    @Override
    public List<Student> getStudents() {

        System.out.println("sessionFactory = " + sessionFactory);
        try{
            students = (List<Student>) sessionFactory.getCurrentSession()
                    .createCriteria(Student.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();



        }
        catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("sessionFactory = " + sessionFactory);

        return students;
    }



    @Transactional
    @Override
    public int addStudent(Student student) {

        System.out.println("sessionFactory = " + sessionFactory);
        int success = 0;
        try{
            sessionFactory.getCurrentSession().save(student);
            success = 1;
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return success;
    }

    @Transactional
    @Override
    public int editStudent(Student student) {

        System.out.println("sessionFactory = " + sessionFactory);
        int success = 0;
        try{
            sessionFactory.getCurrentSession().update(student);
            success = 1;
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return success;
    }



}
