package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Service;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface ServiceRepository {
    void addService(Service service);

    void removeService(Service service);

    void updateService(Service service);

    List<Service> getServices();

    Service getServiceById(long id);

    void removeById(long id);
}
