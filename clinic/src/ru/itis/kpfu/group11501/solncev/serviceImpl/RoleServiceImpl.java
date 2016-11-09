package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Role;
import ru.itis.kpfu.group11501.solncev.repositories.RoleRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.RoleRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.RoleService;

import java.util.List;


/**
 * Created by Марат on 08.11.2016.
 */
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository = new RoleRepositoryImpl();

    @Override
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    @Override
    public void removeRoleById(long id) {
        roleRepository.removeRoleById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.getRoles();
    }
}
