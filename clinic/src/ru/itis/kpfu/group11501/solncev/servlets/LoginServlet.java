package ru.itis.kpfu.group11501.solncev.servlets;

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
 * Created by Марат on 28.09.2016.
 */
@WebServlet(name = "ru.itis.kpfu.group11501.solncev.servlets.LoginServlet")
public class LoginServlet extends HttpServlet {
    Statement st;
    ResultSet rs;
    ClientService clientService = new ClientServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("login.ftl");
        Map<String, Object> root = new HashMap<>();
        String err = request.getParameter("err");
        String login = request.getParameter("login");
        if (request.getSession().getAttribute("current_user") != null) {
            root.put("islogin", login);
        }
        root.put("err", err);
        root.put("login", login);
        new TemplateRender().render(request, response, tmpl, root);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String login = request.getParameter("login");
        String password = PasswordHasher.getMD5Digest(request.getParameter("password"));
        Client client = clientService.getClientByUsername(login);

        if (client != null) {
            if (password.equals(client.getPassword())) {
                request.getSession().setAttribute("current_user", login);
                if (request.getParameter("rememberMe") != null) {
                    Cookie cookie = new Cookie("login", login);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                }
                response.sendRedirect("/personal_cabinet");
            } else {
                response.sendRedirect("/login?err=" + URLEncoder.encode("Неверный пароль", "utf-8") + "&login=" + login);
            }
        } else {
            response.sendRedirect("/login?err=" + URLEncoder.encode("Пользователя с таким логином не существует", "utf-8") + "&login=" + login);
        }
    }
}