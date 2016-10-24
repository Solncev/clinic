package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Comment;
import ru.itis.kpfu.group11501.solncev.repositories.CommentRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.CommentRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.CommentService;

import java.util.List;


/**
 * Created by Марат on 12.11.2016.
 */
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public List<Comment> getComments() {
        return commentRepository.getComments();
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void removeCommentById(long id) {
        commentRepository.removeCommentById(id);
    }
}
