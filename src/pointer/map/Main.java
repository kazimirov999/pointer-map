package pointer.map;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {

    private static Map<Creature, BiConsumer<Manager, Scanner>> addMap = new HashMap<>();
    private static Map<Creature, BiConsumer<Manager, Scanner>> removeMap = new HashMap<>();
    private static Map<Command, BiConsumer<Manager, Scanner>> commandMap = new HashMap<>();

    static {
        addMap.put(Creature.PERSON, (manager, scanner) ->
                manager.addPerson(createPerson(scanner)));

        addMap.put(Creature.PET, (manager, scanner) ->
                manager.addPetToPerson(createPerson(scanner), createPet(scanner)));


        removeMap.put(Creature.PERSON, (manager, scanner) ->
                manager.removePerson(createPerson(scanner)));

        removeMap.put(Creature.PET, (manager, scanner) ->
                manager.removePetFromPerson(createPerson(scanner), createPet(scanner)));

        removeMap.put(Creature.PETS, (manager, scanner) ->
                manager.removePetFromAllPersons(createPet(scanner)));


        commandMap.put(Command.ADD, (manager, scanner) -> addMap.getOrDefault(Creature.fromString(scanner.next()),
                (m, s) -> System.out.println("Cannot do add"))
                .accept(manager, scanner));

        commandMap.put(Command.SHOW, (manager, scanner) -> System.out.println(manager.getZoo()));

        commandMap.put(Command.REMOVE, (manager, scanner) -> removeMap.getOrDefault(Creature.fromString(scanner.next()),
                (m, s) -> System.out.println("Cannot do remove."))
                .accept(manager, scanner));

        commandMap.put(Command.HELP, (manager, scanner) -> help());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        help();
        Command command = Command.fromString(scanner);

        while (command != Command.EXIT) {
            try {
                commandMap.get(command).accept(manager, scanner);
            } catch (IllegalArgumentException ex) {
                System.out.println("Wrong command type");
                scanner.nextLine();
            } catch (InputMismatchException imex) {
                System.out.println("Wrong parameter type. Try to use integer.");
                scanner.nextLine();
            } finally {
                command = Command.fromString(scanner);
            }
        }
    }

    private static Person createPerson(Scanner scanner) {
        return new Person(scanner.next(), scanner.nextInt());
    }

    private static Pet createPet(Scanner scanner) {
        return new Pet(scanner.next(), scanner.nextInt());
    }

    private static void help() {
        System.out.println("- add person <userName:String> <userAge:int>" +
                "- add pet <userName:String> <userAge:int> <petName:String> <petAge: int>" +
                "- remove person <userName:String> <userAge:int>" +
                "- remove pet <userName:String> <userAge:int> <petName:String> <petAge: int>" +
                "- remove pets <petName:String> <petAge: int>" +
                "- help" +
                "- exit");
    }
}