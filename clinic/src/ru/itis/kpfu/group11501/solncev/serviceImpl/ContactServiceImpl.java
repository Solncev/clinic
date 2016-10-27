package ru.itis.kpfu.group11501.solncev.serviceImpl;

import ru.itis.kpfu.group11501.solncev.entities.Contact;
import ru.itis.kpfu.group11501.solncev.repositories.ContactRepository;
import ru.itis.kpfu.group11501.solncev.repositoryImpl.ContactRepositoryImpl;
import ru.itis.kpfu.group11501.solncev.services.ContactService;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.addContact(contact);
    }

    @Override
    public void removeContactById(long id) {
        contactRepository.removeContactById(id);
    }
}
