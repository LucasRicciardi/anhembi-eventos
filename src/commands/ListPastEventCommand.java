package commands;

import core.Command;
import models.Event;
import repositories.EventsRepository;

import java.time.LocalDateTime;

public class ListPastEventCommand extends Command {
    private EventsRepository eventsRepository = new EventsRepository();

    public void execute() {
        LocalDateTime currentTime = LocalDateTime.now();
        for (Event event : eventsRepository.list()) {
            if (event.getTime().isBefore(currentTime)) {
                System.out.println(event.toTableView() + "\n");
            }
        }
    }
}
