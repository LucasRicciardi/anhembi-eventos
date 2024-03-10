package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.Consts;
import core.Model;
import enums.EventCategory;

public class Event extends Model {
    private int id;
    private String name;
    private String address;
    private EventCategory category;
    private LocalDateTime time;
    private String description;

    public Event(int id, String name, String address, EventCategory category, LocalDateTime time, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.time = time;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public EventCategory getCategory() {
        return category;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return id + Consts.SEPARATOR + name + Consts.SEPARATOR + address + Consts.SEPARATOR + category
                + Consts.SEPARATOR + time + Consts.SEPARATOR + description;
    }

    public Boolean isEventHappening() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.isAfter(this.time) && currentDateTime.isBefore(this.time.plusMinutes(30));
    }

    public String toTableView() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Endereço: " + this.address + "\n" +
                "Categoria: " + this.category + "\n" +
                "Horário: " + this.time.format(formatter) + "\n" +
                "Descrição: " + this.description + "\n" +
                "Está acontecendo: " + (isEventHappening() ? "Sim" : "Não");
    }
}
