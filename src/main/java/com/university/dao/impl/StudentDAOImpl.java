package com.university.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

        students = (List<Student>) sessionFactory.getCurrentSession()
                .createCriteria(Student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        System.out.println("sessionFactory = " + sessionFactory);

        return students;
    }



}
