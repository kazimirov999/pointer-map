package pointer_map;

import java.util.*;

public class ZooClub {

    Map<Person, List<Pet>> listMap;
    public List<Pet> petList;
    Scanner scan = new Scanner(System.in);
    Pet pet;

    ZooClub() {
        this.listMap = new HashMap<>();
    }

    public ZooClub(Map<Person, List<Pet>> listMap) {
        this.listMap = listMap;
    }

    public Map<Person, List<Pet>> getListMap() {
        return listMap;
    }

    @Override
    public String toString() {
        return "ZooClub{" +
                "listMap=" + listMap +
                '}';
    }

    public void actionSelection() {
        System.out.println("action for vork: " + "\n"
                + "1 - add Person" + "\n"
                + "2 - add to Pet" + "\n"
                + "3 - deleted to Pet" + "\n"
                + "4 - deleted to Person" + "\n"
                + "5 - deleted Pet to the Person" + "\n"
                + "6 - list for club member");
        int s = scan.nextInt();
        switch (s) {
            case 1:
                System.out.println("added a name Person");
                addNewPerson(new Person(scan.next()));
                actionSelection();
            case 2:
                System.out.println("added Pet to Person");
                addPetToPerson(new Person(scan.next()));
                actionSelection();
            case 3:
                System.out.println("deleted to pet");
                remotePenInThePerson(new Pet(scan.next()));
                actionSelection();
            case 4:
                System.out.println("deleted to Person");
                remotePerson(new Person(scan.next()));
                actionSelection();
            case 5:
                System.out.println("added Person");
                deletedPetFromSpecificParticipant(new Person(scan.next()));
            case 6:
                listForClubMembers();
                return;
        }
    }

    private void addNewPerson(Person person) {
        if (listMap.containsKey(person)) {
            System.out.println("This man olready exist");
        } else {
            listMap.put(person, new ArrayList<Pet>());
            System.out.println("New Person created");
        }
    }

    private void addPetToPerson(Person person) {
        if (listMap.containsKey(person)) {
            System.out.println("Input Pet Name #1:");
            listMap.get(person).add(new Pet(scan.next()));
            System.out.println("New Pet created!");
            System.out.println(listMap.toString());
        } else {
            System.out.println("Error 2. Enter Person not found!");
        }
    }

    private void remotePerson(Person person) {
        if (listMap.containsKey(person)) {
            System.out.println("enter a name is deleted");
            listMap.remove(person);
            System.out.println("member deleted left" + listMap.toString() + "member");
            System.out.println("учасників " + listMap.size());
        } else {
            System.out.println("this member is not in the list");
            this.remotePerson(new Person(scan.next()));
        }
    }

    private void remotePenInThePerson(Pet pet) {
        for (Map.Entry<Person, List<Pet>> me : listMap.entrySet()) {
            me.getValue().remove(pet);
            System.out.println(me.toString());
        }
    }

    private void deletedPetFromSpecificParticipant(Person person){
        if (listMap.containsKey(person)){
            System.out.println("added neme Pet");
            listMap.get(person).remove(new Pet(scan.next()));
            System.out.println("name Pet " + scan.next() + " deleted");
        }else {
            System.out.println("no club member whith then name");
        }
    }

    private void listForClubMembers(){
        System.out.println(listMap.toString());
    }

}


