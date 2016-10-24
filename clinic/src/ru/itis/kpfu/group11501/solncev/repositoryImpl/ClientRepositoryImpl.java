package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.ClientRepository;
import ru.itis.kpfu.group11501.solncev.repositories.RoleRepository;
import ru.itis.kpfu.group11501.solncev.repositories.StaffRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public class ClientRepositoryImpl implements ClientRepository {
    Connection connection = DBConnectionHelper.getConnection();
    StaffRepository staffRepository = new StaffRepositoryImpl();
    RoleRepository rolesRepository = new RoleRepositoryImpl();
    Client client = null;

    @Override
    public void AddClient(Client client1) {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO clients(id, login, password, surname, firstname, patronymic, birthDay,gender, mobilenumber, OMSnumber) " +
                            "VALUES (?,?, ?, ?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?,?,?)"
            );
            ps.setLong(1, client1.getId());
            ps.setString(2, client1.getLogin());
            ps.setString(3, client1.getPassword());
            ps.setString(4, client1.getSurname());
            ps.setString(5, client1.getName());
            ps.setString(6, client1.getPatronymic());
            ps.setString(7, client1.getBirthDay());
            ps.setString(8, client1.getGender());
            ps.setString(9, client1.getMobile_number());
            ps.setString(10, client1.getOMS_number());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeClient(Client client) {

    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public List<Client> getClients() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("surname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birthDay"),
                        resultSet.getString("gender"),
                        resultSet.getString("mobilenumber"),
                        resultSet.getString("omsnumber")
                );
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Client getClientByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE login = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("surname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birthDay"),
                        resultSet.getString("gender"),
                        resultSet.getString("mobileNumber"),
                        resultSet.getString("OMSNumber")
                );
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public String getNameByLogin(String login) {
        String name = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("surname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public Long getId(String username) {
        long id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE login = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Boolean isLoginExist(String login) {
        int i = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (i != 0);
    }

    @Override
    public void removeClientById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAdmin(String login) {
        long id = getId(login);
        long role_id = rolesRepository.getRoleId(id);
        String role = rolesRepository.getRole(role_id);
        return role.equals("admin");
    }
}
