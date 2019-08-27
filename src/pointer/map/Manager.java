package pointer.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Manager {
    private Map<Person, List<Pet>> map = new HashMap<>();

    public Map<Person, List<Pet>> getZoo() {
        return map;
    }

    public void addPerson(Person person) {
        List<Pet> pets = map.containsKey(person) ? map.get(person) : new LinkedList<>();

        map.put(person, pets);

        System.out.println(person + " is added.");
    }

    public void addPetToPerson(Person person, Pet pet) {
        if (hasNoPerson(person)) return;

        map.get(person).add(pet);
        System.out.println(pet + " is added to " + person);
    }

    public void removePetFromPerson(Person person, Pet pet) {
        if (hasNoPerson(person)) return;

        map.get(person).remove(pet);
        System.out.println(pet + " is removed from " + person);
    }

    public void removePerson(Person person) {
        if (hasNoPerson(person)) return;

        map.remove(person);
        System.out.println(person + " is removed.");
    }

    public void removePetFromAllPersons(Pet pet) {
        map.values().forEach(list -> list.remove(pet));
        System.out.println(pet + " is removed from all persons.");
    }

    private boolean hasNoPerson(Person person) {
        if (!map.containsKey(person)) {
            System.out.println(person + " doesn't exist in Zoo");
            return true;
        }
        return false;
    }
}