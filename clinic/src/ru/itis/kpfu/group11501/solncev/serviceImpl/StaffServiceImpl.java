package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Staff;
import ru.itis.kpfu.group11501.solncev.repositories.StaffRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.StaffRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.StaffService;

import java.util.List;

/**
 * Created by Марат on 20.11.2016.
 */
public class StaffServiceImpl implements StaffService {
    StaffRepository staffRepository = new StaffRepositoryImpl();

    @Override
    public void addStaff(Staff staff) {
        staffRepository.addStaff(staff);
    }

    @Override
    public void removeStaffById(long id) {
        staffRepository.removeStaffById(id);
    }

    @Override
    public List<Staff> getStaffs() {
        return staffRepository.getStaffs();
    }
}
