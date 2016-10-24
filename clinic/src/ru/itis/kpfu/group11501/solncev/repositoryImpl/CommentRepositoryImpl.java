package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Comment;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.ClientRepository;
import ru.itis.kpfu.group11501.solncev.repositories.CommentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public class CommentRepositoryImpl implements CommentRepository {
    Connection connection = DBConnectionHelper.getConnection();
    ClientRepository clientRepository = new ClientRepositoryImpl();

    @Override
    public void addComment(Comment comment) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO comments (client_id, comment_text, comment_date, client_name) VALUES (?,?,to_date(?, 'YYYY-MM-DD'),?)"
            );
            ps.setLong(1, comment.getClient_id());
            ps.setString(2, comment.getText());
            ps.setDate(3, Date.valueOf(comment.getDate()));
            ps.setString(4, comment.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public List<Comment> getComments() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM comments ORDER BY comment_date  , comment_time  ");
            List<Comment> comments = new ArrayList<>();
            while (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getLong("id"),
                        resultSet.getLong("client_id"),
                        resultSet.getString("comment_text"),
                        resultSet.getString("comment_date"),
                        resultSet.getString("comment_time"),
                        resultSet.getString("client_name")
                );
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void removeCommentById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM comments WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
