package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 01.11.2016.
 */
public class Doctor {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String staff;
    private String speciality;
    private String photo;
    private String education;
    private String achievements;
    private int experience;
    private String certificate;


    public Doctor(long id, String surname, String name, String patronymic, String staff, String speciality,
                  String photo, String education, String achievements, int experience, String certificate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.staff = staff;
        this.speciality = speciality;
        this.photo = photo;
        this.education = education;
        this.achievements = achievements;
        this.experience = experience;
        this.certificate = certificate;
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

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
