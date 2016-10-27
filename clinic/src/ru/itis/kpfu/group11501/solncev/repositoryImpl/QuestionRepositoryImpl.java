package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Question;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.QuestionRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class QuestionRepositoryImpl implements QuestionRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public void removeQuestion(Question question) {

    }

    @Override
    public void updateQuestion(Question question) {

    }

    @Override
    public List<Question> getQuestions() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions");
            List<Question> questions = new ArrayList<>();
            while (resultSet.next()) {
                Question question = new Question(
                        resultSet.getLong("id"),
                        resultSet.getLong("client_id"),
                        resultSet.getLong("admin_id"),
                        resultSet.getString("text"),
                        resultSet.getString("date"),
                        resultSet.getString("time")
                );
                questions.add(question);
            }
            return questions;
        } catch (SQLException e) {
            return null;
        }
    }
}
