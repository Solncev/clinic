package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Service;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface ServiceService {
    List<Service> getServices();

    Service getServiceById(long id);

    void addService(Service service);

    void removeById(long id);
}
