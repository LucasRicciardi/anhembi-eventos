package commands;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.Command;
import enums.EventCategory;
import models.Event;
import repositories.EventsRepository;

public class CreateEventCommand extends Command {
    EventsRepository eventsRepository = new EventsRepository();

    public void execute() {
        try {
            this.eventsRepository.save(this.getNewEventFromArgs());
            System.out.println("Evento cadastrado com sucesso");
        } catch (IOException e) {
            System.out.println("Falha ao salvar novo evento: " + e.getMessage());
        }
    }

    private int getNextID() {
        return this.eventsRepository.getTotalCount() + 1;
    }

    private EventCategory selectEventCategory() {
        System.out.println("Selecione a categoria do evento:");
        EventCategory[] categories = EventCategory.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        int choice;
        do {
            choice = scanner.nextInt();
        } while (choice < 1 || choice > categories.length);
        return categories[choice - 1];
    }

    private LocalDateTime getEventDateTime() {
        System.out.println("Digite a data e hora do evento (no formato dd/MM/yyyy HH:mm):");
        scanner.nextLine();
        String dateTimeStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    private Event getNewEventFromArgs() {
        int id = this.getNextID();
        String name = this.getInput("Digite o nome do evento:");
        String address = this.getInput("Digite o endereço do evento:");
        EventCategory category = this.selectEventCategory();
        LocalDateTime time = this.getEventDateTime();
        String description = this.getInput("Digite a descrição do evento:");

        return new Event(id, name, address, category, time, description);

    }
}
