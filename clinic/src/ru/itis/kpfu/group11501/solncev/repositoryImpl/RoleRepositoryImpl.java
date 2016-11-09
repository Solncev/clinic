package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Role;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.RoleRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public class RoleRepositoryImpl implements RoleRepository {
    private Connection connection = DBConnectionHelper.getConnection();

    @Override
    public long getRoleId(long clientId) {
        long id = 1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients_roles WHERE client_id = ?");
            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("role_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public String getRole(long role_id) {
        String role = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles WHERE id = ?");
            preparedStatement.setLong(1, role_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role += resultSet.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void addRole(Role role) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO roles VALUES (?,?)"
            );
            ps.setLong(1, role.getId());
            ps.setString(2, role.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRoleById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM roles WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getRoles() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM roles ");
            List<Role> roles = new ArrayList<>();
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
