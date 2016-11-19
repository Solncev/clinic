package ru.itis.kpfu.group11501.solncev.servlets;

import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.Appointment;
import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.AppointmentServiceImpl;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ClientServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.AppointmentService;
import ru.itis.kpfu.group11501.solncev.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "AccountServlet")
public class AccountServlet extends HttpServlet {
    ClientService clientService = new ClientServiceImpl();
    AppointmentService appointmentService = new AppointmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate("account.ftl");
        if (request.getSession().getAttribute("current_user") != null) {
            String login = (String) request.getSession().getAttribute("current_user");
            Client client = clientService.getClientByUsername(login);
            Map<String, Object> root = new HashMap<>();
            List<Appointment> appointments = appointmentService.getAppointmentsByClientId(clientService.getId(login));
            root.put("client", client);
            root.put("appointments", appointments);
            root.put("islogin", login);
            new TemplateRender().render(request, response, tmpl, root);
        } else {
            response.sendRedirect("/login");
        }
    }
}
