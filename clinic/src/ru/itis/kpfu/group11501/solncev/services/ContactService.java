package ru.itis.kpfu.group11501.solncev.services;

import ru.itis.kpfu.group11501.solncev.entities.Contact;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface ContactService {
    List<Contact> getContacts();

    void addContact(Contact contact);

    void removeContactById(long id);
}
