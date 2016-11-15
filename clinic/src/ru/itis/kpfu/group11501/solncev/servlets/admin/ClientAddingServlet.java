package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ClientServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "ClientAddingServlet")
public class ClientAddingServlet extends HttpServlet {
    ClientService clientService = new ClientServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Client client = new Client(Long.parseLong(request.getParameter("id")), request.getParameter("login"), request.getParameter("password"),
                request.getParameter("surname"), request.getParameter("name"), request.getParameter("patronymic"), request.getParameter("bday"),
                request.getParameter("gender"), request.getParameter("mobile"), request.getParameter("oms"));
        clientService.addClient(client);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
