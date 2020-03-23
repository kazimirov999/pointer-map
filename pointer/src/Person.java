import java.util.Objects;

public class Person {

    private String namePerson;
    private int agePerson;

    public Person(String namePerson, int agePerson) {
        this.namePerson = namePerson;
        this.agePerson = agePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public int getAgePerson() {
        return agePerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "namePerson='" + namePerson + '\'' +
                ", agePerson=" + agePerson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return agePerson == person.agePerson &&
                Objects.equals(namePerson, person.namePerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson, agePerson);
    }
}
