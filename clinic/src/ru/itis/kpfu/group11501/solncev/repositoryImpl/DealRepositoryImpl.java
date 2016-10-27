package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Deal;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.DealRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class DealRepositoryImpl implements DealRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addDeal(Deal deal) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO deals (id,deal_name,description) VALUES (?,?,?)"
            );
            ps.setLong(1, deal.getId());
            ps.setString(2, deal.getName());
            ps.setString(3, deal.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDeal(Deal deal) {

    }

    @Override
    public void updateDeal(Deal deal) {

    }

    @Override
    public List<Deal> getDeals() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM deals");
            List<Deal> deals = new ArrayList<>();
            while (resultSet.next()) {
                Deal deal = new Deal(
                        resultSet.getLong("id"),
                        resultSet.getString("deal_name"),
                        resultSet.getString("description")
                );
                deals.add(deal);
            }
            return deals;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void removeDealById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM deals WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
