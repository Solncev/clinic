package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.serviceImpl.C_RServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.C_RService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 15.11.2016.
 */
@WebServlet(name = "C_RRemoveServlet")
public class C_RRemoveServlet extends HttpServlet {
    C_RService c_rService = new C_RServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        c_rService.RemoveC_RById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
