package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Doctor;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.DoctorRepository;
import ru.itis.kpfu.group11501.solncev.repositories.StaffRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class DoctorRepositoryImpl implements DoctorRepository {
    Connection connection = DBConnectionHelper.getConnection();
    StaffRepository staffRepository = new StaffRepositoryImpl();

    @Override
    public void addDoctor(Doctor doctor) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO doctors VALUES ( ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)"
            );
            ps.setLong(1, doctor.getId());
            ps.setString(2, doctor.getSurname());
            ps.setString(3, doctor.getName());
            ps.setString(4, doctor.getPatronymic());
            ps.setInt(5, Integer.parseInt(doctor.getStaff()));
            ps.setString(6, doctor.getSpeciality());
            ps.setString(7, doctor.getPhoto());
            ps.setString(8, doctor.getEducation());
            ps.setString(9, doctor.getAchievements());
            ps.setInt(10, doctor.getExperience());
            ps.setString(11, doctor.getCertificate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDoctor(Doctor doctor) {

    }

    @Override
    public void updateDoctor(Doctor doctor) {

    }

    @Override
    public Doctor getDoctorById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM doctors WHERE id =?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String position = "";
            while (resultSet.next()) {
                position = staffRepository.getStaffById(resultSet.getLong("staff_id"));
                Doctor doctor = new Doctor(
                        resultSet.getLong("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        position,
                        resultSet.getString("speciality"),
                        resultSet.getString("photo"),
                        resultSet.getString("education"),
                        resultSet.getString("achievements"),
                        resultSet.getInt("experience"),
                        resultSet.getString("certificate")
                );
                return doctor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");
            List<Doctor> doctors = new ArrayList<>();
            String position = "";
            while (resultSet.next()) {
                position = staffRepository.getStaffById(resultSet.getLong("staff_id"));
                Doctor doctor = new Doctor(
                        resultSet.getLong("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        position,
                        resultSet.getString("speciality"),
                        resultSet.getString("photo"),
                        resultSet.getString("education"),
                        resultSet.getString("achievements"),
                        resultSet.getInt("experience"),
                        resultSet.getString("certificate")
                );
                doctors.add(doctor);
            }
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Doctor> getLeaders() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");
            List<Doctor> doctors = new ArrayList<>();
            String position = "";
            while (resultSet.next()) {
                position = staffRepository.getStaffById(resultSet.getLong("staff_id"));
                Doctor doctor = new Doctor(
                        resultSet.getLong("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        position,
                        resultSet.getString("speciality"),
                        resultSet.getString("photo"),
                        resultSet.getString("education"),
                        resultSet.getString("achievements"),
                        resultSet.getInt("experience"),
                        resultSet.getString("certificate")
                );
                if (position.toLowerCase().startsWith("руководитель") || position.toLowerCase().startsWith("заместитель"))
                    doctors.add(doctor);
            }
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getId(String name, String surname) {
        long id = 1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM doctors WHERE firstname = ? and surname = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
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
    public void removeDoctorById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM doctors WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
