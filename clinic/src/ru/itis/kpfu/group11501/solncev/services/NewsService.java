package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.News;

import java.util.List;

/**
 * Created by Марат on 11.11.2016.
 */
public interface NewsService {
    List<News> getNews();

    News getNewsById(long id);

    void removeNewsById(long id);

    void addNews(News news);
}
