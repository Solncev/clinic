package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.serviceImpl.NewsServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "NewsRemovingServlet")
public class NewsRemovingServlet extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        newsService.removeNewsById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
