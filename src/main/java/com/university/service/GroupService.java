package com.university.service;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("groupService")
public class GroupService {

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
