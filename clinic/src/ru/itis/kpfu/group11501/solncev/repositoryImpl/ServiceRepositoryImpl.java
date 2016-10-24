package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Service;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.ServiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public class ServiceRepositoryImpl implements ServiceRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addService(Service service) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT into services" +
                    " VALUES (?,?,?,?,?");
            preparedStatement.setLong(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setString(3, service.getText());
            preparedStatement.setString(4, service.getPhoto());
            preparedStatement.setInt(5, service.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeService(Service service) {

    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public List<Service> getServices() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM services");
            List<Service> services = new ArrayList<>();
            while (resultSet.next()) {
                Service service = new Service(
                        resultSet.getLong("id"),
                        resultSet.getString("service_name"),
                        resultSet.getString("service_text"),
                        resultSet.getString("photo"),
                        resultSet.getInt("price")
                );
                services.add(service);
            }
            return services;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Service getServiceById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM services WHERE id =?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;
            while (resultSet.next()) {
                service = new Service(
                        resultSet.getLong("id"),
                        resultSet.getString("service_name"),
                        resultSet.getString("service_text"),
                        resultSet.getString("photo"),
                        resultSet.getInt("price")
                );

            }
            return service;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM services WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
