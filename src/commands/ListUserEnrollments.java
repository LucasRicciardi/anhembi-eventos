package commands;

import core.Command;
import models.Enrollment;
import models.Event;
import models.User;
import repositories.EnrollmentsRepository;
import repositories.EventsRepository;
import repositories.UsersRepository;

public class ListUserEnrollments extends Command {
    private EnrollmentsRepository enrollmentsRepository = new EnrollmentsRepository();
    private EventsRepository eventsRepository = new EventsRepository();
    private UsersRepository usersRepository = new UsersRepository();

    public void execute() {
        User user = this.usersRepository.getUserByEmail(this.getInput("Digite o email do usuário:"));
        if (user == null) {
            System.out.println("Usuário não encontrado");
            return;
        }

        for (Enrollment enrollment : this.enrollmentsRepository.list()) {
            if (user.getId() == enrollment.getUserID()) {
                Event event = this.eventsRepository.getEventByID(String.valueOf(enrollment.getEventID()));
                if (event != null) {
                    System.out.println(event.toTableView() + "\n");
                }
            }
        }
    }
}
