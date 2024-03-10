package repositories;

import java.util.Collections;
import java.util.List;

import core.ModelFactoryInterface;
import core.Repository;
import factories.EventsFactory;
import models.Event;

public class EventsRepository extends Repository<Event> {
    protected String getDbFile() {
        return "events.db";
    }

    protected ModelFactoryInterface<Event> getModelFactory() {
        return new EventsFactory();
    }

    public List<Event> list() {
        List<Event> events = super.list();
        Collections.sort(events, (e1, e2) -> e1.getTime().compareTo(e2.getTime()));
        return events;
    }

    public Event getEventByID(String id) {
        for (Event event : this.list()) {
            if (String.valueOf(event.getId()).equals(id)) {
                return event;
            }
        }
        return null;
    }
}
