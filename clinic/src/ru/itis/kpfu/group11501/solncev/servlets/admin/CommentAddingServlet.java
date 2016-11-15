package ru.itis.kpfu.group11501.solncev.servlets.admin;

import ru.itis.kpfu.group11501.solncev.entities.Comment;
import ru.itis.kpfu.group11501.solncev.serviceImpl.CommentServiceImpl;
import ru.itis.kpfu.group11501.solncev.services.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 14.11.2016.
 */
@WebServlet(name = "CommentAddingServlet")
public class CommentAddingServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Comment comment = new Comment(Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("client_id")),
                request.getParameter("text"), request.getParameter("date"), request.getParameter("time"),
                request.getParameter("name"));
        commentService.addComment(comment);
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
