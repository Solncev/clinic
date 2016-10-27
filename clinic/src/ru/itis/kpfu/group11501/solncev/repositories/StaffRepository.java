package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Staff;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface StaffRepository {
    void addStaff(Staff staff);

    void removeStaff(Staff staff);

    void updateStaff(Staff staff);

    List<Staff> getStaffs();

    String getStaffById(long id);

    void removeStaffById(long id);
}
