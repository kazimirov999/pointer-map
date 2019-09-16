import java.util.*;

public class Zooclub {
    private List<Pet> list;
    private Map<Person, List<Pet>> map;

    public Zooclub() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    void addPerson(Person person) {
        map.putIfAbsent(person, new ArrayList<>());
    }

    void addPetToPerson(Person personName, Pet pet) {
        map.computeIfPresent(personName, (person, petList) -> {
            petList.add(pet);
            return petList;
        });
    }

    void removePetFromPerson(Person personName, Pet pet) {
        map.computeIfPresent(personName, (person, petList) -> {
            petList.remove(pet);
            return petList;
        });
    }

    void removePerson(Person personName) {
        map.remove(personName);
    }

    void removePetFromAllPersons(Pet pet) {
        for (Person person : map.keySet()) {
            list = map.get(person);
            list.remove(pet);
            map.replace(person, list);
        }

    }

    void printZooClub() {
        map.forEach((person, petList) -> System.out.println(person.toString() + " --> " + petList));
    }
}
