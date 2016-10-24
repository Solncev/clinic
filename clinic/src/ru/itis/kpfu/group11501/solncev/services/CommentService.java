package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Comment;

import java.util.List;

/**
 * Created by Марат on 12.11.2016.
 */
public interface CommentService {
    List<Comment> getComments();

    void addComment(Comment comment);

    void removeCommentById(long id);
}
