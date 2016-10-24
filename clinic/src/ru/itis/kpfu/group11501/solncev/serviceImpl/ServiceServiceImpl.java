package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Service;
import ru.itis.kpfu.group11501.solncev.repositories.ServiceRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.ServiceRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.ServiceService;

import java.util.List;

/**
 * Created by Марат on 15.11.2016.
 */
public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public List<Service> getServices() {
        return serviceRepository.getServices();
    }

    @Override
    public Service getServiceById(long id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public void addService(Service service) {
        serviceRepository.addService(service);
    }

    @Override
    public void removeById(long id) {
        serviceRepository.removeById(id);
    }
}
