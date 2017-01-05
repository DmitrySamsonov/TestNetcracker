package com.university.dao.impl;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import com.university.entities.Student;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupDAOImpl implements GroupDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    @Override
    public List<Group> getGroups() {
//        System.out.println("sessionFactory = " + sessionFactory);


        List<Group> groups = new ArrayList<Group>();
        try {
//            так работает:
//            groups = (List<Group>) sessionFactory.getCurrentSession()
//                    .createCriteria(Group.class)
//                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();



//            String sql = "select id, group.groupNumber, department/*, temp.numbers as numb*/ from" +

//            String sql = "select id, group.groupNumber, department from" +
//                         "                   university.group" +
//                         "                   left join" +
//                         "                   (SELECT groupNumber, count(groupNumber) as numbers FROM university.student" +
//                         "                    group by groupNumber) as temp" +
//                         "ON university.group.groupNumber = temp.groupNumber" +
//                         "order by numb desc";


//          ТАК РАБОТАЕТ
//          String sql = "SELECT id, groupNumber, department FROM university.group "+
//                         "order by groupNumber asc";


//          А так уже нет
            String sql = "select group.id, group.groupNumber, department, temp.numbers as numbers from university.group left join (SELECT groupNumber, count(groupNumber) as numbers FROM university.student group by groupNumber) as temp ON university.group.groupNumber = temp.groupNumber where temp.numbers is not null order by numbers desc;";

            String sql_group = "select * from university.group";
            SQLQuery query_group = sessionFactory.getCurrentSession().createSQLQuery(sql_group);
            query_group.addEntity(Group.class);
            List<Group> groupList = query_group.list();
            for(Group obj : groupList) {

                String sql_student = "select * from university.student where student.groupNumber =" + obj.getGroupNumber();

                SQLQuery query_student = sessionFactory.getCurrentSession().createSQLQuery(sql_student);
                query_student.addEntity(Student.class);
                List<Student> studentList = query_student.list();
                obj.setNumbers(Integer.toString(studentList.size()));
            }





            SQLQuery query2 = sessionFactory.getCurrentSession().createSQLQuery(sql);

            query2.addEntity(Group.class);

            List results2 = query2.list();
            List<Group> gr2 = results2;


            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
            List<Group> results = (List<Group>) query.setResultTransformer(Transformers.aliasToBean(Group.class)).list();
//            groups = (ArrayList<Group>) results;
//            groups  =  (List<Group>)  query.list();
            for(Object o : results)
            {
                groups.add((Group)o);
            }

        } catch (NullPointerException nullEx) {

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return groups;
        }
    }


}
