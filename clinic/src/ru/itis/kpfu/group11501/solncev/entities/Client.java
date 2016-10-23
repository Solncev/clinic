package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class Client {
    private long id;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private String birthDay;
    private String gender;
    private String mobile_number;
    private String OMS_number;

    public Client(long id, String login, String password, String surname, String name, String patronymic, String birthDay, String gender, String mobile_number, String OMS_number) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.OMS_number = OMS_number;
    }

    public Client(String login, String password, String surname, String name, String patronymic, String birthDay, String gender, String mobile_number, String OMS_number) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.OMS_number = OMS_number;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getOMS_number() {
        return OMS_number;
    }

    public void setOMS_number(String OMS_number) {
        this.OMS_number = OMS_number;
    }


}
