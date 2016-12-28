package com.university.dao.impl;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupDAOImpl implements GroupDAO {


    @Autowired
    private SessionFactory sessionFactory;



    @Transactional
    @Override
    public List<Group> getGroups() {

        List<Group> groups = new ArrayList<Group>();
        System.out.println("sessionFactory = " + sessionFactory);
        try {
            groups = (List<Group>) sessionFactory.getCurrentSession()
                    .createCriteria(Group.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        } catch(NullPointerException nullEx){

        }catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return groups;
        }
    }


}
