package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Appointment;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.AppointmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class AppointmentRepositoryImpl implements AppointmentRepository {
    Appointment appointment = null;
    private Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addAppointment(Appointment appointment) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT into appointments(id,client_id,doctor_id,appointment_date,appointment_time)" +
                    " VALUES (?,?,?,to_date(?, 'YYYY-MM-DD'),to_timestamp(?, 'hh24:mi'))");
            preparedStatement.setLong(1, appointment.getId());
            preparedStatement.setLong(2, appointment.getClient_id());
            preparedStatement.setLong(3, appointment.getDoctor_id());
            preparedStatement.setDate(4, Date.valueOf(appointment.getDate()));
            preparedStatement.setString(5, appointment.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAppointment(Appointment appointment) {

    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public List<Appointment> getAppointments() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM appointments");
            List<Appointment> appointments = new ArrayList<>();
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getLong("id"),
                        resultSet.getLong("client_id"),
                        resultSet.getLong("doctor_id"),
                        resultSet.getString("appointment_date"),
                        resultSet.getString("appointment_time")
                );
                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Appointment> getAppointmentsByClientId(long clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM appointments WHERE client_id=?");
            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Appointment> appointments = new ArrayList<>();
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getLong("id"),
                        resultSet.getLong("client_id"),
                        resultSet.getLong("doctor_id"),
                        resultSet.getString("appointment_date"),
                        resultSet.getString("appointment_time")
                );
                appointments.add(appointment);
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeAppointmentById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM appointments WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
