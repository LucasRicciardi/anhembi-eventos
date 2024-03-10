package repositories;

import core.ModelFactoryInterface;
import core.Repository;
import factories.UsersFactory;
import models.User;

public class UsersRepository extends Repository<User> {

    protected String getDbFile() {
        return "users.db";
    }

    protected ModelFactoryInterface<User> getModelFactory() {
        return new UsersFactory();
    }

    public User getUserByEmail(String email) {
        for (User user : this.list()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
