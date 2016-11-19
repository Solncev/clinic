package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Client;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface ClientService {
    public List<Client> getAllClients();

    public Client getClientByUsername(String username);

    public void addClient(Client client);

    long getId(String login);

    String getNameByLogin(String login);

    Boolean isLoginExist(String login);

    void removeClientById(long id);

    boolean idAdmin(String login);

    void addClientWithoutId(Client client1);
}
