package com.university.servlets;

import com.university.entities.Group;
import com.university.objects.GroupFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dima on 18.12.2016.
 */
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
            GroupFacade groupFacade = (GroupFacade) getServletContext().getAttribute("groupFacade");

            List<Group> groupList = groupFacade.getGroups();

            System.out.println("groupList = " + groupList);
            request.setAttribute("entityArray", groupList);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("groups.jsp").forward(request, response);
        }
    }
}
