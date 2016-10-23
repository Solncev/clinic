package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class Service {
    private long id;
    private String name;
    private String text;
    private String photo;
    private int price;

    public Service(long id, String name, String text, String photo, int price) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.photo = photo;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
