package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class Comment {
    private long id;
    private long client_id;
    private String text;
    private String date;
    private String time;
    private String name;

    public Comment(long id, long client_id, String text, String date, String time) {
        this.id = id;
        this.client_id = client_id;
        this.text = text;
        this.date = date;
        this.time = time;
    }


    public Comment(long client_id, String text, String date) {
        this.client_id = client_id;
        this.text = text;
        this.date = date;
    }


    public Comment(long id, long client_id, String text, String date, String time, String name) {
        this.id = id;
        this.client_id = client_id;
        this.text = text;
        this.date = date;
        this.time = time;
        this.name = name;
    }

    public Comment(long client_id, String text, String date, String name) {
        this.client_id = client_id;
        this.text = text;
        this.date = date;
        this.name = name;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
