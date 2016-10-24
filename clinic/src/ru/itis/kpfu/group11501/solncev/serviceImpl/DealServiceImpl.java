package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Deal;
import ru.itis.kpfu.group11501.solncev.repositories.DealRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.DealRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.DealService;

import java.util.List;

/**
 * Created by Марат on 20.11.2016.
 */
public class DealServiceImpl implements DealService {
    DealRepository dealRepository = new DealRepositoryImpl();

    @Override
    public List<Deal> getDeals() {
        return dealRepository.getDeals();
    }

    @Override
    public void addDeal(Deal deal) {
        dealRepository.addDeal(deal);
    }

    @Override
    public void removeDealById(long id) {
        dealRepository.removeDealById(id);
    }
}
