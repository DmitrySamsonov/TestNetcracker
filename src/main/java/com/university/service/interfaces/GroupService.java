package com.university.service.interfaces;

import com.university.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<Group> getGroups();
}
