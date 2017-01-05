package com.university.dao.impl;

import com.mysql.jdbc.exceptions.MySQLTimeoutException;
import com.university.dao.interfaces.StudentDAO;
import com.university.entities.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    @Override
    public List<Student> getStudents() throws NullPointerException, Exception {

        List<Student> students = new ArrayList<Student>();
        System.out.println("sessionFactory = " + sessionFactory);
        try {
            students = (List<Student>) sessionFactory.getCurrentSession()
                    .createCriteria(Student.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            students = null;
            if (students == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("myNullPointerException in StudentDAOImpl: getStudent(): " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Exception in StudentDAOImpl: getStudent() " + e.getMessage());
        }
        return students;
    }

    @Transactional
    @Override
    public List<Student> getStudents(String sortBy, boolean asc) throws MySQLTimeoutException {

        List<Student> students = new ArrayList<Student>();
        System.out.println("sessionFactory = " + sessionFactory);
        try {
//            students = (List<Student>) sessionFactory.getCurrentSession()
//                    .createCriteria(Student.class)
//                    .addOrder(asc ? Order.asc(sortBy) : Order.desc(sortBy))
//                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
            if (sortBy != null) cr.addOrder(asc ? Order.asc(sortBy) : Order.desc(sortBy));
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            students = (List<Student>) cr.list();


        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return students;
        }
    }

    @Transactional
    @Override
    public List<Student> getStudents(String fio) {

        List<Student> students = new ArrayList<Student>();
        System.out.println("sessionFactory = " + sessionFactory);
        try {
            String query = fio + "%";
            Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
            cr.add(Restrictions.like("fio", query));
            students = (List<Student>) cr.list();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return students;
        }
    }

    @Transactional
    @Override
    public List<Student> getStudents(int groupNumber) {
        List<Student> students = new ArrayList<Student>();
        System.out.println("sessionFactory = " + sessionFactory);

        try {
            Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
            cr.add(Restrictions.like("groupNumber", groupNumber));
            students = (List<Student>) cr.list();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return students;
        }
    }

    @Transactional
    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try {
            student = (Student) sessionFactory.getCurrentSession().get(Student.class, id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return student;
        }
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        try {
            sessionFactory.getCurrentSession().delete(getStudentById(id));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Transactional
    @Override
    public void addStudent(Student student) {
        try {
            sessionFactory.getCurrentSession().save(student);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Transactional
    @Override
    public void editStudent(Student student) {
        try {
            sessionFactory.getCurrentSession().update(student);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
