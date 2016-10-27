package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Staff;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface StaffService {
    void addStaff(Staff staff);

    void removeStaffById(long id);

    List<Staff> getStaffs();
}
