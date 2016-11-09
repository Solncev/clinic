package ru.itis.kpfu.group11501.solncev.services;


import ru.itis.kpfu.group11501.solncev.entities.Role;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public interface RoleService {
    void addRole(Role role);

    void removeRoleById(long id);

    List<Role> getRoles();
}
