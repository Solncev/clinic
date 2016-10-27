package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Question;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface QuestionRepository {
    void addQuestion(Question question);

    void removeQuestion(Question question);

    void updateQuestion(Question question);

    List<Question> getQuestions();
}
