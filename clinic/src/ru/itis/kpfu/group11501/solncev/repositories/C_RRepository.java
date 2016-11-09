package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.C_R;

import java.util.List;

/**
 * Created by Марат on 08.11.2016.
 */
public interface C_RRepository {
    void addC_R(C_R c_r);

    void RemoveC_RById(long id);

    List<C_R> getC_Res();
}
