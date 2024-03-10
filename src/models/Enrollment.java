package models;

import core.Consts;
import core.Model;

public class Enrollment extends Model {
    private int userID;
    private int eventID;

    public Enrollment(int userID, int eventID) {
        this.userID = userID;
        this.eventID = eventID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String toString() {
        return this.getUserID() + Consts.SEPARATOR + this.getEventID();
    }

    @Override
    public String toTableView() {
        return "";
    }
}
