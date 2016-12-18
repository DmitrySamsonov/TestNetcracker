package com.university.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        finally{
            return students;
        }
    }

    @Transactional
    @Override
    public List<Student> getStudents(String fio) {
        System.out.println("sessionFactory = " + sessionFactory);
        try{
            String query = fio + "%";
            Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
            cr.add(Restrictions.like("fio", query));
            students = (List<Student>)cr.list();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            return students;
        }
    }
    @Transactional
    @Override
    public List<Student> getStudents(int groupNumber) {
        System.out.println("sessionFactory = " + sessionFactory);

        try{
            String query = groupNumber + "%";
            Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
            cr.add(Restrictions.like("groupNumber",query));
            students = (List<Student>)cr.list();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            return students;
        }
    }

    @Transactional
    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try{
            student = (Student) sessionFactory.getCurrentSession().get(Student.class, id);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        finally {
            return student;
        }
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        try{
            sessionFactory.getCurrentSession().delete(getStudentById(id));
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Transactional
    @Override
    public void addStudent(Student student) {
        try{
            sessionFactory.getCurrentSession().save(student);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Transactional
    @Override
    public void editStudent(Student student) {
        try{
            sessionFactory.getCurrentSession().update(student);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }



}
