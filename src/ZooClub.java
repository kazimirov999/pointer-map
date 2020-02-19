import java.util.*;

public class ZooClub {
    private Map<Person, List<Pet>> map;
    private List<Pet> petList;
    Scanner scanner = new Scanner(System.in);

    ZooClub() {
        this.map = new HashMap<>();
    }

    public Map<Person, List<Pet>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "ZooClub{" +
                "map=" + map +
                '}';
    }

    public void startProgram() {
<<<<<<< HEAD
        boolean programIsOn = true;
        while (programIsOn) {
            System.out.println("ZooClub application. beta 1.01.001\n" +
                    "Loading… ███████] 99%");
            System.out.println("Use numbers to select a command:");
            System.out.println("Press (1) Add Person to ZooClub\n" +
                    "Press (2) Add Pet to Person\n" +
                    "Press (3) Remove Pet from Person\n" +
                    "Press (4) Remove Person from ZooClub\n" +
                    "Press (5) Remove Pet from all Person\n" +
                    "Press (6) Print ZooClub with Person and all Pet\n" +
                    "Press (7) Exit\n");
            int command = scanner.nextInt();
=======
        System.out.println("ZooClub application. beta 1.01.001\n" +
                "Loading… ███████] 99%");
        System.out.println("Use numbers to select a command:");
        System.out.println("Press (1) Add Person to ZooClub\n" +
                "Press (2) Add Pet to Person\n" +
                "Press (3) Remove Pet from Person\n" +
                "Press (4) Remove Person from ZooClub\n" +
                "Press (5) Remove Pet from all Person\n" +
                "Press (6) Print ZooClub with Person and all Pet\n" +
                "Press (7) Exit\n");
        int command = scanner.nextInt();
        boolean programIsOn = true;
        while (programIsOn) {
>>>>>>> origin/master
            switch (command) {
                case 1:
                    System.out.println("Input Person name:");
                    addPerson(new Person(scanner.next()));
                    break;
                case 2:
                    System.out.println("Input Person name, to whom you want to add:");
                    addPetToPerson(new Person(scanner.next()));
                    break;
                case 3:
                    System.out.println("Input Person name:");
                    removePetFromPerson(new Person(scanner.next()));
                case 4:
                    System.out.println("Input Person name:");
                    removePerson(new Person(scanner.next()));
                case 5:
                    System.out.println("Input Pet Name:");
                    removePetFromAllPerson(new Pet(scanner.next()));
                case 6:
                    printZooClub();
                    break;
                case 7:
                    System.out.println("Exit.........");
                    programIsOn = false;
                    break;
                default:
                    System.out.println("Error 3. Wrong command!");
                    programIsOn = false;
            }
        }

    }

    public void addPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Error 1. This Person already exists!");
        } else {
            map.put(person, new ArrayList<Pet>());
            System.out.println("New Person created!");
        }
    }

    public void addPetToPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Input Pet Name:");
            map.get(person).add(new Pet(scanner.next()));
            System.out.println("New Pet created!");
        } else {
            System.out.println("Error 2. Enter Person not found!");
        }
    }

    public void removePetFromPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Input Pet Name:");
            map.get(person).remove(new Pet(scanner.next()));
            System.out.println("Your Pet remove!");
        } else {
            System.out.println("Error 2. Enter Person not found!");
        }
    }

    public void removePerson(Person person) {
        if (map.containsKey(person)) {
            map.remove(person);
        } else {
            System.out.println("Error 2. Enter Person not found!");
        }
    }

    public void removePetFromAllPerson(Pet pet) {
        for (Map.Entry<Person, List<Pet>> entry : map.entrySet()) {
            entry.getValue().remove(pet);
        }
    }

    public void printZooClub() {
        System.out.println(getMap());
    }


}

