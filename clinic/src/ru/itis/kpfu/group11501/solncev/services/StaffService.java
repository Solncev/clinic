package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Staff;

import java.util.List;

/**
 * Created by Марат on 20.11.2016.
 */
public interface StaffService {
    void addStaff(Staff staff);

    void removeStaffById(long id);

    List<Staff> getStaffs();
}
