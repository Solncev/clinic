package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Service;

import java.util.List;

/**
 * Created by Марат on 15.11.2016.
 */
public interface ServiceService {
    List<Service> getServices();

    Service getServiceById(long id);

    void addService(Service service);

    void removeById(long id);
}
