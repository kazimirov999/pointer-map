import java.util.Objects;

public class Pet {

    private String namePet;
    private int weight;

    public Pet(String namePet, int weight) {
        this.namePet = namePet;
        this.weight = weight;
    }

    public String getNamePet() {
        return namePet;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "namePet='" + namePet + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return weight == pet.weight &&
                Objects.equals(namePet, pet.namePet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePet, weight);
    }
}
