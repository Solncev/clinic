package ru.itis.kpfu.group11501.solncev.servlets.admin;

import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.*;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.*;
import ru.itis.kpfu.group11501.solncev.services.*;

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
 * Created by Марат on 15.11.2016.
 */
@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    ClientService clientService = new ClientServiceImpl();
    AppointmentService appointmentService = new AppointmentServiceImpl();
    CommentService commentService = new CommentServiceImpl();
    ContactService contactService = new ContactServiceImpl();
    DealService dealService = new DealServiceImpl();
    DoctorService doctorService = new DoctorServiceImpl();
    NewsService newsService = new NewsServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    RoleService roleService = new RoleServiceImpl();
    C_RService c_rService = new C_RServiceImpl();
    StaffService staffService = new StaffServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate("admin.ftl");
        if (request.getSession().getAttribute("current_admin") != null) {
            String login = (String) request.getSession().getAttribute("current_admin");
            List<Client> clients = clientService.getAllClients();
            List<Appointment> appointments = appointmentService.getAllAppointments();
            List<Comment> comments = commentService.getComments();
            List<Contact> contacts = contactService.getContacts();
            List<Deal> deals = dealService.getDeals();
            List<Doctor> doctors = doctorService.getAllDoctors();
            List<News> newses = newsService.getNews();
            List<Service> services = serviceService.getServices();
            List<Role> roles = roleService.getRoles();
            List<C_R> c_rs = c_rService.getC_Res();
            List<Staff> staffs = staffService.getStaffs();
            Map<String, Object> root = new HashMap<>();
            root.put("users", clients);
            root.put("appointments", appointments);
            root.put("comments", comments);
            root.put("contacts", contacts);
            root.put("deals", deals);
            root.put("doctors", doctors);
            root.put("news", newses);
            root.put("services", services);
            root.put("roles", roles);
            root.put("clients_roles", c_rs);
            root.put("staffs",staffs);
            new TemplateRender().render(request, response, tmpl, root);
        } else {
            response.sendRedirect("/adminlogin");
        }
    }
}
