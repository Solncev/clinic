package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Doctor;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface DoctorRepository {
    void addDoctor(Doctor doctor);

    void removeDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    Doctor getDoctorById(long id);

    List<Doctor> getDoctors();

    List<Doctor> getLeaders();

    Long getId(String name, String surname);

    void removeDoctorById(long id);
}
