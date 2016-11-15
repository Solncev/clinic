package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Service;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ServiceServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 15.11.2016.
 */
@WebServlet(name = "ServiceAddingServlet")
public class ServiceAddingServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Service service = new Service(Long.getLong(request.getParameter("id")), request.getParameter("name"), request.getParameter("text"),
                request.getParameter("photo"), Integer.parseInt(request.getParameter("price")));
        serviceService.addService(service);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
