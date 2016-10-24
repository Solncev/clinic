package ru.itis.kpfu.group11501.solncev.repositories;

import ru.itis.kpfu.group11501.solncev.entities.Contact;

import java.util.List;

/**
 * Created by Марат on 02.11.2016.
 */
public interface ContactRepository {
    void addContacts(Contact contact);

    void removeContacts(Contact contact);

    void updateContacts(Contact contact);

    List<Contact> getContacts();

    void addContact(Contact contact);

    void removeContactById(long id);
}
