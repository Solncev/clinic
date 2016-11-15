package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Deal;
import ru.itis.kpfu.group11501.solncev.serviceImpl.DealServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.DealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "DealAddingServlet")
public class DealAddingServlet extends HttpServlet {
    DealService dealService = new DealServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Deal deal = new Deal(Long.parseLong(request.getParameter("id")), request.getParameter("name"), request.getParameter("description"));
        dealService.addDeal(deal);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
