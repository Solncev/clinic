package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.C_R;
import ru.itis.kpfu.group11501.solncev.repositories.C_RRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.C_RRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.C_RService;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public class C_RServiceImpl implements C_RService {
    C_RRepository c_rRepository = new C_RRepositoryImpl();

    @Override
    public void addC_R(C_R c_r) {
        c_rRepository.addC_R(c_r);
    }

    @Override
    public void RemoveC_RById(long id) {
        c_rRepository.RemoveC_RById(id);
    }

    @Override
    public List<C_R> getC_Res() {
        return c_rRepository.getC_Res();
    }
}
