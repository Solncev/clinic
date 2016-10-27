package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Appointment;
import ru.itis.kpfu.group11501.solncev.repositories.AppointmentRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.AppointmentRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.AppointmentService;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAppointments();
    }

    @Override
    public void add(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByClientId(long clientId) {
        return appointmentRepository.getAppointmentsByClientId(clientId);
    }

    @Override
    public void removeAppointmentById(long id) {
        appointmentRepository.removeAppointmentById(id);
    }
}
