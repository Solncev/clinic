package ru.itis.kpfu.group11501.solncev.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.Appointment;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.AppointmentServiceImpl;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ClientServiceImpl;
import ru.itis.kpfu.group11501.solncev.serviceImpl.DoctorServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.AppointmentService;
import ru.itis.kpfu.group11501.solncev.services.ClientService;
import ru.itis.kpfu.group11501.solncev.services.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Марат on 06.11.2016.
 */
@WebServlet(name = "AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    DoctorService doctorService = new DoctorServiceImpl();
    ClientService clientService = new ClientServiceImpl();
    AppointmentService appointmentService = new AppointmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String name = (String) request.getParameter("name1");
        String surname = (String) request.getParameter("surname1");
        String login = (String) request.getSession().getAttribute("current_user");
        long doctor_id = doctorService.getId(name, surname);
        long client_id = clientService.getId(login);
        Appointment appointment = new Appointment(doctor_id, client_id, request.getParameter("date"), request.getParameter("time"));
        appointmentService.add(appointment);
        response.sendRedirect("/personal_cabinet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("appointment.ftl");
        Map<String, Object> root = new HashMap<>();
        List<Appointment> appointments = appointmentService.getAllAppointments();
        root.put("appointments", appointments);
        new TemplateRender().render(request, response, tmpl, root);
    }
}
