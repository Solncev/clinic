package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Appointment;
import ru.itis.kpfu.group11501.solncev.serviceImpl.AppointmentServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.AppointmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 15.11.2016.
 */
@WebServlet(name = "AppointmentAddingServlet")
public class AppointmentAddingServlet extends HttpServlet {
    AppointmentService appointmentService = new AppointmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Appointment appointment = new Appointment(Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("client_id")),
                Long.parseLong(request.getParameter("doctor_id")), request.getParameter("date"), request.getParameter("time"));
        appointmentService.add(appointment);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
