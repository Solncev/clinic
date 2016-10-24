package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Client;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface ClientRepository {
    void AddClient(Client client);

    void removeClient(Client client);

    void updateClient(Client client);

    List<Client> getClients();

    Client getClientByUsername(String username);

    String getNameByLogin(String login);

    Long getId(String username);

    Boolean isLoginExist(String login);

    void removeClientById(long id);

    boolean isAdmin(String login);
}
