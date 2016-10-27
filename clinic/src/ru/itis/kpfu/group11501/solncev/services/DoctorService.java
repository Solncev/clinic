package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Doctor;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface DoctorService {
    public List<Doctor> getAllDoctors();

    public Doctor getDoctorById(long id);

    public List<Doctor> getLeaders();

    public Long getId(String name, String surname);

    void addDoctor(Doctor doctor);

    void removeDoctorById(long id);
}
