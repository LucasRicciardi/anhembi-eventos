package factories;

import core.Consts;
import core.ModelFactoryInterface;
import enums.EventCategory;
import models.Event;
import java.time.LocalDateTime;

public class EventsFactory implements ModelFactoryInterface<Event> {
    public Event fromString(String string) {
        String[] components = string.split(Consts.SEPARATOR);
        if (components.length != 6) {
            System.out.println("Falha ao criar um evento com entrada inválida: " + string);
            return null;
        }

        int id = Integer.parseInt(components[0]);
        String name = components[1];
        String address = components[2];
        EventCategory category = EventCategory.valueOf(components[3]);
        LocalDateTime time = LocalDateTime.parse(components[4]);
        String description = components[5];

        return new Event(id, name, address, category, time, description);
    }
}
