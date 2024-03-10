package core;

import java.util.HashMap;

public class Application {
    HashMap<String, Command> commands = new HashMap<>();

    public void addCommand(String key, Command command) {
        this.commands.put(key, command);
    }

    public void run(String[] args) {
        if (args.length < 1) {
            this.runCommand("help");
            return;
        }
        this.runCommand(args[0]);
    }

    private Boolean commandIsValid(String commandName) {
        return this.commands.get(commandName) != null;
    }

    private void runCommand(String commandName) {
        if (!this.commandIsValid(commandName)) {
            System.out.println("Command não reconhecido");
            return;
        }
        this.commands.get(commandName).execute();
    }

}
