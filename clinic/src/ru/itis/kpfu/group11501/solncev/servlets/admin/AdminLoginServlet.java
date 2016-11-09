package ru.itis.kpfu.group11501.solncev.servlets.admin;

import freemarker.template.Configuration;
import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.helpers.PasswordHasher;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ClientServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Марат on 09.11.2016.
 */
@WebServlet(name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    Statement st;
    ResultSet rs;
    ClientService clientService = new ClientServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String login = request.getParameter("login");
        String password = PasswordHasher.getMD5Digest(request.getParameter("password"));
        Client client = clientService.getClientByUsername(login);
        if (clientService.idAdmin(login)) {
            if (client != null) {
                if (password.equals(client.getPassword())) {
                    request.getSession().setAttribute("current_admin", login);
                    if (request.getParameter("rememberMe") != null) {
                        Cookie cookie = new Cookie("admin", login);
                        cookie.setMaxAge(24 * 60 * 60);
                        response.addCookie(cookie);
                    }
                    response.sendRedirect("/admin");
                } else {
                    response.sendRedirect("/adminlogin?err=" + URLEncoder.encode("Неверный пароль", "utf-8") + "&login=" + login);
                }
            } else {
                response.sendRedirect("/adminlogin?err=" + URLEncoder.encode("Пользователя с таким логином не существует", "utf-8") + "&login=" + login);
            }
        } else {
            response.sendRedirect("/adminlogin?err=" + URLEncoder.encode("Вы не являетесь администратором", "utf-8") + "&login=" + login);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("adminlogin.ftl");
        Map<String, Object> root = new HashMap<>();
        String err = request.getParameter("err");
        String login = request.getParameter("login");
        root.put("err", err);
        root.put("login", login);
        new TemplateRender().render(request, response, tmpl, root);
    }
}

