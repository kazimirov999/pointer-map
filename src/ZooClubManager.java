import java.util.Scanner;

public class ZooClubManager {

    private static Scanner scanner = new Scanner(System.in);

    static void start(Zooclub zooclub) {
        boolean isOn = true;
        while (isOn) {
            System.out.println("Choose function" +
                    "\n1 - Add person to map" +
                    "\n2 - Add pet to person" +
                    "\n3 - Remove pet from person" +
                    "\n4 - Remove person from map" +
                    "\n5 - Print all persons with pets" +
                    "\n0 - Exit");
            System.out.println("------------------------------------");
            int function = scanner.nextInt();
            switch (function) {
                case 1:
                    System.out.println("Input person's name:");
                    String personNameToAdd = scanner.next();
                    zooclub.addPerson(new Person(personNameToAdd));
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    System.out.println("Input person's name and pet's name");
                    String personNameForPet = scanner.next();
                    String petNameToAdd = scanner.next();
                    zooclub.addPetToPerson(new Person(personNameForPet), new Pet(petNameToAdd));
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    System.out.println("Input person's name and pet's name");
                    String personNameToRemovePet = scanner.next();
                    String petNameToRemove = scanner.next();
                    zooclub.removePetFromPerson(new Person(personNameToRemovePet), new Pet(petNameToRemove));
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    System.out.println("Input person's name:");
                    String personNameToRemove = scanner.next();
                    zooclub.removePerson(new Person(personNameToRemove));
                    break;
                case 5:
                    System.out.println("Input pet's name:");
                    String petNameToRemoveAllPets = scanner.next();
                    zooclub.removePetFromAllPersons(new Pet(petNameToRemoveAllPets));
                    break;
                case 6:
                    zooclub.printZooClub();
                    System.out.println("------------------------------------");
                    break;
                case 0:
                    isOn = false;
                    break;
                default:
                    System.out.println("Wrong function, choose again");
                    break;
            }
        }
    }
}
