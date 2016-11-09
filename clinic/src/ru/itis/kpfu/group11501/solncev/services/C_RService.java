package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.C_R;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public interface C_RService {
    void addC_R(C_R c_r);

    void RemoveC_RById(long id);

    List<C_R> getC_Res();
}
