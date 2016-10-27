package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Staff;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.StaffRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class StaffRepositoryImpl implements StaffRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addStaff(Staff staff) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO staffs VALUES (?,?)"
            );
            ps.setLong(1, staff.getId());
            ps.setString(2, staff.getPosition());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStaff(Staff staff) {

    }

    @Override
    public void updateStaff(Staff staff) {

    }

    @Override
    public List<Staff> getStaffs() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from staffs");
            List<Staff> staffs = new ArrayList<>();
            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getLong("id"),
                        resultSet.getString("position")
                );
                staffs.add(staff);
            }
            return staffs;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public String getStaffById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM staffs WHERE id =?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String position = "";
            while (resultSet.next()) {
                position = resultSet.getString("position");
            }
            return position;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeStaffById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM staffs WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
