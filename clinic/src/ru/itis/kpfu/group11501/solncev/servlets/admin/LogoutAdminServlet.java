package ru.itis.kpfu.group11501.solncev.servlets.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "LogoutAdminServlet")
public class LogoutAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        request.getSession().setAttribute("current_admin", null);
        Cookie cookie = new Cookie("admin", request.getParameter("login"));
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("/adminlogin");
    }
}
