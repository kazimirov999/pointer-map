package pointer.map;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class Manager {
    private Map<Person, List<Pet>> map = new HashMap<>();

    public Map<Person, List<Pet>> getZoo() {
        return map;
    }

    public void addPerson(@NotNull Person person) {
        List<Pet> pets = map.putIfAbsent(person, new LinkedList<>());
        System.out.println(person + (Objects.isNull(pets) ? "exists" : " is added."));
    }

    public void addPetToPerson(@NotNull Person person, @NotNull Pet pet) {
        acceptToPerson(person, (pets) -> {
            pets.add(pet);
            System.out.println(pet + " is added to " + person);
        });
    }

    public void removePetFromPerson(@NotNull Person person, @NotNull Pet pet) {
        acceptToPerson(person, (pets) -> {
            pets.remove(pet);
            System.out.println(pet + " is removed from " + person);
        });
    }

    public void removePerson(@NotNull Person person) {
        List<Pet> pets = map.remove(person);
        System.out.println(person + (Objects.isNull(pets) ? " doesn't exist in Zoo" : " is removed."));
    }

    public void removePetFromAllPersons(@NotNull Pet pet) {
        map.values().forEach(list -> list.remove(pet));
        System.out.println(pet + " is removed from all persons.");
    }

    private void acceptToPerson(Person person, Consumer<List<Pet>> foo) {
        if (!map.containsKey(person)) {
            System.out.println("Zoo has no person: " + person);
            return;
        }

        foo.accept(map.get(person));
    }
}