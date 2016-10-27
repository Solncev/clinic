package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Deal;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface DealRepository {
    void addDeal(Deal deal);

    void removeDeal(Deal deal);

    void updateDeal(Deal deal);

    List<Deal> getDeals();

    void removeDealById(long id);
}
