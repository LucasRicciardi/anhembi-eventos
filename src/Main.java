import commands.CreateEventCommand;
import commands.CreateUserCommand;
import commands.EnrollUserToEventCommand;
import commands.ListEventsCommand;
import commands.ListPastEventCommand;
import commands.ListUserEnrollments;
import commands.ListUsersCommand;
import commands.UnenrollUserToEventCommand;
import core.Application;

public class Main {

    public static void main(String[] args) {
        Application application = new Application();

        application.addCommand("createUser", new CreateUserCommand());
        application.addCommand("listUsers", new ListUsersCommand());
        application.addCommand("createEvent", new CreateEventCommand());
        application.addCommand("listEvents", new ListEventsCommand());
        application.addCommand("listPastEvents", new ListPastEventCommand());
        application.addCommand("addUserToEvent", new EnrollUserToEventCommand());
        application.addCommand("removeUserFromEvent", new UnenrollUserToEventCommand());
        application.addCommand("listUserEvents", new ListUserEnrollments());

        application.run(args);
    }
}
