package commands;

import core.Command;
import models.User;
import repositories.UsersRepository;

public class ListUsersCommand extends Command {
    UsersRepository usersRepository = new UsersRepository();

    public void execute() {
        for (User user : this.usersRepository.list()) {
            System.out.println(user.toTableView() + "\n");
        }
    }
}
