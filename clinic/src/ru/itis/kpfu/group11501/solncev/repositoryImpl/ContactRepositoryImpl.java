package ru.itis.kpfu.group11501.solncev.repositoryImpl;

import ru.itis.kpfu.group11501.solncev.entities.Contact;
import ru.itis.kpfu.group11501.solncev.helpers.DBConnectionHelper;
import ru.itis.kpfu.group11501.solncev.repositories.ContactRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public class ContactRepositoryImpl implements ContactRepository {
    Connection connection = DBConnectionHelper.getConnection();

    @Override
    public void addContacts(Contact contact) {

    }

    @Override
    public void removeContacts(Contact contact) {

    }

    @Override
    public void updateContacts(Contact contact) {

    }

    @Override
    public List<Contact> getContacts() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from contacts;");
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                Contact contact = new Contact(
                        resultSet.getLong("id"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                );
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void addContact(Contact contact) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO contacts (id, phone_number, email,address) VALUES (?,?,?,?)"
            );
            ps.setLong(1, contact.getId());
            ps.setString(2, contact.getPhone_number());
            ps.setString(3, contact.getEmail());
            ps.setString(4, contact.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContactById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
