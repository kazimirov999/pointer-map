package pointer_map;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Pet {
    String name;
    int age;

    public Pet(String name) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "його тварина " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) &&
                Objects.equals(age, pet.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

