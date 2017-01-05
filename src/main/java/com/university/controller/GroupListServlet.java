package com.university.controller;

import com.university.entities.Group;
import com.university.service.impl.GroupServiceImpl;
import com.university.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "GroupListServlet",
        urlPatterns = {"/groups"})
public class GroupListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            GroupServiceImpl groupService = (GroupServiceImpl) getServletContext().getAttribute("groupServiceImpl");
//            Object a = getServletContext().getAttribute("groupService");
//          GroupService groupService = (GroupService) a ;


            List<Group> groupList = groupService.getGroups();
//            List<Group> groupList = ((GroupService) a).getGroups();


//            for (Group group : groupList) {
//
//                group.getGroupNumber();
//
//                group.getDepartment();
//
//                group.getNumbers();
//
//            }






            System.out.println("groupList = " + groupList);
            request.setAttribute("entityArray", groupList);

        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("groups.jsp").forward(request, response);

        }
    }
}
