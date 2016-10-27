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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 25.10.2016.
 */
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    ClientService clientService = new ClientServiceImpl();
    Pattern name = Pattern.compile("^\\D+$");
    Pattern mobile = Pattern.compile("^\\d+$");


    protected static void doResponse(HttpServletRequest request, HttpServletResponse response, Client client, String message) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("/registration?err=" + URLEncoder.encode(message, "utf-8") + "&login=" + URLEncoder.encode(client.getLogin(), "utf-8") +
                "&surname=" + URLEncoder.encode(client.getSurname(), "utf-8") + "&firstname=" + URLEncoder.encode(client.getName(), "utf-8") + "&patronymic=" +
                URLEncoder.encode(client.getPatronymic(), "utf-8") + "&password=" + request.getParameter("password")
                + "&gender=" + URLEncoder.encode(client.getGender(), "utf-8") + "&mobilenumber=" + URLEncoder.encode(client.getMobile_number(), "utf-8") +
                "&omsnumber=" + URLEncoder.encode(client.getOMS_number(), "utf-8"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String hash = PasswordHasher.getMD5Digest(request.getParameter("password"));

        Client client = new Client(request.getParameter("login"), hash, request.getParameter("surname"),
                request.getParameter("firstname"), request.getParameter("patronymic"), request.getParameter("birthday"),
                request.getParameter("gender"), request.getParameter("mobilenumber"), request.getParameter("omsnumber"));

        Matcher matcher_name = name.matcher(request.getParameter("surname"));
        Matcher matcher_mobile = mobile.matcher(request.getParameter("mobilenumber"));

        if (request.getParameter("login").equals("") || request.getParameter("surname").equals("") || request.getParameter("firstname").equals("") ||
                request.getParameter("patronymic").equals("") || request.getParameter("birthday").equals("") || request.getParameter("password").equals("") ||
                request.getParameter("gender").equals("") || request.getParameter("mobilenumber").equals("") || request.getParameter("omsnumber").equals("") ||
                request.getParameter("password2").equals("")) {

            doResponse(request, response, client, "Заполните все поля");

        } else {
            if (!clientService.isLoginExist(request.getParameter("login"))) {

                if (matcher_name.matches()) {
                    if (matcher_mobile.matches()) {
                        if (!request.getParameter("password2").equals(request.getParameter("password"))) {

                            doResponse(request, response, client, "Пароли не совпадают");

                        } else {
                            if (client != null) {
                                clientService.addClient(client);
                                if (clientService.getClientByUsername(request.getParameter("login")) != null) {
                                    request.getSession().setAttribute("current_user", null);
                                    Cookie cookie = new Cookie("login", request.getParameter("login"));
                                    cookie.setMaxAge(0);
                                    response.addCookie(cookie);
                                    response.sendRedirect("/login");
                                }
                            } else {
                                response.sendRedirect("/registration");
                            }
                        }
                    } else {
                        doResponse(request, response, client, "Неправильно введен мобильный номер. Пример:89172736465");
                    }

                } else {
                    doResponse(request, response, client, "Имя, Фамилия и Отчество могут содержать только буквы");
                }
            } else {
                doResponse(request, response, client, "Пользователь с таким логином уже существует");
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("registration.ftl");
        Map<String, Object> root = new HashMap<>();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname = request.getParameter("surname");
        String name = request.getParameter("firstname");
        String patronymic = request.getParameter("patronymic");
        String gender = request.getParameter("gender");
        String mobile_number = request.getParameter("mobilenumber");
        String OMS_number = request.getParameter("omsnumber");
        String err = request.getParameter("err");
        root.put("err", err);
        root.put("login", login);
        root.put("password", password);
        root.put("surname", surname);
        root.put("firstname", name);
        root.put("patronymic", patronymic);
        root.put("gender", gender);
        root.put("mobilenumber", mobile_number);
        root.put("omsnumber", OMS_number);
        new TemplateRender().render(request, response, tmpl, root);
    }
}
