package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 07.11.2016.
 */
public class Role {
    private long id;
    private String role;

    public Role(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
