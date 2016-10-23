package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class News {
    private long id;
    private String photo;
    private String topic;
    private String text;
    private String date;
    private String time;

    public News(long id, String photo, String topic, String text, String date, String time) {
        this.id = id;
        this.photo = photo;
        this.topic = topic;
        this.text = text;
        this.date = date;
        this.time = time;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
}
