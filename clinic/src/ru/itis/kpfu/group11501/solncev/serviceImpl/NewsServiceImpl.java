package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.News;
import ru.itis.kpfu.group11501.solncev.repositories.NewsRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.NewsRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.NewsService;

import java.util.List;

/**
 * Created by Марат on 11.11.2016.
 */
public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository = new NewsRepositoryImpl();

    @Override
    public List<News> getNews() {
        return newsRepository.getNews();
    }

    @Override
    public News getNewsById(long id) {
        return newsRepository.getNewsById(id);
    }

    @Override
    public void removeNewsById(long id) {
        newsRepository.removeNewsById(id);
    }

    @Override
    public void addNews(News news) {
        newsRepository.addNews(news);
    }
}
