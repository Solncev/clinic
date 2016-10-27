package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.News;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.NewsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class NewsRepositoryImpl implements NewsRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addNews(News news) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO newses VALUES (?,?,?,?,to_date(?, 'YYYY-MM-DD'),to_timestamp(?, 'hh24:mi'))"
            );
            ps.setLong(1, news.getId());
            ps.setString(2, news.getPhoto());
            ps.setString(3, news.getTopic());
            ps.setString(4, news.getText());
            ps.setString(5, news.getDate());
            ps.setString(6, news.getTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeNews(News news) {

    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public List<News> getNews() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM newses ORDER BY news_date DESC, news_time DESC ");
            List<News> newses = new ArrayList<>();
            while (resultSet.next()) {
                News news = new News(
                        resultSet.getLong("id"),
                        resultSet.getString("photo"),
                        resultSet.getString("topic"),
                        resultSet.getString("news_text"),
                        resultSet.getString("news_date"),
                        resultSet.getString("news_time")
                );
                newses.add(news);
            }
            return newses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public News getNewsById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM newses WHERE id =?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            News news = null;
            while (resultSet.next()) {
                news = new News(
                        resultSet.getLong("id"),
                        resultSet.getString("photo"),
                        resultSet.getString("topic"),
                        resultSet.getString("news_text"),
                        resultSet.getString("news_date"),
                        resultSet.getString("news_time")
                );

            }
            return news;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeNewsById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM newses WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
