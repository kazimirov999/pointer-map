package pointer.map;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        help();
        Command command = Command.fromString(scanner);

        while (command != Command.EXIT) {
            try {
                switch (command) {
                    case SHOW:
                        System.out.println(manager.getZoo());
                        break;

                    case ADD:
                        Creature type = Creature.fromString(scanner.next());
                        switch (type) {
                            case PERSON:
                                manager.addPerson(new Person(scanner.next(), scanner.nextInt()));
                                break;
                            case PET:
                                manager.addPetToPerson(new Person(scanner.next(), scanner.nextInt()),
                                        new Pet(scanner.next(), scanner.nextInt()));
                                break;
                        }
                        break;

                    case REMOVE:
                        type = Creature.fromString(scanner.next());
                        switch (type) {
                            case PERSON:
                                manager.removePerson(new Person(scanner.next(), scanner.nextInt()));
                                break;
                            case PET:
                                manager.removePetFromPerson(new Person(scanner.next(), scanner.nextInt()),
                                        new Pet(scanner.next(), scanner.nextInt()));
                                break;
                            case PETS:
                                manager.removePetFromAllPersons(new Pet(scanner.next(), scanner.nextInt()));
                                break;
                        }
                        break;

                    case HELP:
                        help();
                        break;
                }
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

    private static void help() {
        System.out.println("- add person <userName:String> <userAge:int>");
        System.out.println("- add pet <userName:String> <userAge:int> <petName:String> <petAge: int>");
        System.out.println("- remove person <userName:String> <userAge:int>");
        System.out.println("- remove pet <userName:String> <userAge:int> <petName:String> <petAge: int>");
        System.out.println("- remove pets <petName:String> <petAge: int>");
        System.out.println("- help");
        System.out.println("- exit");
    }
}
