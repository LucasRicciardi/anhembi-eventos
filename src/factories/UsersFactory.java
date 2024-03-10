package factories;

import core.Consts;
import core.ModelFactoryInterface;
import models.User;

public class UsersFactory implements ModelFactoryInterface<User> {

    public User fromString(String string) {
        String[] components = string.split(Consts.SEPARATOR);
        if (components.length != 3) {
            System.out.println("Falha ao criar usuário com entrada inválida " + string);
            return null;
        }
        return new User(Integer.parseInt(components[0]), components[1], components[2]);
    }
}
