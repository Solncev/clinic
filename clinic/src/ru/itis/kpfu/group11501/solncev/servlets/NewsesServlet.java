package ru.itis.kpfu.group11501.solncev.servlets;

import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.News;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.NewsServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.NewsService;

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
 * Created by Марат on 01.11.2016.
 */
@WebServlet(name = "NewsesServlet")
public class NewsesServlet extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate("newses.ftl");
        Map<String, Object> root = new HashMap<>();
        List<News> newses = newsService.getNews();
        root.put("newses", newses);
        if (request.getSession().getAttribute("current_user") != null) {
            root.put("islogin", "hghgh");
        }
        new TemplateRender().render(request, response, tmpl, root);
    }
}
