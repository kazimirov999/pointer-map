package pointer.map;

import java.util.Scanner;

public enum Command {
    ADD, REMOVE, HELP, SHOW, EXIT;

    public static Command fromString(Scanner scanner) {
        try {
            return valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong command");
            scanner.nextLine();
            return fromString(scanner);
        }
    }
}
