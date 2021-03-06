package com.university.service.impl;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import com.university.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

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
