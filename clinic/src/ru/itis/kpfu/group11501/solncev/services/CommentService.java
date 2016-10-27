package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Comment;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface CommentService {
    List<Comment> getComments();

    void addComment(Comment comment);

    void removeCommentById(long id);
}
