package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.News;
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
@WebServlet(name = "NewsAddingServlet")
public class NewsAddingServlet extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        News news = new News(Long.parseLong(request.getParameter("id")), request.getParameter("photo"), request.getParameter("topic"),
                request.getParameter("text"), request.getParameter("date"), request.getParameter("time"));
        newsService.addNews(news);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
