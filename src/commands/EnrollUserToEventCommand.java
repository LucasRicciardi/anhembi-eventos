package commands;

import java.io.IOException;

import core.Command;
import models.Enrollment;
import models.Event;
import models.User;
import repositories.EnrollmentsRepository;
import repositories.EventsRepository;
import repositories.UsersRepository;

public class EnrollUserToEventCommand extends Command {
    private EnrollmentsRepository enrollmentsRepository = new EnrollmentsRepository();
    private EventsRepository eventsRepository = new EventsRepository();
    private UsersRepository usersRepository = new UsersRepository();

    public void execute() {
        User user = this.usersRepository.getUserByEmail(this.getInput("Digite o email do usuário:"));
        if (user == null) {
            System.out.println("Usuário não encontrado");
            return;
        }

        Event event = this.eventsRepository.getEventByID(this.getInput("Digite o ID do evento:"));
        if (event == null) {
            System.out.println("Evento não encontrado");
            return;
        }

        for (Enrollment enrollment : this.enrollmentsRepository.list()) {
            if (enrollment.getUserID() == user.getId() && enrollment.getEventID() == event.getId()) {
                System.out.println("Usuário já registrado em evento");
                return;
            }
        }

        try {
            this.enrollmentsRepository.save(new Enrollment(user.getId(), event.getId()));
            System.out.println("Usuário registrado em evento com sucesso");
        } catch (IOException e) {
            System.out.println("Falha ao registrar usuário em evento: " + e.getMessage());
        }
    }
}
