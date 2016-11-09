package ru.itis.kpfu.group11501.solncev.entities;

/**
 * Created by Марат on 07.11.2016.
 */
public class C_R {
    private long id;
    private long client_id;
    private long role_id;

    public C_R(long id, long client_id, long role_id) {
        this.id = id;
        this.client_id = client_id;
        this.role_id = role_id;
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

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }
}
