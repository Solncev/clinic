package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Client;
import ru.itis.kpfu.group11501.solncev.repositories.ClientRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.ClientRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.ClientService;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository = new ClientRepositoryImpl();

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getClients();
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.getClientByUsername(username);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.AddClient(client);
    }

    @Override
    public long getId(String login) {
        return clientRepository.getId(login);
    }

    @Override
    public String getNameByLogin(String login) {
        return clientRepository.getNameByLogin(login);
    }

    @Override
    public Boolean isLoginExist(String login) {
        return clientRepository.isLoginExist(login);
    }

    @Override
    public void removeClientById(long id) {
        clientRepository.removeClientById(id);
    }

    @Override
    public boolean idAdmin(String login) {
        return clientRepository.isAdmin(login);
    }

    @Override
    public void addClientWithoutId(Client client1) {
        clientRepository.addClientWithoutId(client1);
    }
}
