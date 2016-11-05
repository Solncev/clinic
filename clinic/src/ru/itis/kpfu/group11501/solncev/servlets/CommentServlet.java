package ru.itis.kpfu.group11501.solncev.servlets;

import freemarker.template.Template;
import ru.itis.kpfu.group11501.solncev.configs.ConfigSingleton;
import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.entities.Comment;
import ru.itis.kpfu.group11501.solncev.helpers.TemplateRender;
import ru.itis.kpfu.group11501.solncev.serviceImpl.ClientServiceImpl;
import ru.itis.kpfu.group11501.solncev.serviceImpl.CommentServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.ClientService;
import ru.itis.kpfu.group11501.solncev.services.CommentService;

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
 * Created by Марат on 02.11.2016.
 */
@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();
    ClientService clientService = new ClientServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        ClientService clientService = new ClientServiceImpl();
        long client_id = 12;
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null) {
            client_id = clientService.getId(login);
        }
        String text = request.getParameter("comment");
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        String commentDate = date.toString();
        String username = clientService.getNameByLogin((String) request.getSession().getAttribute("current_user"));
        Comment comment = new Comment(client_id, text, commentDate, username);
        commentService.addComment(comment);
        response.sendRedirect("/comments");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate("comments.ftl");
        Map<String, Object> root = new HashMap<>();
        List<Comment> comments = commentService.getComments();
        List<Client> clients = clientService.getAllClients();
        root.put("comments", comments);
        root.put("clients", clients);
        new TemplateRender().render(request, response, tmpl, root);
    }
}
