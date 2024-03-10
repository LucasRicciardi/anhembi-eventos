package commands;

import core.Command;
import models.Event;
import repositories.EventsRepository;

public class ListEventsCommand extends Command {
    EventsRepository eventsRepository = new EventsRepository();

    public void execute() {
        for (Event event : this.eventsRepository.list()) {
            System.out.println(event.toTableView() + "\n");
        }
    }

}
