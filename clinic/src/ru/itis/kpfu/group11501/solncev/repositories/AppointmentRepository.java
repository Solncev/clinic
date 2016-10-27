package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Appointment;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface AppointmentRepository {
    void addAppointment(Appointment appointment);

    void removeAppointment(Appointment appointment);

    void updateAppointment(Appointment appointment);

    List<Appointment> getAppointments();

    List<Appointment> getAppointmentsByClientId(long clientId);

    void removeAppointmentById(long id);
}
