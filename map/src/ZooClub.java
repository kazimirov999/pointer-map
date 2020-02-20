import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class ZooClub {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Map<Person, List<Pet>> map;

    public ZooClub() {
        this.map = new HashMap<>();
    }

    public void addPerson() throws IOException {
        System.out.println("Введіть учасника клубу");
        String person = reader.readLine().toUpperCase();
        if (map.containsKey(new Person(person))) {
            System.out.println("Сорян, такий учасник в клубі вже є");
        } else {
            map.put(new Person(person), new ArrayList<Pet>());
        }
    }

    public void addPet() throws IOException {
        System.out.println("Введіть учасника і його тваринку");
        String person = reader.readLine().toUpperCase();
        if (map.containsKey(new Person(person))) {
            map.get(new Person(person)).add(new Pet(reader.readLine().toUpperCase()));
        } else {
            System.out.println("Сорян, в нас немає такого учасника в клубі");
        }
    }

    public void removePet() throws IOException {
        System.out.println("Введіть учасника і тваринку яка здохла");
        String person = reader.readLine().toUpperCase();
        if (map.containsKey(new Person(person))) {
            map.get(new Person(person)).remove(new Pet(reader.readLine().toUpperCase()));
        } else {
            System.out.println("Сорян, в нас немає такого учасника в клубі");
        }
    }

    public void removePerson() throws IOException {
        System.out.println("Введіть учасника який відкинувася");
        map.remove(new Person(reader.readLine().toUpperCase()));
    }

    public void removeAllPet() throws IOException {
        System.out.println("Введіть тварин які повиздихували");
        String pet = reader.readLine().toUpperCase();
        Iterator<List<Pet>> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().remove(pet);
        }
    }

    public void printZoo() {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void menu() {
        System.out.println("Виберіть один із пунктів меню:\n" +
                "1. Додати учасника клубу\n" +
                "2. Додати тваринку до учасника клубу\n" +
                "3. Видалити тваринку з учасника клубу\n" +
                "4. Видалити учасника клубу\n" +
                "5. Видалити конкретну тваринку зі всіх власників\n" +
                "6. Вивести на екран зооклуб\n" +
                "0. Вийи з програми");
    }

}

