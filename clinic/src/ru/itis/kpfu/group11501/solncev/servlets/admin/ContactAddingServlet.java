package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Contact;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ContactServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "ContactAddingServlet")
public class ContactAddingServlet extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Contact contact = new Contact(Long.parseLong(request.getParameter("id")), request.getParameter("phone"),
                request.getParameter("email"), request.getParameter("address"));
        contactService.addContact(contact);
        response.sendRedirect("/admin");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
