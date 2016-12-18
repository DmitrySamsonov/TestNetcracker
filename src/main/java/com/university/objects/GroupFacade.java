package com.university.objects;

import com.university.dao.interfaces.GroupDAO;
import com.university.entities.Group;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("groupFacade")
@Scope("singleton")
public class GroupFacade {

    private GroupDAO groupDAO;

    private List<Group> groups;


    public List<Group> getGroups(){
        try{
            groups = groupDAO.getGroups();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return groups;
    }




}
