package com.university.objects;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("groupFacade")
//@Scope("singleton")
public class GroupFacade {

    @Autowired
    private GroupDAO groupDAO;

    public List<Group> getGroups() {

        List<Group> groups = new ArrayList<Group>();
        try {
            groups = groupDAO.getGroups();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return groups;
        }
    }


}
