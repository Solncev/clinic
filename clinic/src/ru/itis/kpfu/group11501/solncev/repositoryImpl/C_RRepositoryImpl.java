package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.C_R;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.C_RRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 08.11.2016.
 */
public class C_RRepositoryImpl implements C_RRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addC_R(C_R c_r) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO clients_roles VALUES (?,?,?)"
            );
            ps.setLong(1, c_r.getId());
            ps.setLong(2, c_r.getClient_id());
            ps.setLong(3, c_r.getRole_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("incorrect");
            e.printStackTrace();
        }
    }

    @Override
    public void RemoveC_RById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clients_roles WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<C_R> getC_Res() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients_roles");
            List<C_R> c_rs = new ArrayList<>();
            while (resultSet.next()) {
                C_R c_r = new C_R(
                        resultSet.getLong("id"),
                        resultSet.getLong("client_id"),
                        resultSet.getLong("role_id")
                );
                c_rs.add(c_r);
            }
            return c_rs;
        } catch (SQLException e) {
            return null;
        }
    }
}
