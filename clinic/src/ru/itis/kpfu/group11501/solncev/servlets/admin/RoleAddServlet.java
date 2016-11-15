package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Role;
import ru.itis.kpfu.group11501.solncev.serviceImpl.RoleServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
    RoleService roleService = new RoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Role role= new Role(Long.parseLong(request.getParameter("id")), request.getParameter("role"));
        roleService.addRole(role);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
