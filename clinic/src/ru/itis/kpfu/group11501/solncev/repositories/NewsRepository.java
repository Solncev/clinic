package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.News;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface NewsRepository {
    void addNews(News news);

    void removeNews(News news);

    void updateNews(News news);

    List<News> getNews();

    News getNewsById(long id);

    void removeNewsById(long id);
}
