package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Staff;
import ru.itis.kpfu.group11501.solncev.serviceImpl.StaffServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 15.11.2016.
 */
@WebServlet(name = "StaffAddingServlet")
public class StaffAddingServlet extends HttpServlet {
    StaffService staffService = new StaffServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Staff staff = new Staff(Long.parseLong(request.getParameter("id")), request.getParameter("position"));
        staffService.addStaff(staff);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
