package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class Appointment {
    private long id;
    private long client_id;
    private long doctor_id;
    private String date;
    private String time;

    public Appointment(long doctor_id, long client_id, String date, String time) {
        this.doctor_id = doctor_id;
        this.client_id = client_id;
        this.date = date;
        this.time = time;
    }

    public Appointment(long id, long client_id, long doctor_id, String date, String time) {
        this.id = id;
        this.client_id = client_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.time = time;
    }


    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

}
