package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Deal;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface DealRepository {
    void addDeal(Deal deal);

    void removeDeal(Deal deal);

    void updateDeal(Deal deal);

    List<Deal> getDeals();

    void removeDealById(long id);
}
