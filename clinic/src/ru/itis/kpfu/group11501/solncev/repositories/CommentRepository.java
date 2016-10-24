package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Comment;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface CommentRepository {
    void addComment(Comment comment);

    void removeComment(Comment comment);

    void updateComment(Comment comment);

    List<Comment> getComments();

    void removeCommentById(long id);
}
