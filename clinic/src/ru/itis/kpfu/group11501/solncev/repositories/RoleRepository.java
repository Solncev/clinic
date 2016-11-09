package ru.itis.kpfu.group11501.solncev.repositories;


import ru.itis.kpfu.group11501.solncev.entities.Role;

import java.util.List;

/**
 * Created by Марат on 08.11.2016.
 */
public interface RoleRepository {
    long getRoleId(long clientId);

    String getRole(long role_id);

    void addRole(Role role);

    void removeRoleById(long id);

    List<Role> getRoles();
}
