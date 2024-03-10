package commands;

import java.io.IOException;

import core.Command;
import models.User;
import repositories.UsersRepository;

public class CreateUserCommand extends Command {
    UsersRepository usersRepository = new UsersRepository();

    public void execute() {
        try {
            User newUser = this.getNewUserFromArgs();
            if (this.userAlreadyExists(newUser)) {
                System.out.println("Usuário já existe");
                return;
            }
            this.usersRepository.save(newUser);
            System.out.println("Usuário cadastrado com sucesso");
        } catch (IOException e) {
            System.out.println("Falha ao salvar novo usuário: " + e.getMessage());
        }
    }

    private Boolean userAlreadyExists(User newUser) {
        for (User user : this.usersRepository.list()) {
            if (user.getEmail().equals(newUser.getEmail())) {
                return true;
            }
        }
        return false;
    }

    private int getNextID() {
        return this.usersRepository.getTotalCount() + 1;
    }

    private User getNewUserFromArgs() {
        return new User(this.getNextID(), this.getInput("Digite o seu nome:"), this.getInput("Digite o seu email:"));
    }
}
