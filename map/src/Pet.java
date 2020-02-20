import java.util.Objects;

public class Pet {

    private String pet;

    public Pet(String pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet1 = (Pet) o;
        return Objects.equals(pet, pet1.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pet);
    }

    @Override
    public String toString() {
        return "" + pet;
    }
}
