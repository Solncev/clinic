package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.C_R;
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
@WebServlet(name = "C_RAddingServlet")
public class C_RAddingServlet extends HttpServlet {
    C_RService c_rService = new C_RServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        C_R c_r = new C_R(Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("client_id")), Long.parseLong(request.getParameter("role_id")));
        c_rService.addC_R(c_r);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
