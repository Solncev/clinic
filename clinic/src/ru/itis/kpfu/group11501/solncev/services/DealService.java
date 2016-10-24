package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Deal;

import java.util.List;

/**
 * Created by Марат on 20.11.2016.
 */
public interface DealService {
    List<Deal> getDeals();

    void addDeal(Deal deal);

    void removeDealById(long id);
}
