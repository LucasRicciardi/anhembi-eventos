package core;

import java.util.Scanner;

public abstract class Command implements CommandInterface {
    protected static final Scanner scanner = new Scanner(System.in);

    final protected String getInput(String text) {
        System.out.println(text);
        String input = scanner.nextLine();
        return input;
    }

    public String getName() {
        return "";
    }

}
