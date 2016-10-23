package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 23.10.2016.
 */
public class Staff {
    private long id;
    private String position;

    public Staff(long id, String position) {
        this.id = id;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
