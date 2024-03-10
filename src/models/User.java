package models;

import core.Consts;
import core.Model;

public class User extends Model {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return this.getId() + Consts.SEPARATOR + this.getName() + Consts.SEPARATOR + this.getEmail();
    }

    @Override
    public String toTableView() {
        return "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Email: " + this.email;
    }
}
