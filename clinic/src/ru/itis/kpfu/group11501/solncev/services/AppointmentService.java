package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Appointment;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface AppointmentService {
    List<Appointment> getAllAppointments();

    void add(Appointment appointment);

    List<Appointment> getAppointmentsByClientId(long clientId);

    void removeAppointmentById(long id);
}
