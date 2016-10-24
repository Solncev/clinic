package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Doctor;
import ru.itis.kpfu.group11501.solncev.repositories.DoctorRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.DoctorRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.DoctorService;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public class DoctorServiceImpl implements DoctorService {
    DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.getDoctors();
    }

    @Override
    public Doctor getDoctorById(long id) {
        return doctorRepository.getDoctorById(id);
    }

    @Override
    public List<Doctor> getLeaders() {
        return doctorRepository.getLeaders();
    }

    @Override
    public Long getId(String name, String surname) {
        return doctorRepository.getId(name, surname);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);
    }

    @Override
    public void removeDoctorById(long id) {
        doctorRepository.removeDoctorById(id);
    }
}
